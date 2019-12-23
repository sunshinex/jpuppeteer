package jpuppeteer.cdp;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.event.AbstractEventEmitter;
import jpuppeteer.cdp.cdp.CDPEventType;
import jpuppeteer.cdp.constant.TargetType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

public class CDPSession extends AbstractEventEmitter implements EventEmitter {

    private static final String SESSION_ID = "sessionId";

    private CDPConnection connection;

    private TargetType type;

    private String sessionId;

    private Map<String, Object> extra;

    public CDPSession(CDPConnection connection, TargetType type, String sessionId) {
        super(Executors.newSingleThreadExecutor(THREAD_FACTORY));
        this.connection = connection;
        this.type = type;
        this.sessionId = sessionId;
        this.extra = new HashMap<>();
        this.extra.put(SESSION_ID, sessionId);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void addListener(CDPEventType eventType, Consumer<CDPEvent> consumer) {
        addListener(CDPEventWrapper.wrap(eventType), consumer);
    }

    public void removeListener(CDPEventType eventType, Consumer<CDPEvent> consumer) {
        removeListener(CDPEventWrapper.wrap(eventType), consumer);
    }

    public void emit(CDPEventType eventType, CDPEvent event) {
        emit(CDPEventWrapper.wrap(eventType), event);
    }

    public final <T> T send(String method, Object params, Class<T> clazz, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        return connection.send(method, params, extra, clazz, timeout);
    }

    public final <T> T send(String method, Object params, TypeReference<T> type, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        return connection.send(method, params, extra, type, timeout);
    }

    public final void send(String method, Object params, int timeout) throws InterruptedException, ExecutionException, TimeoutException {
        connection.send(method, params, extra, timeout);
    }

    public final Future<JSONObject> asyncSend(String method, Object params) {
        return connection.asyncSend(method, params, extra);
    }

}