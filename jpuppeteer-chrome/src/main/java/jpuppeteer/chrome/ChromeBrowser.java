package jpuppeteer.chrome;

import com.google.common.collect.MapMaker;
import jpuppeteer.api.browser.Browser;
import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.WebSocketCDPConnection;
import jpuppeteer.cdp.cdp.CDPEventType;
import jpuppeteer.cdp.cdp.domain.Storage;
import jpuppeteer.cdp.cdp.domain.Target;
import jpuppeteer.cdp.cdp.entity.browser.GetVersionResponse;
import jpuppeteer.cdp.cdp.entity.browser.GrantPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.browser.ResetPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.network.Cookie;
import jpuppeteer.cdp.cdp.entity.network.CookieParam;
import jpuppeteer.cdp.cdp.entity.storage.ClearCookiesRequest;
import jpuppeteer.cdp.cdp.entity.storage.GetCookiesRequest;
import jpuppeteer.cdp.cdp.entity.storage.GetCookiesResponse;
import jpuppeteer.cdp.cdp.entity.storage.SetCookiesRequest;
import jpuppeteer.cdp.cdp.entity.target.*;
import jpuppeteer.cdp.constant.TargetType;
import jpuppeteer.chrome.event.type.ChromeContextEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static jpuppeteer.cdp.cdp.CDPEventType.*;

public class ChromeBrowser implements EventEmitter<CDPEventType>, Browser {

    private static final Logger logger = LoggerFactory.getLogger(ChromeBrowser.class);

    private static final String DEFAULT_URL = "about:blank";

    public static final int DEFAULT_TIMEOUT = 30;

    private final String name;

    private final AtomicInteger contextCounter;

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

    private ChromeContext defaultContext;

    private Storage storage;

    public ChromeBrowser(String name, Process process, CDPConnection connection) throws Exception {
        this.name = name;
        this.contextCounter = new AtomicInteger(0);
        this.process = process;
        this.connection = connection;
        this.browser = new jpuppeteer.cdp.cdp.domain.Browser(connection);
        this.target = new Target(connection);
        this.storage = new Storage(connection);
        this.defaultContext = new ChromeContext(nextContextName(), this, null);
        MapMaker mapMaker = new MapMaker().weakValues().concurrencyLevel(16);
        this.contextMap = mapMaker.makeMap();
        this.contextMap.put(this.defaultContext.defaultPage().targetInfo().getBrowserContextId(), this.defaultContext);
        this.targetMap = mapMaker.makeMap();
        this.sessionMap = mapMaker.makeMap();

        //此方法必须等默认上下文创建好了之后才能调用true
        this.setDiscoverTargets(true);

        //监听事件
        addListener(TARGET_TARGETCREATED, (CDPEvent event) -> handleTargetCreated(event));
        addListener(TARGET_ATTACHEDTOTARGET, (CDPEvent event) -> handleTargetAttached(event));
        addListener(TARGET_TARGETDESTROYED, (CDPEvent event) -> handleTargetDestroyed(event));
        addListener(TARGET_TARGETINFOCHANGED, (CDPEvent event) -> handleTargetChanged(event));
        addListener(TARGET_TARGETCRASHED, (CDPEvent event) -> handleTargetCrashed(event));
        //传递事件
        transmitSessionEvent(PAGE_LIFECYCLEEVENT, ChromeContextEvent.LIFECYCLEEVENT);
        transmitSessionEvent(PAGE_DOMCONTENTEVENTFIRED, ChromeContextEvent.DOMCONTENTEVENTFIRED);
        transmitSessionEvent(PAGE_LOADEVENTFIRED, ChromeContextEvent.LOADEVENTFIRED);
        transmitSessionEvent(PAGE_FRAMEATTACHED, ChromeContextEvent.FRAMEATTACHED);
        transmitSessionEvent(PAGE_FRAMEDETACHED, ChromeContextEvent.FRAMEDETACHED);
        transmitSessionEvent(PAGE_FRAMENAVIGATED, ChromeContextEvent.FRAMENAVIGATED);
        transmitSessionEvent(PAGE_JAVASCRIPTDIALOGOPENING, ChromeContextEvent.JAVASCRIPTDIALOGOPENING);
        transmitSessionEvent(NETWORK_REQUESTWILLBESENT, ChromeContextEvent.REQUESTWILLBESENT);
        transmitSessionEvent(NETWORK_RESPONSERECEIVED, ChromeContextEvent.RESPONSERECEIVED);
        transmitSessionEvent(NETWORK_LOADINGFAILED, ChromeContextEvent.LOADINGFAILED);
        transmitSessionEvent(NETWORK_LOADINGFINISHED, ChromeContextEvent.LOADINGFINISHED);
        transmitSessionEvent(RUNTIME_EXCEPTIONTHROWN, ChromeContextEvent.EXCEPTIONTHROWN);
        transmitSessionEvent(RUNTIME_EXECUTIONCONTEXTCREATED, ChromeContextEvent.EXECUTIONCONTEXTCREATED);
        transmitSessionEvent(RUNTIME_EXECUTIONCONTEXTDESTROYED, ChromeContextEvent.EXECUTIONCONTEXTDESTROYED);
        transmitSessionEvent(RUNTIME_EXECUTIONCONTEXTSCLEARED, ChromeContextEvent.EXECUTIONCONTEXTSCLEARED);
        transmitSessionEvent(FETCH_REQUESTPAUSED, ChromeContextEvent.REQUESTPAUSED);
        transmitSessionEvent(FETCH_AUTHREQUIRED, ChromeContextEvent.AUTHREQUIRED);
        transmitSessionEvent(LOG_ENTRYADDED, ChromeContextEvent.ENTRYADDED);
    }


    @Override
    public void addListener(CDPEventType type, Consumer<?> consumer) {
        connection.addListener(type, consumer);
    }

    @Override
    public void removeListener(CDPEventType type, Consumer<?> consumer) {
        connection.addListener(type, consumer);
    }

    @Override
    public void emit(CDPEventType type, Object event) {
        connection.emit(type, event);
    }

    private void transmitSessionEvent(CDPEventType from, ChromeContextEvent to) {
        addListener(from, (CDPEvent event) -> {
            String sessionId = event.getSessionId();
            ChromeContext context = sessionMap.get(sessionId);
            if (context == null) {
                logger.error("transmit event failed:context not found, event={} sessionId={}", from.getName(), sessionId);
                return;
            }
            context.emit(to, event);
        });
    }

    private void handleTargetCreated(CDPEvent event) {
        TargetCreatedEvent evt = event.getObject(TargetCreatedEvent.class);
        TargetInfo targetInfo = evt.getTargetInfo();
        TargetType targetType = TargetType.findByValue(targetInfo.getType());
        if (!TargetType.PAGE.equals(targetType)) {
            logger.debug("target is not page, ignore! type={}, targetId={}, url={}", targetInfo.getType(), targetInfo.getTargetId(), targetInfo.getUrl());
            return;
        }
        String targetId = targetInfo.getTargetId();
        String contextId = targetInfo.getBrowserContextId();
        ChromeContext context = contextMap.get(contextId);
        if (context == null) {
            logger.error("target created failed: context not found, targetId={}, contextId={}", targetId, contextId);
            return;
        }
        String sessionId = null;
        try {
            //对所有创建的页面, 自动附加
            sessionId = attachToTarget(targetId);
            targetMap.put(targetId, context);
            sessionMap.put(sessionId, context);
            context.emit(ChromeContextEvent.TARGETCREATED, targetInfo);
            logger.info("attach target success, targetId={}, sessionId={}", targetId, sessionId);
        } catch (Exception e) {
            //当target尝试attach失败的时候关闭target, 因为已经没有用了
            logger.error("attach target failed, targetId={}, error={}", targetId, e.getMessage(), e);
            targetMap.remove(targetId);
            if (sessionId != null) {
                sessionMap.remove(sessionId);
            }
            try {
                closeTarget(targetId);
            } catch (Exception e1) {
                logger.error("try close attach failed target failed, targetId={}, error={}", targetId, e1.getMessage(), e1);
            }
        }
    }

    private void handleTargetAttached(CDPEvent event) {
        AttachedToTargetEvent evt = event.getObject(AttachedToTargetEvent.class);
        TargetInfo target = evt.getTargetInfo();
        String targetId = target.getTargetId();
        String contextId = target.getBrowserContextId();
        ChromeContext context = contextMap.get(contextId);
        if (context == null) {
            logger.error("target attached failed, context not found, targetId={}, contextId={}", targetId, contextId);
            return;
        }
        context.emit(ChromeContextEvent.ATTACHEDTOTARGET, evt);
        logger.info("target attached, targetId={}", targetId);
    }

    private void handleTargetDestroyed(CDPEvent event) {
        TargetDestroyedEvent evt = event.getObject(TargetDestroyedEvent.class);
        String targetId = evt.getTargetId();
        ChromeContext context = targetMap.get(targetId);
        if (context == null) {
            //此处有可能不是page类型的target, 但是无法作出判断, 先忽略错误日志的输出
            //logger.error("target destroyed failed, context not found, targetId={}", targetId);
            return;
        }
        targetMap.remove(targetId);
        //@TODO 此处没有从sessionMap中移除, 等gc的时候清除
        context.emit(ChromeContextEvent.TARGETDESTROYED, targetId);
        logger.info("target destoryed, targetId={}", targetId);
    }

    private void handleTargetChanged(CDPEvent event) {
        TargetInfoChangedEvent evt = event.getObject(TargetInfoChangedEvent.class);
        TargetInfo targetInfo = evt.getTargetInfo();
        String targetId = targetInfo.getTargetId();
        TargetType targetType = TargetType.findByValue(targetInfo.getType());
        if (!(TargetType.PAGE.equals(targetType))) {
            logger.debug("target is not page, ignore! type={}, targetId={}, url={}", targetInfo.getType(), targetInfo.getTargetId(), targetInfo.getUrl());
            return;
        }
        ChromeContext context = targetMap.get(targetId);
        if (context == null) {
            logger.error("target info changed failed, context not found, targetId={}", targetId);
            return;
        }
        context.emit(ChromeContextEvent.TARGETINFOCHANGED, targetInfo);
    }

    private void handleTargetCrashed(CDPEvent event) {
        TargetCrashedEvent evt = event.getObject(TargetCrashedEvent.class);
        String targetId = evt.getTargetId();
        ChromeContext context = targetMap.get(targetId);
        if (context == null) {
            logger.error("target crashed failed, context not found, targetId={}", targetId);
            return;
        }
        context.emit(ChromeContextEvent.TARGETCRASHED, evt);
        logger.error("target crashed, targetId={}", targetId);
    }

    private String nextContextName() {
        return "Context[" + name + "]-" + contextCounter.getAndIncrement();
    }

    /**
     * 只对已经存在的页面生效
     * @param autoAttach 是否自动attach
     * @throws Exception
     */
    protected void setAutoAttach(boolean autoAttach) throws Exception {
        SetAutoAttachRequest request = new SetAutoAttachRequest();
        request.setAutoAttach(autoAttach);
        request.setFlatten(true);
        request.setWaitForDebuggerOnStart(false);
        this.target.setAutoAttach(request, DEFAULT_TIMEOUT);
    }

    protected void setDiscoverTargets(boolean discover) throws Exception {
        SetDiscoverTargetsRequest request = new SetDiscoverTargetsRequest();
        request.setDiscover(discover);
        target.setDiscoverTargets(request, DEFAULT_TIMEOUT);
    }

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

    protected String createTarget(String browserContextId) throws Exception {
        CreateTargetRequest request = new CreateTargetRequest();
        request.setUrl(DEFAULT_URL);
        request.setBrowserContextId(browserContextId);
        CreateTargetResponse response = target.createTarget(request, DEFAULT_TIMEOUT);
        return response.getTargetId();
    }

    protected List<TargetInfo> getTargets(String browserContextId) throws Exception {
        GetTargetsResponse response = target.getTargets(DEFAULT_TIMEOUT);
        if (browserContextId == null) {
            return response.getTargetInfos();
        } else {
            return response.getTargetInfos().stream()
                    .filter(targetInfo -> Objects.equals(browserContextId, targetInfo.getBrowserContextId()))
                    .collect(Collectors.toList());
        }
    }

    protected void resetPermissions(String browserContextId) throws Exception {
        ResetPermissionsRequest request = new ResetPermissionsRequest();
        request.setBrowserContextId(browserContextId);
        browser.resetPermissions(request, DEFAULT_TIMEOUT);
    }

    protected void grantPermissions(String browserContextId, String origin, PermissionType... permissions) throws Exception {
        GrantPermissionsRequest request = new GrantPermissionsRequest();
        request.setBrowserContextId(browserContextId);
        request.setOrigin(origin);
        request.setPermissions(Arrays.stream(permissions)
                .map(permission -> permission.getValue())
                .collect(Collectors.toList()));
        browser.grantPermissions(request, DEFAULT_TIMEOUT);
    }

    protected void setCookies(String browserContextId, List<CookieParam> cookies) throws Exception {
        SetCookiesRequest request = new SetCookiesRequest();
        request.setBrowserContextId(browserContextId);
        request.setCookies(cookies);
        storage.setCookies(request, DEFAULT_TIMEOUT);
    }

    protected void clearCookies(String browserContextId) throws Exception {
        ClearCookiesRequest request = new ClearCookiesRequest();
        request.setBrowserContextId(browserContextId);
        storage.clearCookies(request, DEFAULT_TIMEOUT);
    }

    protected List<Cookie> getCookies(String browserContextId) throws Exception {
        GetCookiesRequest request = new GetCookiesRequest();
        request.setBrowserContextId(browserContextId);
        GetCookiesResponse response = storage.getCookies(request, DEFAULT_TIMEOUT);
        return response.getCookies();
    }

    protected CDPSession createSession(TargetType targetType, String sessionId) {
        return new CDPSession(connection, targetType, sessionId);
    }

    @Override
    public void close() throws Exception {
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
            ChromeContext context = new ChromeContext(nextContextName(), this, contextId);
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
        return defaultContext;
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

}
