package jpuppeteer.chrome;

import com.alibaba.fastjson.JSONObject;
import jpuppeteer.api.browser.Browser;
import jpuppeteer.api.browser.BrowserContext;
import jpuppeteer.api.browser.Cookie;
import jpuppeteer.api.event.DefaultEventEmitter;
import jpuppeteer.api.future.Promise;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.WebSocketCDPConnection;
import jpuppeteer.cdp.cdp.CDPEventType;
import jpuppeteer.cdp.cdp.domain.Network;
import jpuppeteer.cdp.cdp.domain.Target;
import jpuppeteer.cdp.cdp.entity.browser.GetVersionResponse;
import jpuppeteer.cdp.cdp.entity.network.DeleteCookiesRequest;
import jpuppeteer.cdp.cdp.entity.network.GetAllCookiesResponse;
import jpuppeteer.cdp.cdp.entity.network.SetCookiesRequest;
import jpuppeteer.cdp.cdp.entity.target.*;
import jpuppeteer.cdp.constant.TargetType;
import jpuppeteer.chrome.event.type.ChromeBrowserEvent;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import jpuppeteer.chrome.util.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static jpuppeteer.cdp.cdp.CDPEventType.*;

public class ChromeBrowser extends DefaultEventEmitter<ChromeBrowserEvent> implements Browser {

    private static final Logger logger = LoggerFactory.getLogger(ChromeBrowser.class);

    //private static final String DEFAULT_URL = "about:blank";

    public static final int DEFAULT_TIMEOUT = 30;

    private static final String DEFAULT_CONTEXT_ID = "0";

    protected final String name;

    private CDPConnection connection;

    private Map<String/*browserContextId*/, ChromeContext> contextMap;

    /**
     * 用来维护target跟context的关联关系, 以便发送事件的时候能快速找到对应的context
     */
    private Map<String/*targetId*/, ChromeContext> targetMap;

    /**
     * 用来维护session跟context的关联关系, 以便发送事件的时候能快速找到对应的context
     */
    private Map<String/*sessionId*/, ChromeContext> sessionMap;

    private Process process;

    private jpuppeteer.cdp.cdp.domain.Browser browser;

    private Target target;

    public ChromeBrowser(String name, Process process, CDPConnection connection) throws Exception {
        super(Executors.newSingleThreadExecutor(r -> new Thread(r, "ChromeBrowser["+name+"]")));
        this.name = name;
        this.process = process;
        this.connection = connection;
        this.browser = new jpuppeteer.cdp.cdp.domain.Browser(connection);
        this.target = new Target(connection);
        this.setDiscoverTargets(true);
        this.contextMap = new ConcurrentHashMap<>();
        this.contextMap.put(DEFAULT_CONTEXT_ID, new ChromeContext(this, null));
        this.targetMap = new ConcurrentHashMap<>();
        this.sessionMap = new ConcurrentHashMap<>();
        //绑定事件
        connection.addListener(TARGET_TARGETCREATED, (CDPEvent event) -> {
            TargetCreatedEvent evt = event.getObject(TargetCreatedEvent.class);
            TargetInfo targetInfo = evt.getTargetInfo();
            TargetType targetType = TargetType.findByValue(targetInfo.getType());
            if (!(TargetType.PAGE.equals(targetType))) {
                logger.debug("target is not page, ignore! type={}, targetId={}, url={}", targetInfo.getType(), targetInfo.getTargetId(), targetInfo.getUrl());
                return;
            }
            emit(ChromeBrowserEvent.TARGETCREATED, evt);
            String targetId = targetInfo.getTargetId();
            try {
                //对所有创建的页面, 自动附加
                String sessionId = attachToTarget(targetId);
                logger.info("attach target success, targetId={}, sessionId={}", targetId, sessionId);
            } catch (Exception e) {
                //当target尝试attach失败的时候关闭target, 因为已经没有用了
                logger.error("attach target failed, targetId={}, error={}", targetId, e.getMessage(), e);
                try {
                    closeTarget(targetId);
                } catch (Exception e1) {
                    logger.error("try close attach failed target failed, targetId={}, error={}", targetId, e1.getMessage(), e1);
                }
            }
        });
        connection.addListener(TARGET_ATTACHEDTOTARGET, (CDPEvent event) -> {
            AttachedToTargetEvent evt = event.getObject(AttachedToTargetEvent.class);
            TargetInfo target = evt.getTargetInfo();
            String sessionId = event.getSessionId();
            String targetId = target.getTargetId();
            TargetType targetType = TargetType.findByValue(target.getType());
            logger.info("target attached, targetId={}, sessionId={}", targetId, sessionId);
//
//            String openerId = target.getOpenerId();
//            ChromePage opener = null;
//            if (StringUtils.isNotEmpty(openerId)) {
//                opener = pageMap.get(openerId);
//                if (opener == null) {
//                    logger.error("target opener not found, openerId={}, targetId={}", openerId, targetId);
//                    return;
//                }
//            }
//            Promise<ChromePage> promise = promiseMap.get(targetId);
//            try {
//                ChromePage page = new ChromePage(browser.getName(), this, new CDPSession(connection, targetType, sessionId), targetId, opener, sessionId);
//                if (pageMap.put(targetId, page) != null) {
//                    logger.warn("target exists, targetId={}", targetId);
//                }
//                if (sessionMap.put(sessionId, page) != null) {
//                    logger.warn("session exists, sessionId={}", sessionId);
//                }
//                requestMap.put(sessionId, new ConcurrentHashMap<>());
//                if (promise != null) {
//                    promise.setSuccess(page);
//                }
//                if (opener != null) {
//                    opener.emit(ChromePageEvent.OPENPAGE, page);
//                }
//            } catch (Exception e) {
//                if (promise != null) {
//                    promise.setFailure(e);
//                }
//                logger.error("create page instance failed, error={}", e.getMessage(), e);
//            }
        });

//        for(ChromeBrowserEvent event : ChromeBrowserEvent.values()) {
//            connection.addListener(event.getEventType(), (CDPEvent object) -> emit(event, object));
//        }
//        //找到默认的标签页
//        String defaultTargetId = null;
//        for(TargetInfo targetInfo : getTargets()) {
//            TargetType targetType = TargetType.findByValue(targetInfo.getType());
//            if (TargetType.PAGE.equals(targetType)) {
//                defaultTargetId = targetInfo.getTargetId();
//            }
//        }
//        //如果没有找到默认的标签页, 则创建一个
//        if (defaultTargetId == null) {
//            defaultTargetId = createTarget(null);
//        }
//        //给默认标签页附加devtools
//        String sessionId = attachToTarget(defaultTargetId);
//        defaultSession = new CDPSession(connection, TargetType.PAGE, sessionId);
//        this.network = new Network(defaultSession);
    }
//
//    /**
//     * 只对已经存在的页面生效
//     * @param autoAttach
//     * @throws Exception
//     */
//    protected void setAutoAttach(boolean autoAttach) throws Exception {
//        SetAutoAttachRequest request = new SetAutoAttachRequest();
//        request.setAutoAttach(autoAttach);
//        request.setFlatten(true);
//        request.setWaitForDebuggerOnStart(false);
//        this.target.setAutoAttach(request, DEFAULT_TIMEOUT);
//    }
//
//    protected void activateTarget(String targetId) throws Exception {
//        ActivateTargetRequest request = new ActivateTargetRequest();
//        request.setTargetId(targetId);
//        target.activateTarget(request, DEFAULT_TIMEOUT);
//    }
//
    protected String attachToTarget(String targetId) throws Exception {
        AttachToTargetRequest request = new AttachToTargetRequest();
        request.setTargetId(targetId);
        request.setFlatten(true);
        AttachToTargetResponse response = target.attachToTarget(request, DEFAULT_TIMEOUT);
        return response.getSessionId();
    }

    protected boolean closeTarget(String targetId) throws Exception {
        CloseTargetRequest request = new CloseTargetRequest();
        request.setTargetId(targetId);
        CloseTargetResponse response = target.closeTarget(request, DEFAULT_TIMEOUT);
        return response.getSuccess();
    }
//
//    protected String createTarget(String browserContextId) throws Exception {
//        CreateTargetRequest request = new CreateTargetRequest();
//        request.setUrl(DEFAULT_URL);
//        request.setBrowserContextId(browserContextId);
//        CreateTargetResponse response = target.createTarget(request, DEFAULT_TIMEOUT);
//        return response.getTargetId();
//    }
//
//    protected void detachFromTarget(String sessionId) throws Exception {
//        DetachFromTargetRequest request = new DetachFromTargetRequest();
//        request.setSessionId(sessionId);
//        target.detachFromTarget(request, DEFAULT_TIMEOUT);
//    }
//
//    protected List<TargetInfo> getTargets() throws Exception {
//        GetTargetsResponse response = target.getTargets(DEFAULT_TIMEOUT);
//        return response.getTargetInfos();
//    }
//
//    protected void sendMessageToTarget(String sessionId, String message) throws Exception {
//        SendMessageToTargetRequest request = new SendMessageToTargetRequest();
//        request.setSessionId(sessionId);
//        request.setMessage(message);
//        target.sendMessageToTarget(request, DEFAULT_TIMEOUT);
//    }
//
    protected void setDiscoverTargets(boolean discover) throws Exception {
        SetDiscoverTargetsRequest request = new SetDiscoverTargetsRequest();
        request.setDiscover(discover);
        target.setDiscoverTargets(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void close() throws Exception {
        //@TODO 需要先关闭所有的context
        browser.close(DEFAULT_TIMEOUT);
    }

    @Override
    public ChromeContext[] browserContexts() {
        Collection<ChromeContext> contextValues = contextMap.values();
        ChromeContext[] contexts = new ChromeContext[contextValues.size()];
        return contextValues.toArray(contexts);
    }

    @Override
    public ChromeContext createContext() throws Exception {
        CreateBrowserContextResponse response = target.createBrowserContext(DEFAULT_TIMEOUT);
        String contextId = response.getBrowserContextId();
        try {
            ChromeContext context = new ChromeContext(this, contextId);
            contextMap.put(contextId, context);
            return context;
        } catch (Exception e) {
            DisposeBrowserContextRequest request = new DisposeBrowserContextRequest();
            request.setBrowserContextId(contextId);
            target.disposeBrowserContext(request, DEFAULT_TIMEOUT);
            throw e;
        }
    }

    @Override
    public ChromeContext defaultContext() {
        return contextMap.get(DEFAULT_CONTEXT_ID);
    }

    @Override
    public String userAgent() throws Exception {
        GetVersionResponse response = browser.getVersion(DEFAULT_TIMEOUT);
        return response.getUserAgent();
    }

    @Override
    public String version() throws Exception {
        GetVersionResponse response = browser.getVersion(DEFAULT_TIMEOUT);
        return response.getProduct();
    }

    @Override
    public URI wsEndpoint() {
        return connection instanceof WebSocketCDPConnection ? ((WebSocketCDPConnection) connection).uri() : null;
    }

    @Override
    public Process process() {
        return this.process;
    }

//    @Override
//    public void setCookie(Cookie... cookies) throws Exception {
//        SetCookiesRequest request = CookieUtils.create(cookies);
//        network.setCookies(request, DEFAULT_TIMEOUT);
//    }
//
//    @Override
//    public void deleteCookie(Cookie... cookies) throws Exception {
//        //此处需要异步实现
//        List<Future<JSONObject>> futures = new ArrayList<>();
//        for(Cookie cookie : cookies) {
//            DeleteCookiesRequest request = new DeleteCookiesRequest();
//            request.setName(cookie.getName());
//            request.setDomain(cookie.getDomain());
//            request.setPath(cookie.getPath());
//            request.setUrl(cookie.getUrl());
//            futures.add(defaultSession.asyncSend("Network.deleteCookies", request));
//        }
//        for(Future<JSONObject> future : futures) {
//            future.get(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
//        }
//    }
//
//    @Override
//    public void clearCookie() throws Exception {
//        network.clearBrowserCookies(DEFAULT_TIMEOUT);
//    }
//
//    @Override
//    public List<Cookie> cookies() throws Exception {
//        GetAllCookiesResponse response = network.getAllCookies(DEFAULT_TIMEOUT);
//        return response.getCookies().stream().map(cookie -> CookieUtils.copyOf(cookie)).collect(Collectors.toList());
//    }
}
