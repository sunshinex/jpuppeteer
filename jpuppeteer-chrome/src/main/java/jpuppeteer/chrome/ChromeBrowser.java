package jpuppeteer.chrome;

import com.google.common.collect.MapMaker;
import jpuppeteer.api.browser.Browser;
import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.future.FutureFuture;
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
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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

        //由于在没有启动目标发现之前就有默认的page, 需要手动注册到map
        this.targetMap.put(defaultContext.defaultPage().frameId(), defaultContext);
        this.sessionMap.put(defaultContext.defaultPage().sessionId(), defaultContext);
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
                //logger.error("transmit event failed:context not found, event={} sessionId={}", from.getName(), sessionId);
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
            //logger.error("target created failed: context not found, targetId={}, contextId={}", targetId, contextId);
            return;
        }
        //自动执行attach操作
        asyncAttachToTarget(targetId);
        targetMap.put(targetId, context);
        context.emit(ChromeContextEvent.TARGETCREATED, targetInfo);
        logger.info("target created, auto do attach, targetId={}");
    }

    private void handleTargetAttached(CDPEvent event) {
        AttachedToTargetEvent evt = event.getObject(AttachedToTargetEvent.class);
        TargetInfo target = evt.getTargetInfo();
        String targetId = target.getTargetId();
        String contextId = target.getBrowserContextId();
        ChromeContext context = contextMap.get(contextId);
        if (context == null) {
            //logger.error("target attached failed, context not found, targetId={}, contextId={}", targetId, contextId);
            return;
        }
        String sessionId = evt.getSessionId();
        sessionMap.put(sessionId, context);
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
            //logger.error("target info changed failed, context not found, targetId={}", targetId);
            return;
        }
        context.emit(ChromeContextEvent.TARGETINFOCHANGED, targetInfo);
    }

    private void handleTargetCrashed(CDPEvent event) {
        TargetCrashedEvent evt = event.getObject(TargetCrashedEvent.class);
        String targetId = evt.getTargetId();
        ChromeContext context = targetMap.get(targetId);
        if (context == null) {
            //logger.error("target crashed failed, context not found, targetId={}", targetId);
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

    private AttachToTargetRequest buildAttachToTargetRequest(String targetId) {
        AttachToTargetRequest request = new AttachToTargetRequest();
        request.setTargetId(targetId);
        request.setFlatten(true);
        return request;
    }

    protected String attachToTarget(String targetId) throws Exception {
        AttachToTargetResponse response = target.attachToTarget(buildAttachToTargetRequest(targetId), DEFAULT_TIMEOUT);
        return response.getSessionId();
    }

    protected Future<String> asyncAttachToTarget(String targetId) {
        Future<AttachToTargetResponse> future = target.asyncAttachToTarget(buildAttachToTargetRequest(targetId));
        return new FutureFuture<>(future, response -> response.getSessionId());
    }

    protected boolean closeTarget(String targetId) throws Exception {
        CloseTargetRequest request = new CloseTargetRequest();
        request.setTargetId(targetId);
        CloseTargetResponse response = target.closeTarget(request, DEFAULT_TIMEOUT);
        return response.getSuccess();
    }

    /**
     *
     * @param browserContextId
     * @param uuid 需要在创建的时候给定一个唯一的uuid
     * @return
     * @throws Exception
     */
    protected String createTarget(String browserContextId, String uuid) throws Exception {
        CreateTargetRequest request = new CreateTargetRequest();
        if (StringUtils.isEmpty(uuid)) {
            request.setUrl(DEFAULT_URL);
        } else {
            request.setUrl(DEFAULT_URL + "?uuid=" + uuid);
        }
        request.setBrowserContextId(browserContextId);
        CreateTargetResponse response = target.createTarget(request, DEFAULT_TIMEOUT);
        return response.getTargetId();
    }

    protected String createTarget(String browserContextId) throws Exception {
        return createTarget(browserContextId, null);
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
    public synchronized void close() {
        if (!process.isAlive()) {
            return;
        }
        try {
            //关闭打开的上下文
            contextMap.forEach((browserContextId, context) -> {
                try {
                    context.close();
                } catch (Exception e) {
                    logger.error("close browser context failed, browserContextId={}, error={}", browserContextId, e.getMessage(), e);
                }
            });
            //关闭浏览器
            browser.close(DEFAULT_TIMEOUT);
            connection.close();
            logger.info("browser closed");
            while (process.isAlive()) {
                logger.info("process is alive, waiting...");
                TimeUnit.SECONDS.sleep(1);
            }
            logger.info("browser process normally exited");
        } catch (Exception e) {
            process.destroy();
            logger.error("close browser failed force shutdown, error={}", e.getMessage(), e);
        }
    }

    @Override
    public ChromeContext[] browserContexts() {
        List<ChromeContext> contextList = contextMap.values().stream()
                .filter(context -> context != null)
                .collect(Collectors.toList());
        ChromeContext[] contexts = new ChromeContext[contextList.size()];
        return contextList.toArray(contexts);
    }

    @Override
    public ChromeContext createContext() throws Exception {
        CreateBrowserContextResponse response = target.createBrowserContext(DEFAULT_TIMEOUT);
        String contextId = response.getBrowserContextId();
        try {
            ChromeContext context = new ChromeContext(nextContextName(), this, contextId);
            contextMap.put(contextId, context);
            targetMap.put(context.defaultPage().frameId(), context);
            sessionMap.put(context.defaultPage().sessionId(), context);
            logger.info("browser context created, contextId={}", contextId);
            return context;
        } catch (Exception e) {
            DisposeBrowserContextRequest request = new DisposeBrowserContextRequest();
            request.setBrowserContextId(contextId);
            target.disposeBrowserContext(request, DEFAULT_TIMEOUT);
            logger.warn("create browser context failed, contextId={}", contextId);
            throw e;
        }
    }

    @Override
    public ChromeContext defaultContext() {
        return defaultContext;
    }

    protected void closeContext(String browserContextId) throws Exception {
        if (browserContextId == null) {
            //默认的上下文不能用此方法关闭
            return;
        }
        DisposeBrowserContextRequest request = new DisposeBrowserContextRequest();
        request.setBrowserContextId(browserContextId);
        target.disposeBrowserContext(request, DEFAULT_TIMEOUT);
        contextMap.remove(browserContextId);
        logger.info("browser context closed, contextId={}", browserContextId);
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
