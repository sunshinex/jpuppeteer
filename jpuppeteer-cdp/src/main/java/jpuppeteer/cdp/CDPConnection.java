package jpuppeteer.cdp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.event.GenericEventEmitter;
import jpuppeteer.api.future.DefaultPromise;
import jpuppeteer.cdp.cdp.CDPEventType;
import jpuppeteer.cdp.constant.TargetType;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public abstract class CDPConnection implements Closeable {

    private static final Logger logger = LoggerFactory.getLogger(CDPConnection.class);

    protected static final String ID = "id";

    protected static final String METHOD = "method";

    protected static final String PARAMS = "params";

    protected static final String ERROR = "error";

    protected static final String RESULT = "result";

    private EventEmitter events;

    private final AtomicInteger messageId;

    protected final Map<Integer, RequestFuture> requestMap;

    private volatile Map<String/*sessionId*/, CDPSession> sessionMap;

    protected CDPConnection() {
        this.events = new GenericEventEmitter();
        this.messageId = new AtomicInteger(0);
        this.requestMap = new ConcurrentHashMap<>();
        this.sessionMap = new ConcurrentHashMap<>();
    }

    public CDPSession createSession(String sessionId) {
        CDPSession session = new CDPSession(this, TargetType.PAGE, sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private JSONObject sendBase(String method, Object params, Map<String, Object> extra, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        RequestFuture future = send0(method, params, extra);
        return future.get(timeout, TimeUnit.SECONDS);
    }

    private RequestFuture send0(String method, Object params, Map<String, Object> extra) {
        JSONObject json = new JSONObject();
        int id = messageId.getAndIncrement();
        //避免extra中的内容会覆盖ID, METHOD, PARAMS, 所以在前面先put进去
        if (MapUtils.isNotEmpty(extra)) {
            json.putAll(extra);
        }
        json.put(ID, id);
        json.put(METHOD, method);
        json.put(PARAMS, params);
        RequestFuture future = new RequestFuture(id);
        requestMap.put(id, future);
        logger.debug("==> send method={}, id={}, extra={}, params={}", method, id, JSON.toJSONString(extra), JSON.toJSONString(params));
        try {
            sendInternal(json);
        } catch (IOException ioe) {
            future.setFailure(ioe);
            logger.error("internal send error, error={}", ioe.getMessage(), ioe);
        }
        return future;
    }

    public void addListener(CDPEventType eventType, Consumer<CDPEvent> consumer) {
        events.addListener(CDPEventWrapper.wrap(eventType), consumer);
    }

    public void removeListener(CDPEventType eventType, Consumer<CDPEvent> consumer) {
        events.removeListener(CDPEventWrapper.wrap(eventType), consumer);
    }

    public void emit(CDPEventType eventType, CDPEvent event) {
        events.emit(CDPEventWrapper.wrap(eventType), event);
    }

    public final <T> T send(String method, Object params, Map<String, Object> extra, Class<T> clazz, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject result = sendBase(method, params, extra, timeout);
        return JSONObject.class.equals(clazz) ? (T) result : result.toJavaObject(clazz);
    }

    public final <T> T send(String method, Object params, Map<String, Object> extra, TypeReference<T> type, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject result = sendBase(method, params, extra, timeout);
        return type.getType().equals(JSONObject.class) ? (T) result : result.toJavaObject(type);
    }

    public final void send(String method, Object params, Map<String, Object> extra, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        sendBase(method, params, extra, timeout);
    }

    public final <T> T send(String method, Object params, Class<T> clazz, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject result = sendBase(method, params, null, timeout);
        return JSONObject.class.equals(clazz) ? (T) result : result.toJavaObject(clazz);
    }

    public final <T> T send(String method, Object params, TypeReference<T> type, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject result = sendBase(method, params, null, timeout);
        return type.getType().equals(JSONObject.class) ? (T) result : result.toJavaObject(type);
    }

    public final void send(String method, Object params, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        sendBase(method, params, null, timeout);
    }

    public final Future<JSONObject> asyncSend(String method, Object params, Map<String, Object> extra) {
        return send0(method, params, extra);
    }

    private void handleEvent(JSONObject json) {
        String method = json.getString(METHOD);
        CDPEventType eventType = CDPEventType.findByValue(method);
        if (eventType == null) {
            logger.error("discard unknown event [{}]", method);
            return;
        }
        CDPEvent event = json.toJavaObject(CDPEvent.class);
        String sessionId = event.getSessionId();
        //所有的事件都dispatch到connection上
        emit(eventType, event);
        if (StringUtils.isNotEmpty(sessionId)) {
            CDPSession session = sessionMap.get(sessionId);
            if (session == null) {
                logger.error("unable find session, id={}", sessionId);
            } else {
                session.emit(eventType, event);
            }
        } else {
            //通用事件dispatch到所有的session上
            sessionMap.values().iterator().forEachRemaining(session -> session.emit(eventType, event));
        }
    }

    protected void recv(String message) {
        logger.debug("<== recv message={}", message);
        JSONObject json = JSON.parseObject(message);
        if (json.containsKey(METHOD)) {
            //这种格式的就是event notification
            handleEvent(json);
            return;
        }
        if (!json.containsKey(ID)) {
            //没有ID就是异常的返回
            throw new IllegalArgumentException("attribute \"id\" can not be null");
        }
        Integer id = json.getInteger(ID);
        RequestFuture future = requestMap.get(id);
        if (future == null) {
            throw new RuntimeException("invalid id="+id);
        }
        if (json.containsKey(ERROR)) {
            JSONObject error = json.getJSONObject(ERROR);
            future.setFailure(new CDPException(error.getIntValue("code"), error.getString("message")));
        } else {
            future.setSuccess(json.getJSONObject(RESULT));
        }
    }

    public abstract void open() throws IOException, InterruptedException;

    protected abstract void sendInternal(JSONObject request) throws IOException;

    class RequestFuture extends DefaultPromise<JSONObject> {

        private final int id;

        public RequestFuture(int id) {
            this.id = id;
        }

        @Override
        public JSONObject get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            try {
                return super.get(timeout, unit);
            } finally {
                requestMap.remove(id);
            }
        }

        @Override
        public JSONObject get() throws InterruptedException, ExecutionException {
            try {
                return super.get();
            } finally {
                requestMap.remove(id);
            }
        }
    }

}
