package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import io.netty.util.concurrent.*;
import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.event.AbstractEventEmitter;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.page.CreatedEvent;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.constant.storage.StorageType;
import jpuppeteer.cdp.client.domain.Storage;
import jpuppeteer.cdp.client.domain.Target;
import jpuppeteer.cdp.client.entity.browser.*;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.cdp.client.entity.storage.ClearCookiesRequest;
import jpuppeteer.cdp.client.entity.storage.ClearDataForOriginRequest;
import jpuppeteer.cdp.client.entity.storage.GetCookiesRequest;
import jpuppeteer.cdp.client.entity.storage.SetCookiesRequest;
import jpuppeteer.cdp.client.entity.target.*;
import jpuppeteer.util.SeriesFuture;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Collectors;

import static jpuppeteer.cdp.client.CDPEventType.*;

public class ChromeBrowser extends AbstractEventEmitter<CDPEvent> implements Browser {

    private static final Logger logger = LoggerFactory.getLogger(ChromeBrowser.class);

    private static final AtomicReferenceFieldUpdater<ChromeBrowser, Promise> CLOSE_FUTURE_UPDATER
            = AtomicReferenceFieldUpdater.newUpdater(ChromeBrowser.class, Promise.class, "closeFuture");

    private final String name;

    private final CDPConnection connection;

    private final Process process;

    private final jpuppeteer.cdp.client.domain.Browser browser;

    private final Target target;

    private final Storage storage;

    private final AtomicInteger contextIdGen;

    private final ChromeContext defaultContext;

    private final Map<String/*BrowserContextId*/, ChromeContext> contextMap;

    private final Map<String/*targetId*/, ChromeContext> targetContextMap;

    private final Map<String/*sessionId*/, ChromeContext> sessionContextMap;

    private volatile Promise closeFuture;

    public ChromeBrowser(CDPConnection connection, Process process) {
        this.name = "browser";
        this.connection = connection;
        this.process = process;
        this.browser = new jpuppeteer.cdp.client.domain.Browser(connection);
        this.target = new Target(connection);
        this.storage = new Storage(connection);
        this.contextIdGen = new AtomicInteger(0);
        this.defaultContext = new ChromeContext(name() + ":context:default", this, null);
        this.contextMap = new ConcurrentHashMap<>();
        this.targetContextMap = new MapMaker()
                .concurrencyLevel(16)
                .weakValues()
                .makeMap();
        this.sessionContextMap = new MapMaker()
                .concurrencyLevel(16)
                .weakValues()
                .makeMap();
        this.discoverTargets(true);
        this.connection.addListener(new AbstractListener<CDPEvent>() {
            @Override
            public void accept(CDPEvent event) {
                emit(event);
                if (StringUtils.isNotEmpty(event.sessionId)) {
                    handleSessionEvent(event);
                } else if (TARGET_TARGETCREATED.equals(event.method)) {
                    handleTargetCreated(event.getObject());
                } else if (TARGET_ATTACHEDTOTARGET.equals(event.method)) {
                    AttachedToTargetEvent aEvt = event.getObject();
                    CDPEvent evt = new CDPEvent(aEvt.sessionId, event.method, event.getObject());
                    handleSessionEvent(evt);
                } else if (TARGET_TARGETINFOCHANGED.equals(event.method)) {
                    TargetInfoChangedEvent evt = event.getObject();
                    handleTargetEvent(evt.targetInfo.targetId, event);
                } else if (TARGET_DETACHEDFROMTARGET.equals(event.method)) {
                    DetachedFromTargetEvent dEvt = event.getObject();
                    CDPEvent evt = new CDPEvent(dEvt.sessionId, event.method, event.getObject());
                    handleSessionEvent(evt);
                }else if (TARGET_TARGETDESTROYED.equals(event.method)) {
                    TargetDestroyedEvent evt = event.getObject();
                    handleTargetEvent(evt.targetId, event);
                } else if (TARGET_TARGETCRASHED.equals(event.method)) {
                    TargetCrashedEvent evt = event.getObject();
                    handleTargetEvent(evt.targetId, event);
                } else if (TARGET_RECEIVEDMESSAGEFROMTARGET.equals(event.method)) {
                    ReceivedMessageFromTargetEvent rEvt = event.getObject();
                    CDPEvent evt = new CDPEvent(rEvt.sessionId, event.method, event.getObject());
                    handleSessionEvent(evt);
                } else {
                    handleOtherEvent(event);
                }
            }
        });
    }

    private void handleTargetCreated(TargetCreatedEvent event) {
        //处理opener
        String targetId = event.targetInfo.targetId;
        String openerId = event.targetInfo.openerId;
        if (StringUtils.isEmpty(openerId)) {
            return;
        }
        ChromeContext ctx = targetContextMap.get(openerId);
        if (ctx == null) {
            logger.warn("[{}] opener not found, opener={}", targetId, openerId);
            return;
        }
        targetContextMap.put(targetId, ctx);
        attachTarget(targetId).addListener(f -> {
            if (f.cause() != null) {
                logger.error("[{}] attach failed", targetId);
            } else {
                CDPSession session = (CDPSession) f.getNow();
                sessionContextMap.put(session.sessionId(), ctx);
                ChromePage page = ctx.newPage(session, openerId);
                page.opener().emit(new CreatedEvent(page));
            }
        });
    }

    private void handleTargetEvent(String targetId, CDPEvent event) {
        ChromeContext ctx = targetContextMap.get(targetId);
        if (ctx != null) {
            ctx.handleTargetEvent(targetId, event);
        }
    }

    private void handleSessionEvent(CDPEvent event) {
        ChromeContext ctx = sessionContextMap.get(event.sessionId);
        if (ctx != null) {
            ctx.handleSessionEvent(event);
        }
    }

    private void handleOtherEvent(CDPEvent event) {
        logger.warn("can not handle event:{}", event);
    }

    private Future discoverTargets(boolean enable) {
        SetDiscoverTargetsRequest request = new SetDiscoverTargetsRequest(enable);
        return target.setDiscoverTargets(request);
    }

    @Override
    protected void emitInternal(AbstractListener<CDPEvent> listener, CDPEvent event) {
        EventExecutor executor = executor();
        if (executor.inEventLoop()) {
            listener.accept(event);
        } else {
            executor.execute(() -> listener.accept(event));
        }
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Future<GetVersionResponse> version() {
        return browser.getVersion();
    }

    @Override
    public BrowserContext[] browserContexts() {
        Collection<ChromeContext> values = contextMap.values();
        BrowserContext[] contexts = new BrowserContext[values.size()];
        return values.toArray(contexts);
    }

    @Override
    public Future<BrowserContext> createContext() {
        return SeriesFuture
                .wrap(target.createBrowserContext())
                .sync(o -> {
                    String name = name() + ":context:" + contextIdGen.getAndIncrement();
                    ChromeContext context = new ChromeContext(name, this, o.browserContextId);
                    contextMap.put(o.browserContextId, context);
                    return context;
                });
    }

    @Override
    public BrowserContext defaultContext() {
        return defaultContext;
    }

    public EventExecutor executor() {
        return connection.eventLoop();
    }

    public Future<List<TargetInfo>> getTargets() {
        return SeriesFuture
                .wrap(target.getTargets())
                .sync(o -> o.targetInfos);
    }

    public Future<CDPSession> attachTarget(String targetId) {
        return SeriesFuture
                .wrap(target.attachToTarget(new AttachToTargetRequest(targetId, true)))
                .sync(o -> connection.newSession(targetId, o.sessionId));
    }

    public Future<CDPSession> createTarget(String browserContextId, String url, Integer width, Integer height) {
        return SeriesFuture
                .wrap(target.createTarget(new CreateTargetRequest(url, width, height, browserContextId, null, null, true)))
                .async(o -> {
                    ChromeContext ctx = browserContextId != null ? contextMap.get(browserContextId) : defaultContext;
                    if (ctx == null) {
                        throw new RuntimeException("context `"+browserContextId+"` not found");
                    }
                    targetContextMap.put(o.targetId, ctx);
                    return attachTarget(o.targetId).addListener(f -> {
                        if (f.cause() != null) {
                            logger.error("[{}] attach failed", o.targetId);
                        } else {
                            CDPSession session = (CDPSession) f.getNow();
                            sessionContextMap.put(session.sessionId(), ctx);
                        }
                    });
                });
    }

    public Future exposeTarget(String targetId, String bindingName) {
        return target.exposeDevToolsProtocol(new ExposeDevToolsProtocolRequest(targetId, bindingName));
    }

    public Future setCookies(String browserContextId, CookieParam... cookies) {
        SetCookiesRequest request = new SetCookiesRequest(Lists.newArrayList(cookies), browserContextId);
        return storage.setCookies(request);
    }

    public Future clearCookies(String browserContextId) {
        ClearCookiesRequest request = new ClearCookiesRequest(browserContextId);
        return storage.clearCookies(request);
    }

    public Future<Cookie[]> getCookies(String browserContextId) {
        return SeriesFuture
                .wrap(storage.getCookies(new GetCookiesRequest(browserContextId)))
                .sync(o -> {
                    Cookie[] cookies = new Cookie[o.cookies.size()];
                    o.cookies.toArray(cookies);
                    return cookies;
                });
    }

    public Future closeContext(String browserContextId) {
        if (browserContextId == null) {
            //当关闭的是默认上下文，则直接关闭整个浏览器
            return close();
        } else {
            contextMap.remove(browserContextId);
            DisposeBrowserContextRequest request = new DisposeBrowserContextRequest(browserContextId);
            return target.disposeBrowserContext(request);
        }
    }

    public Future grantPermissions(String browserContextId, String origin, PermissionType... permissions) {
        GrantPermissionsRequest request = new GrantPermissionsRequest(origin, Lists.newArrayList(permissions), browserContextId);
        return browser.grantPermissions(request);
    }

    public Future resetPermissions(String browserContextId) {
        ResetPermissionsRequest request = new ResetPermissionsRequest(browserContextId);
        return browser.resetPermissions(request);
    }

    public Future activateTarget(String targetId) {
        return target.activateTarget(new ActivateTargetRequest(targetId));
    }

    public Future closeTarget(String targetId) {
        CloseTargetRequest request = new CloseTargetRequest(targetId);
        return target.closeTarget(request);
    }

    public Future setWindowBounds(String targetId, Bounds bounds) {
        return SeriesFuture
                .wrap(browser.getWindowForTarget(new GetWindowForTargetRequest(targetId)))
                .async(o -> browser.setWindowBounds(new SetWindowBoundsRequest(o.windowId, bounds)));
    }

    @Override
    public Future clearData(String origin, StorageType... storageTypes) {
        List<String> types = Arrays.stream(storageTypes)
                .map(t -> t.value())
                .collect(Collectors.toList());
        ClearDataForOriginRequest request = new ClearDataForOriginRequest(origin, StringUtils.join(types, ","));
        return storage.clearDataForOrigin(request);
    }

    @Override
    public Future close() {
        if (!CLOSE_FUTURE_UPDATER.compareAndSet(
                this, null, new DefaultPromise<>(GlobalEventExecutor.INSTANCE))) {
            return closeFuture;
        }
        browser.close().addListener(f0 -> {
            connection.close().addListener(f1 -> {
                Throwable cause = f0.cause() != null ? f0.cause() : f1.cause();
                if (cause != null) {
                    closeFuture.tryFailure(cause);
                } else {
                    closeFuture.trySuccess(null);
                }
            });
        });
        //最多延迟10s结束chrome进程
        GlobalEventExecutor.INSTANCE.schedule(process::destroy, 10, TimeUnit.SECONDS);
        return closeFuture;
    }
}
