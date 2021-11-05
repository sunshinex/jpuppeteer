package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.FailedFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.TargetType;
import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.constant.storage.StorageType;
import jpuppeteer.cdp.client.entity.browser.*;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.cdp.client.entity.storage.ClearCookiesRequest;
import jpuppeteer.cdp.client.entity.storage.ClearDataForOriginRequest;
import jpuppeteer.cdp.client.entity.storage.GetCookiesRequest;
import jpuppeteer.cdp.client.entity.storage.SetCookiesRequest;
import jpuppeteer.cdp.client.entity.target.*;
import jpuppeteer.util.SeriesPromise;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ChromeBrowser implements Browser {

    private static final Logger logger = LoggerFactory.getLogger(ChromeBrowser.class);

    private final EventLoop eventLoop;

    private final URI uri;

    private final AtomicInteger cdpMessageIdGen;

    private final CDPConnection connection;

    private final Process process;

    private final ChromeContext defaultContext;

    private final Map<String, ChromeContext> contextMap;

    private final Map<String/*targetId|frameId*/, ChromePage> pageMap;

    protected ChromeBrowser(String uri, Process process) throws Exception {
        this.eventLoop = new NioEventLoopGroup(1, r -> {
            return new Thread(r, "browser");
        }).next();
        this.uri = URI.create(uri);
        this.cdpMessageIdGen = new AtomicInteger(0);
        this.connection = new BrowserConnection();
        this.process = process;
        this.defaultContext = new ChromeContext(this, null);
        this.contextMap = new ConcurrentHashMap<>();
        this.pageMap = new ConcurrentHashMap<>();
        try {
            GetBrowserContextsResponse getBrowserContextsResponse = connection.target.getBrowserContexts()
                    .get(30, TimeUnit.SECONDS);
            for (String browserContextId : getBrowserContextsResponse.browserContextIds) {
                contextMap.put(browserContextId, new ChromeContext(this, browserContextId));
            }
            //创建一个页面去获取默认上下文的browserContextId
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String targetId = createTarget(null, "about:blank?" + uuid, null, null).get(30, TimeUnit.SECONDS);
            GetTargetsResponse getTargetsResponse = connection.target.getTargets().get(30, TimeUnit.SECONDS);
            String defaultContextId = null;
            for (TargetInfo targetInfo : getTargetsResponse.targetInfos) {
                if (targetInfo.url.contains(uuid)) {
                    defaultContextId = targetInfo.browserContextId;
                }
            }
            if (defaultContextId == null) {
                throw new Exception("detect default context failed");
            }
            contextMap.put(defaultContextId, defaultContext);
            closeTarget(targetId).get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            disconnect();
            throw e;
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

    protected ChromePage getPage(String targetIdOrFrameId) {
        ChromePage page = pageMap.get(targetIdOrFrameId);
        if (page == null) {
            return null;
        }
        return page;
    }

    protected void onPageInit(ChromePage page) {
        pageMap.put(page.frameId(), page);
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
    public void disconnect() {
        try {
            connection.close().get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("disconnect browser connection failed, error={}", e.getMessage(), e);
        } finally {
            try {
                eventLoop.shutdownGracefully().get(30, TimeUnit.SECONDS);
            } catch (Exception e) {
                logger.error("shutdown event loop failed, error={}", e.getMessage(), e);
            }
        }
    }

    @Override
    public void close() {
        try {
            connection.browser.close().get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("close browser failed, error={}", e.getMessage(), e);
        } finally {
            disconnect();
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

        private void onTargetCreated(TargetInfo targetInfo) {
            TargetType targetType = TargetType.findByType(targetInfo.type);
            if (targetType != TargetType.PAGE) {
                return;
            }
            ChromeContext browserContext = targetInfo.browserContextId == null ? defaultContext : contextMap.get(targetInfo.browserContextId);
             if (browserContext == null) {
                return;
            }
            ChromePage page = new ChromePage(browserContext, targetInfo);
            pageMap.put(targetInfo.targetId, page);
            ChromePage opener = page.opener();
            if (opener != null) {
                opener.onNewPage(page);
            }
        }

        private void onTargetChanged(TargetInfo targetInfo) {
            ChromePage page = pageMap.get(targetInfo.targetId);
            if (page != null) {
                page.setTargetInfo(targetInfo);
            }
        }

        private void onTargetCrashed(String targetId, Integer errorCode, String status) {
            ChromePage page = pageMap.get(targetId);
            if (page != null) {
                page.onCrashed(errorCode, status);
            }
        }

        private void onTargetDestroyed(String targetId) {
            ChromePage page = pageMap.remove(targetId);
            if (page != null) {
                String frameId = page.frameId();
                if (frameId != null) {
                    pageMap.remove(page.frameId());
                }
                page.onClosed();
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
}
