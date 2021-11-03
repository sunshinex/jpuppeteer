package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.FailedFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.Page;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.PageEvent;
import jpuppeteer.api.event.page.LoadedEvent;
import jpuppeteer.api.event.page.NewPageEvent;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.TargetType;
import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.constant.storage.StorageType;
import jpuppeteer.cdp.client.entity.browser.*;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.cdp.client.entity.network.LoadingFinishedEvent;
import jpuppeteer.cdp.client.entity.storage.ClearCookiesRequest;
import jpuppeteer.cdp.client.entity.storage.ClearDataForOriginRequest;
import jpuppeteer.cdp.client.entity.storage.GetCookiesRequest;
import jpuppeteer.cdp.client.entity.storage.SetCookiesRequest;
import jpuppeteer.cdp.client.entity.target.*;
import jpuppeteer.entity.TargetBase;
import jpuppeteer.util.SeriesPromise;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ChromeBrowser implements Browser {

    private static final Logger logger = LoggerFactory.getLogger(ChromeBrowser.class);

    private final EventLoop eventLoop;

    private final URI uri;

    private final AtomicInteger cdpMessageIdGen;

    private final CDPConnection connection;

    private final Process process;

    private final ChromeContext defaultContext;

    private final Map<String, ChromeContext> contextMap;

    private final Map<String, TargetBase> targetMap;

    public ChromeBrowser(String uri, Process process) throws Exception {
        this.eventLoop = new NioEventLoopGroup(r -> new Thread(r, "browser")).next();
        this.uri = URI.create(uri);
        this.cdpMessageIdGen = new AtomicInteger(0);
        this.connection = new BrowserConnection();
        this.process = process;
        this.defaultContext = new ChromeContext(this, null);
        this.contextMap = new ConcurrentHashMap<>();
        this.targetMap = new ConcurrentHashMap<>();
        GetBrowserContextsResponse getBrowserContextsResponse = connection.target.getBrowserContexts()
                .get(30, TimeUnit.SECONDS);
        for(String browserContextId : getBrowserContextsResponse.browserContextIds) {
            contextMap.put(browserContextId, new ChromeContext(this, browserContextId));
        }
        this.discoverTargets(true);
    }

    private Future discoverTargets(boolean enable) {
        SetDiscoverTargetsRequest request = new SetDiscoverTargetsRequest(enable);
        return connection.target.setDiscoverTargets(request);
    }

    protected int genMessageId() {
        return cdpMessageIdGen.getAndIncrement();
    }

    protected EventLoop eventLoop() {
        return eventLoop;
    }

    protected Future<String> createTarget(String browserContextId, String url, Integer width, Integer height) {
        CreateTargetRequest request = new CreateTargetRequest(
                url, width, height, browserContextId,
                null, null, true);
        return SeriesPromise
                .wrap(connection.target.createTarget(request))
                .sync(o -> o.targetId);
    }

    protected Future activateTarget(String targetId) {
        return connection.target.activateTarget(new ActivateTargetRequest(targetId));
    }

    protected Future closeTarget(String targetId) {
        CloseTargetRequest request = new CloseTargetRequest(targetId);
        return connection.target.closeTarget(request);
    }

    protected TargetBase findTarget(String frameId) {
        return targetMap.get(frameId);
    }

    protected Future closeContext(String browserContextId) {
        if (browserContextId == null) {
            return new FailedFuture<>(eventLoop, new Exception("can not close default context"));
        }
        DisposeBrowserContextRequest request = new DisposeBrowserContextRequest(browserContextId);
        return connection.target.disposeBrowserContext(request).addListener(f -> {
            contextMap.remove(browserContextId);
        });
    }

    protected Future grantPermissions(String browserContextId, String origin, PermissionType... permissions) {
        GrantPermissionsRequest request = new GrantPermissionsRequest(Lists.newArrayList(permissions), origin, browserContextId);
        return connection.browser.grantPermissions(request);
    }

    protected Future resetPermissions(String browserContextId) {
        ResetPermissionsRequest request = new ResetPermissionsRequest(browserContextId);
        return connection.browser.resetPermissions(request);
    }

    protected Future setWindowBounds(String targetId, Bounds bounds) {
        return SeriesPromise
                .wrap(connection.browser.getWindowForTarget(new GetWindowForTargetRequest(targetId)))
                .async(o -> connection.browser.setWindowBounds(new SetWindowBoundsRequest(o.windowId, bounds)));
    }

    protected Future setCookies(String browserContextId, CookieParam... cookies) {
        SetCookiesRequest request = new SetCookiesRequest(Lists.newArrayList(cookies), browserContextId);
        return connection.storage.setCookies(request);
    }

    protected Future clearCookies(String browserContextId) {
        ClearCookiesRequest request = new ClearCookiesRequest(browserContextId);
        return connection.storage.clearCookies(request);
    }

    protected Future<Cookie[]> getCookies(String browserContextId) {
        return SeriesPromise
                .wrap(connection.storage.getCookies(new GetCookiesRequest(browserContextId)))
                .sync(o -> {
                    Cookie[] cookies = new Cookie[o.cookies.size()];
                    o.cookies.toArray(cookies);
                    return cookies;
                });
    }

    @Override
    public URI uri() {
        return uri;
    }

    @Override
    public Future<GetVersionResponse> version() {
        return connection.browser.getVersion();
    }

    @Override
    public Future<BrowserContext> createContext(CreateBrowserContextRequest request) {
        Promise<BrowserContext> promise = eventLoop.newPromise();
        connection.target.createBrowserContext(request).addListener(f -> {
            if (f.cause() != null) {
                promise.tryFailure(f.cause());
            } else {
                CreateBrowserContextResponse response = (CreateBrowserContextResponse) f.getNow();
                ChromeContext context = new ChromeContext(ChromeBrowser.this, response.browserContextId);
                contextMap.put(response.browserContextId, context);
                promise.trySuccess(context);
            }
        });
        return promise;
    }

    @Override
    public ChromeContext defaultContext() {
        return defaultContext;
    }

    @Override
    public ChromeContext[] browserContexts() {
        return contextMap.values().toArray(new ChromeContext[0]);
    }

    @Override
    public Future clearData(String origin, StorageType... storageTypes) {
        List<String> types = Arrays.stream(storageTypes)
                .map(t -> t.value())
                .collect(Collectors.toList());
        ClearDataForOriginRequest request = new ClearDataForOriginRequest(origin, StringUtils.join(types, ","));
        return connection.storage.clearDataForOrigin(request);
    }

    @Override
    public void close() {
        try {
            connection.browser.close().get(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("close browser failed, error={}", e.getMessage(), e);
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    class BrowserConnection extends CDPConnection {

        public BrowserConnection() throws Exception {
            super(eventLoop, uri);
        }

        @Override
        protected int genId() {
            return genMessageId();
        }

        private void fill(TargetBase targetBase, TargetInfo targetInfo) {
            ChromeContext browserContext = targetInfo.browserContextId == null ? defaultContext : contextMap.get(targetInfo.browserContextId);
            if (browserContext == null) {
                //某些情况下这个id是默认的上下文
                browserContext = defaultContext;
            }
            TargetBase opener = targetInfo.openerId != null ? targetMap.get(targetInfo.openerId) : null;
            targetBase.setTargetId(targetInfo.targetId);
            targetBase.setType(TargetType.findByType(targetInfo.type));
            targetBase.setTitle(targetInfo.title);
            targetBase.setUrl(targetInfo.url);
            targetBase.setAttached(targetInfo.attached);
            targetBase.setOpener(opener);
            targetBase.setCanAccessOpener(targetInfo.canAccessOpener);
            targetBase.setOpenerFrameId(targetInfo.openerFrameId);
            targetBase.setBrowserContext(browserContext);
        }

        private void onTargetCreated(TargetInfo targetInfo) {
            TargetBase newTarget = new TargetBase();
            fill(newTarget, targetInfo);
            TargetBase oldTarget = targetMap.putIfAbsent(targetInfo.targetId, newTarget);
            if (oldTarget != null) {
                fill(oldTarget, targetInfo);
                newTarget = oldTarget;
            }
            TargetBase opener = newTarget.getOpener();
            if (opener != null) {
                ChromeFrame frame = opener.getFrame();
                if (frame != null) {
                    frame.page().onNewPage(newTarget);
                }
            }
        }

        private void onTargetChanged(TargetInfo targetInfo) {
            TargetBase targetBase = targetMap.get(targetInfo.targetId);
            if (targetBase == null) {
                logger.warn("target not found0, targetId={}", targetInfo.targetId);
            } else {
                fill(targetBase, targetInfo);
            }
        }

        private void onTargetCrashed(String targetId, Integer errorCode, String status) {
            TargetBase targetBase = targetMap.get(targetId);
            if (targetBase == null) {
                logger.warn("target not found1, targetId={}", targetId);
            } else {
                ChromeFrame frame = targetBase.getFrame();
                if (frame != null) {
                    frame.page().onCrashed(frame, errorCode, status);
                }
            }
        }

        private void onTargetDestroyed(String targetId) {
            TargetBase targetBase = targetMap.remove(targetId);
            if (targetBase == null) {
                logger.warn("target not found, targetId={}", targetId);
            } else {
                ChromeFrame frame = targetBase.getFrame();
                if (frame != null) {
                    frame.page().onClosed(frame);
                }
            }
        }

        @Override
        protected void onEvent(CDPEvent event) {
            switch (event.method) {
                case TARGET_TARGETCREATED:
                    TargetCreatedEvent targetCreatedEvent = event.getObject();
                    onTargetCreated(targetCreatedEvent.targetInfo);
                    break;

                case TARGET_TARGETINFOCHANGED:
                    TargetInfoChangedEvent targetInfoChangedEvent = event.getObject();
                    onTargetChanged(targetInfoChangedEvent.targetInfo);
                    break;

                case TARGET_TARGETCRASHED:
                    TargetCrashedEvent targetCrashedEvent = event.getObject();
                    onTargetCrashed(targetCrashedEvent.targetId, targetCrashedEvent.errorCode, targetCrashedEvent.status);
                    break;

                case TARGET_TARGETDESTROYED:
                    TargetDestroyedEvent targetDestroyedEvent = event.getObject();
                    onTargetDestroyed(targetDestroyedEvent.targetId);
                    break;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        ChromeBrowser browser = new ChromeBrowser("ws://127.0.0.1:9229/devtools/browser/f57c3b6e-5f7e-4464-baaf-532f23ba92f9", null);
        BrowserContext context = browser.defaultContext();
        Page page = context.newPage().get(10, TimeUnit.SECONDS);
        page.addListener(new AbstractListener<LoadedEvent>() {
            @Override
            public void accept(LoadedEvent event) {
                page.eval("var iframe = document.createElement('iframe');iframe.style='position:absolute;left:0;top:0;width:100%;height:100%;z-index:999999;background:#fff';iframe.src='http://localhost:9229/json';document.body.appendChild(iframe);");
            }
        });
        page.addListener(new AbstractListener<NewPageEvent>() {
            @Override
            public void accept(NewPageEvent event) {
                Page pg = event.page();
                System.out.println(pg);
            }
        });
        page.navigate("https://www.baidu.com/").get(10, TimeUnit.SECONDS);
    }
}
