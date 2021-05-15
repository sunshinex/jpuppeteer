package jpuppeteer.chrome;

import com.google.common.collect.MapMaker;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.Page;
import jpuppeteer.api.event.page.ChangedEvent;
import jpuppeteer.api.event.page.ClosedEvent;
import jpuppeteer.api.event.page.CrashedEvent;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.cdp.client.entity.target.TargetCrashedEvent;
import jpuppeteer.cdp.client.entity.target.TargetInfoChangedEvent;
import jpuppeteer.util.SeriesFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ChromeContext implements BrowserContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeContext.class);

    private final String name;

    private final ChromeBrowser browser;

    private final String browserContextId;

    private final AtomicInteger pageIdGen;

    private final Map<String/*targetId*/, ChromePage> targetMap;

    private final Map<String/*sessionId*/, ChromePage> sessionMap;

    public ChromeContext(String name, ChromeBrowser browser, String browserContextId) {
        this.name = name;
        this.browser = browser;
        this.browserContextId = browserContextId;
        this.pageIdGen = new AtomicInteger(0);
        this.targetMap = new ConcurrentHashMap<>();
        this.sessionMap = new MapMaker()
                .concurrencyLevel(16)
                .weakValues()
                .makeMap();
    }

    public ChromePage newPage(CDPSession session, String openerId) {
        ChromePage opener = openerId != null ? targetMap.get(openerId) : null;
        String name = name() + ":page:" + pageIdGen.getAndIncrement();
        ChromePage page = new ChromePage(name, this, session, opener);
        targetMap.put(session.targetId(), page);
        sessionMap.put(session.sessionId(), page);
        return page;
    }

    public void handleTargetEvent(String targetId, CDPEvent event) {
        ChromePage page = targetMap.get(targetId);
        if (page == null) {
            logger.warn("[{}] target not found, ignored! event={}", targetId, event);
            return;
        }
        switch (event.method) {
            case TARGET_TARGETINFOCHANGED :
                TargetInfoChangedEvent changedEvent = event.getObject();
                page.emit(new ChangedEvent(changedEvent.targetInfo));
                break;

            case TARGET_TARGETDESTROYED:
                page.emit(new ClosedEvent());
                break;

            case TARGET_TARGETCRASHED:
                TargetCrashedEvent crashedEvent = event.getObject();
                page.emit(new CrashedEvent(crashedEvent.status, crashedEvent.errorCode));
                break;

            default:
                logger.warn("[{}] unsupported event: {}", targetId, event);
                break;
        }
    }

    public void handleSessionEvent(CDPEvent event) {
        String sessionId = event.sessionId;
        ChromePage page = sessionMap.get(sessionId);
        if (page == null) {
            logger.error("[{}] session not found", sessionId);
            return;
        }
        switch (event.method) {

            case PAGE_FRAMERESIZED:

            case PAGE_FRAMESTARTEDLOADING:

            case PAGE_FRAMESTOPPEDLOADING:
                break;

            case PAGE_FRAMEATTACHED:
                page.handleFrameAttached(event.getObject());
                break;

            case PAGE_FRAMENAVIGATED:
                page.handleFrameNavigated(event.getObject());
                break;

            case PAGE_FRAMEDETACHED:
                page.handleFrameDetached(event.getObject());
                break;

            case PAGE_LIFECYCLEEVENT:
                page.handleLifecycle(event.getObject());
                break;

            case PAGE_DOMCONTENTEVENTFIRED:
                page.handleDomContentLoaded(event.getObject());
                break;

            case PAGE_LOADEVENTFIRED:
                page.handlePageLoaded(event.getObject());
                break;

            case RUNTIME_BINDINGCALLED:
                page.handleBindingCall(event.getObject());
                break;

            case PAGE_JAVASCRIPTDIALOGOPENING:
                page.handleJavascriptDialog(event.getObject());
                break;

            case RUNTIME_EXCEPTIONTHROWN:
                page.handleExceptionThrown(event.getObject());
                break;

            case RUNTIME_EXECUTIONCONTEXTCREATED:
                page.handleIsolateCreated(event.getObject());
                break;

            case RUNTIME_EXECUTIONCONTEXTDESTROYED:
                page.handleIsolateDestroyed(event.getObject());
                break;

            case RUNTIME_EXECUTIONCONTEXTSCLEARED:
                page.handleIsolateCleared();
                break;

            case NETWORK_REQUESTWILLBESENT:
                page.handleRequest(event.getObject());
                break;

            case NETWORK_RESPONSERECEIVED:
                page.handleResponse(event.getObject());
                break;

            case NETWORK_LOADINGFAILED:
                page.handleRequestFailed(event.getObject());
                break;

            case NETWORK_LOADINGFINISHED:
                page.handleRequestFinished(event.getObject());
                break;

            case FETCH_REQUESTPAUSED:
                page.handleRequestPaused(event.getObject());
                break;

            case FETCH_AUTHREQUIRED:
                page.handleAuthRequired(event.getObject());
                break;
        }
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Browser browser() {
        return browser;
    }

    @Override
    public Future grantPermissions(String origin, PermissionType... permissions) {
        return browser.grantPermissions(browserContextId, origin, permissions);
    }

    @Override
    public Future resetPermissions() {
        return browser.resetPermissions(browserContextId);
    }

    @Override
    public Future<Page> newPage(String url, Integer width, Integer height) {
        return SeriesFuture
                .wrap(browser.createTarget(browserContextId, url, width, height))
                .sync(o -> newPage(o, null));
    }

    @Override
    public Page[] pages() {
        Collection<ChromePage> values = targetMap.values();
        Page[] pages = new Page[values.size()];
        return values.toArray(pages);
    }

    @Override
    public Future setCookies(CookieParam... cookies) {
        return browser.setCookies(browserContextId, cookies);
    }

    @Override
    public Future clearCookies() {
        return browser.clearCookies(browserContextId);
    }

    @Override
    public Future<Cookie[]> getCookies() {
        return browser.getCookies(browserContextId);
    }

    @Override
    public Future close() {
        return browser.closeContext(browserContextId);
    }

    public String browserContextId() {
        return browserContextId;
    }

    public EventExecutor executor() {
        return browser.executor();
    }

    public Future activateTarget(String targetId) {
        return browser.activateTarget(targetId);
    }

    public Future closeTarget(String targetId) {
        ChromePage page = targetMap.remove(targetId);
        if (page == null) {
            Promise promise = new DefaultPromise(executor());
            promise.trySuccess(null);
            return promise;
        } else {
            sessionMap.remove(page.sessionId());
            return browser.closeTarget(targetId);
        }
    }

    public Future exposeTarget(String targetId, String bindingName) {
        return browser.exposeTarget(targetId, bindingName);
    }
}
