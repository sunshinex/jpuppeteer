package jpuppeteer.chrome;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.event.AbstractEventEmitter;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.browser.*;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.client.constant.storage.StorageType;
import jpuppeteer.cdp.client.entity.browser.DownloadProgressEvent;
import jpuppeteer.cdp.client.entity.browser.DownloadWillBeginEvent;
import jpuppeteer.cdp.client.entity.browser.GetVersionResponse;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.cdp.client.entity.storage.ClearDataForOriginRequest;
import jpuppeteer.cdp.client.entity.target.*;
import jpuppeteer.util.XFuture;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ChromeBrowser extends ChromeContext implements Browser {

    private static final Logger logger = LoggerFactory.getLogger(ChromeBrowser.class);

    private final EventLoop eventLoop;

    private final URI uri;

    private final Process process;

    private final CDPConnection connection;

    private final BrowserEventEmitter eventEmitter;

    protected ChromeBrowser(String uri, Process process) throws Exception {
        super(null, null);
        this.eventLoop = new NioEventLoopGroup(1, r -> {
            return new Thread(r, "browser");
        }).next();
        this.uri = URI.create(uri);
        this.process = process;
        this.connection = new BrowserConnection(this.eventLoop, this.uri);
        this.eventEmitter = new BrowserEventEmitter();
        try {
            this.connection.target.setDiscoverTargets(new SetDiscoverTargetsRequest(true)).get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            disconnect();
            throw e;
        }
    }

    protected EventLoop eventLoop() {
        return eventLoop;
    }

    protected CDPConnection connection() {
        return connection;
    }

    @Override
    public URI uri() {
        return uri;
    }

    @Override
    public XFuture<GetVersionResponse> version() {
        return connection.browser.getVersion();
    }

    @Override
    public XFuture<BrowserContext> createContext(CreateBrowserContextRequest request) {
        return connection.target.createBrowserContext(request)
                .sync(response -> new ChromeContext(ChromeBrowser.this, response.getBrowserContextId()));
    }

    @Override
    public XFuture<?> clearData(String origin, StorageType... storageTypes) {
        List<String> types = Arrays.stream(storageTypes)
                .map(StorageType::value)
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

    @Override
    public ChromeBrowser browser() {
        return this;
    }

    @Override
    public XFuture<?> setCookies(CookieParam... cookies) {
        return super.setCookies(cookies);
    }

    @Override
    public XFuture<?> clearCookies() {
        return super.clearCookies();
    }

    @Override
    public XFuture<Cookie[]> getCookies() {
        return super.getCookies();
    }

    @Override
    public void addListener(AbstractListener<? extends BrowserEvent> listener) {
        eventEmitter.addListener(listener);
    }

    @Override
    public void removeListener(AbstractListener<? extends BrowserEvent> listener) {
        eventEmitter.removeListener(listener);
    }

    private class BrowserEventEmitter extends AbstractEventEmitter<BrowserEvent> {

        @Override
        protected void emitInternal(AbstractListener<BrowserEvent> listener, BrowserEvent event) {
            if (eventLoop.inEventLoop()) {
                listener.accept(event);
            } else {
                eventLoop.execute(() -> listener.accept(event));
            }
        }

        protected void emit(BrowserEvent event) {
            super.emit(event);
        }
    }

    private class BrowserConnection extends CDPConnection {

        public BrowserConnection(EventLoop eventLoop, URI uri) {
            super(eventLoop, uri);
        }

        @Override
        protected void onEvent(CDPEvent event) {
            switch (event.method) {
                case TARGET_TARGETCREATED:
                    TargetCreatedEvent targetCreatedEvent = event.getObject();
                    eventEmitter.emit(new TargetCreated(targetCreatedEvent.getTargetInfo()));
                    break;

                case TARGET_TARGETINFOCHANGED:
                    TargetInfoChangedEvent targetInfoChangedEvent = event.getObject();
                    eventEmitter.emit(new TargetInfoChanged(targetInfoChangedEvent.getTargetInfo()));
                    break;

                case TARGET_TARGETCRASHED:
                    TargetCrashedEvent targetCrashedEvent = event.getObject();
                    eventEmitter.emit(new TargetCrashed(
                            targetCrashedEvent.getTargetId(),
                            targetCrashedEvent.getStatus(),
                            targetCrashedEvent.getErrorCode()));
                    break;

                case TARGET_TARGETDESTROYED:
                    TargetDestroyedEvent targetDestroyedEvent = event.getObject();
                    eventEmitter.emit(new TargetClosed(targetDestroyedEvent.getTargetId()));
                    break;

                case BROWSER_DOWNLOADWILLBEGIN:
                    DownloadWillBeginEvent downloadWillBeginEvent = event.getObject();
                    eventEmitter.emit(new DownloadWillBegin(downloadWillBeginEvent));
                    break;

                case BROWSER_DOWNLOADPROGRESS:
                    DownloadProgressEvent downloadProgressEvent = event.getObject();
                    eventEmitter.emit(new DownloadProgress(downloadProgressEvent));
                    break;
            }
        }
    }
}
