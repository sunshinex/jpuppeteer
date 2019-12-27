package jpuppeteer.chrome;

import com.google.common.collect.MapMaker;
import jpuppeteer.api.browser.BrowserContext;
import jpuppeteer.api.browser.Cookie;
import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.event.DefaultEventEmitter;
import jpuppeteer.api.future.DefaultPromise;
import jpuppeteer.api.future.Promise;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.cdp.entity.fetch.AuthRequiredEvent;
import jpuppeteer.cdp.cdp.entity.fetch.RequestPausedEvent;
import jpuppeteer.cdp.cdp.entity.log.EntryAddedEvent;
import jpuppeteer.cdp.cdp.entity.network.LoadingFailedEvent;
import jpuppeteer.cdp.cdp.entity.network.LoadingFinishedEvent;
import jpuppeteer.cdp.cdp.entity.network.RequestWillBeSentEvent;
import jpuppeteer.cdp.cdp.entity.network.ResponseReceivedEvent;
import jpuppeteer.cdp.cdp.entity.page.*;
import jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextCreatedEvent;
import jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextDestroyedEvent;
import jpuppeteer.cdp.cdp.entity.target.AttachedToTargetEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetCrashedEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetInfo;
import jpuppeteer.cdp.constant.TargetType;
import jpuppeteer.chrome.event.*;
import jpuppeteer.chrome.event.type.ChromeContextEvent;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import jpuppeteer.chrome.util.URLUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.event.type.ChromeContextEvent.*;

public class ChromeContext extends DefaultEventEmitter<ChromeContextEvent> implements BrowserContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeContext.class);

    private static final String NEW_PAGE_URL_PREFIX = "about:blank?uuid=";

    private final String name;

    private final AtomicInteger pageCounter;

    private ChromeBrowser browser;

    private String browserContextId;

    private Map<String/*targetId*/, ChromePage> targetMap;

    private Map<String/*sessionId*/, ChromePage> sessionMap;

    /**
     * @see #newPage()
     */
    private Map<String/*uuid*/, Promise<ChromePage>> promiseMap;

    private ChromePage defaultPage;

    public ChromeContext(String name, ChromeBrowser browser, String browserContextId) throws Exception {
        super(Executors.newSingleThreadExecutor(r -> new Thread(r, name)));
        this.name = name;
        this.pageCounter = new AtomicInteger(0);
        this.browser = browser;
        this.browserContextId = browserContextId;
        MapMaker mapMaker = new MapMaker().weakValues().concurrencyLevel(16);
        this.targetMap = mapMaker.makeMap();
        this.sessionMap = mapMaker.makeMap();
        this.promiseMap = new ConcurrentHashMap<>();
        this.createDefaultPage();

        addListener(ATTACHEDTOTARGET, (AttachedToTargetEvent event) -> handleTargetAttached(event));
        addListener(TARGETDESTROYED, (String targetId) -> handleTargetDestroyed(targetId));
        addListener(TARGETINFOCHANGED, (TargetInfo targetInfo) -> handleTargetChanged(targetInfo));
        addListener(TARGETCRASHED, (TargetCrashedEvent event) -> handleTargetCrashed(event));

        handleSessionEvent(FRAMEATTACHED, (pg, event) -> handleFrameAttached(pg, event), FrameAttachedEvent.class);
        handleSessionEvent(FRAMENAVIGATED, (pg, event) -> handleFrameNavigated(pg, event), FrameNavigatedEvent.class);
        handleSessionEvent(FRAMEDETACHED, (pg, event) -> handleFrameDetached(pg, event), FrameDetachedEvent.class);

        transmitSessionEvent(LIFECYCLEEVENT, ChromePageEvent.LIFECYCLEEVENT);
        handleSessionEvent(DOMCONTENTEVENTFIRED, (pg, event) -> pg.emit(ChromePageEvent.DOMCONTENTLOADED, event.getTimestamp()), DomContentEventFiredEvent.class);
        handleSessionEvent(LOADEVENTFIRED, (pg, event) -> pg.emit(ChromePageEvent.LOAD, event.getTimestamp()), LoadEventFiredEvent.class);
        handleSessionEvent(ENTRYADDED, (pg, event) -> pg.emit(ChromePageEvent.CONSOLE, event.getEntry()), EntryAddedEvent.class);
        handleSessionEvent(JAVASCRIPTDIALOGOPENING, (pg, event) -> {
            pg.emit(ChromePageEvent.DIALOG, new Dialog(pg.page, event.getType(), event.getMessage(), event.getDefaultPrompt()));
        }, JavascriptDialogOpeningEvent.class);
        transmitSessionEvent(EXCEPTIONTHROWN, ChromePageEvent.PAGEERROR);

        handleSessionEvent(EXECUTIONCONTEXTCREATED, (pg, event) -> pg.handleExecutionCreated(event), ExecutionContextCreatedEvent.class);
        handleSessionEvent(EXECUTIONCONTEXTDESTROYED, (pg, event) -> pg.handleExecutionDestroyed(event), ExecutionContextDestroyedEvent.class);
        handleSessionEvent(EXECUTIONCONTEXTSCLEARED, (pg, event) -> pg.handleExecutionCleared(), null);

        handleSessionEvent(REQUESTWILLBESENT, (pg, event) -> {
            Request request = pg.handleRequest(event);
            if (request != null) {
                pg.emit(ChromePageEvent.REQUEST, request);
            }
        }, RequestWillBeSentEvent.class);

        handleSessionEvent(RESPONSERECEIVED, (pg, event) -> {
            Response response = pg.handleResponse(event);
            if (response != null) {
                pg.emit(ChromePageEvent.RESPONSE, response);
            }
        }, ResponseReceivedEvent.class);

        handleSessionEvent(LOADINGFAILED, (pg, event) -> {
            RequestFailed requestFailed = pg.handleRequestFailed(event);
            if (requestFailed != null) {
                pg.emit(ChromePageEvent.REQUESTFAILED, requestFailed);
            }
        }, LoadingFailedEvent.class);

        handleSessionEvent(LOADINGFINISHED, (pg, event) -> {
            RequestFinished requestFinished = pg.handleRequestFinished(event);
            if (requestFinished != null) {
                pg.emit(ChromePageEvent.REQUESTFINISHED, requestFinished);
            }
        }, LoadingFinishedEvent.class);

        handleSessionEvent(REQUESTPAUSED, (pg, event) -> {
            Request request = pg.handleRequestInterception(event);
            if (request != null) {
                pg.emit(ChromePageEvent.REQUEST, request);
            }
        }, RequestPausedEvent.class);

        handleSessionEvent(AUTHREQUIRED, (pg, event) -> pg.doAuthenticate(event.getRequestId()), AuthRequiredEvent.class);
    }

    private String nextPageName() {
        return name + "-Page-" + pageCounter.getAndIncrement();
    }

    private <T> void handleSessionEvent(ChromeContextEvent eventType, EventHandler<T> handler, Class<T> clazz) {
        if (!CDPEvent.class.equals(eventType.getClazz())) {
            throw new IllegalArgumentException("invaild event type:" + eventType.getClazz().getName());
        }
        addListener(eventType, (CDPEvent event) -> {
            ChromePage pg = sessionMap.get(event.getSessionId());
            if (pg == null) {
                logger.error("handle event failed:session not found, event={} sessionId={}", eventType.name(), event.getSessionId());
                return;
            }
            T evt = clazz != null ? event.getObject(clazz) : null;
            handler.handle(pg, evt);
        });
    }

    private void transmitSessionEvent(ChromeContextEvent from, ChromePageEvent to) {
        handleSessionEvent(from, (pg, event) -> pg.emit(to, event), to.getClazz());
    }

    private void handleTargetAttached(AttachedToTargetEvent event) {
        TargetInfo targetInfo = event.getTargetInfo();
        String targetId = targetInfo.getTargetId();
        String sessionId = event.getSessionId();
        ChromePage opener = null;
        String openerId = targetInfo.getOpenerId();
        if (StringUtils.isNotEmpty(openerId)) {
            opener = targetMap.get(openerId);
            if (opener == null) {
                logger.error("target opener not found, openerId={}, targetId={}", openerId, targetId);
                return;
            }
        }

        String url = targetInfo.getUrl();
        Promise<ChromePage> promise = null;
        if (url.startsWith(NEW_PAGE_URL_PREFIX)) {
            //newPage创建的页面
            String uuid = url.substring(NEW_PAGE_URL_PREFIX.length());
            if (StringUtils.isNotEmpty(uuid)) {
                promise = promiseMap.get(uuid);
            }
        }

        TargetType targetType = TargetType.findByValue(targetInfo.getType());

        try {
            ChromePage page = new ChromePage(nextPageName(), this, browser.createSession(targetType, sessionId), targetInfo, opener);
            targetMap.put(targetId, page);
            sessionMap.put(sessionId, page);
            if (promise != null) {
                promise.setSuccess(page);
            }
            try {
                emit(NEWPAGE, page);
                if (opener != null) {
                    opener.emit(ChromePageEvent.OPENPAGE, page);
                }
            } catch (Exception e) {
                logger.error("emit newpage or openpage event failed, error={}", e.getMessage(), e);
            }
        } catch (Exception e) {
            if (promise != null) {
                promise.setFailure(e);
            }
            logger.error("create page instance failed, error={}", e.getMessage(), e);
        }
    }

    private void handleTargetDestroyed(String targetId) {
        ChromePage pg = targetMap.remove(targetId);
        if (pg != null) {
            //@TODO 此处没有从sessionMap中删除, sessionMap为value弱引用, 理论来说下一次垃圾回收的时候是会被干掉的
            logger.info("target destroyed, targetId={}", targetId);
        }
    }

    private void handleTargetChanged(TargetInfo targetInfo) {
        ChromePage pg = targetMap.get(targetInfo.getTargetId());
        if (pg != null) {
            pg.emit(ChromePageEvent.CHANGED, targetInfo);
        }
    }

    private void handleTargetCrashed(TargetCrashedEvent event) {
        ChromePage pg = targetMap.get(event.getTargetId());
        if (pg != null) {
            pg.emit(ChromePageEvent.CRASHED, event);
        }
    }

    private void handleFrameAttached(ChromePage pg, FrameAttachedEvent event) {
        ChromeFrame parent = pg.find(event.getParentFrameId());
        if (parent == null) {
            logger.warn("parent frame not found, parentId={}", event.getParentFrameId());
            return;
        }
        pg.emit(ChromePageEvent.FRAMEATTACHED, parent.append(event.getFrameId()));
        logger.info("frame attached, parent={}, frameId={}", event.getParentFrameId(), event.getFrameId());
    }

    private void handleFrameNavigated(ChromePage pg, FrameNavigatedEvent event) {
        Frame frm = event.getFrame();
        ChromeFrame frame = pg.find(frm.getId());
        if (frame == null) {
            logger.warn("frame not found, frameId={}", frm.getId());
            return;
        }
        frame.setUrl(URLUtils.parse(frm.getUrl()));
        frame.setName(frm.getName());
        frame.setMimeType(frm.getMimeType());
        frame.setUnreachableUrl(URLUtils.parse(frm.getUnreachableUrl()));
        frame.setSecurityOrigin(frm.getSecurityOrigin());
        pg.emit(ChromePageEvent.FRAMENAVIGATED, frame);
    }

    private void handleFrameDetached(ChromePage pg, FrameDetachedEvent event) {
        ChromeFrame frame = pg.find(event.getFrameId());
        if (frame == null) {
            logger.warn("frame not found, frameId={}", event.getFrameId());
            return;
        }
        frame.remove();
        pg.emit(ChromePageEvent.FRAMEDETACHED, frame);
        logger.info("frame attached, parent={}, frameId={}", frame.parent.frameId, event.getFrameId());
    }

    private void createDefaultPage() throws Exception {
        List<TargetInfo> targets = browser.getTargets(browserContextId).stream()
                .filter(targetInfo -> TargetType.PAGE.getValue().equals(targetInfo.getType()))
                .collect(Collectors.toList());
        TargetInfo targetInfo;
        if (targets.size() == 0) {
            //没有默认页
            //创建一个
            String targetId = browser.createTarget(browserContextId);
            try {
                targetInfo = browser.getTargets(browserContextId).stream()
                        .filter(tinfo -> targetId.equals(tinfo.getTargetId()))
                        .findAny()
                        .get();
            } catch (Exception e) {
                browser.closeTarget(targetId);
                throw e;
            }
        } else if (targets.size() == 1) {
            //有一个默认页
            targetInfo = targets.get(0);
        } else {
            //有多个默认页
            //留下第一个, 其余的关闭掉
            targetInfo = targets.get(0);
            for(int i=1; i<targets.size(); i++) {
                String tid = targets.get(i).getTargetId();
                try {
                    browser.closeTarget(tid);
                } catch (Exception e) {
                    logger.error("close startup page failed, targetId={}", tid);
                }
            }
        }
        TargetType targetType = TargetType.findByValue(targetInfo.getType());
        String sessionId = browser.attachToTarget(targetInfo.getTargetId());
        ChromePage page = new ChromePage(nextPageName(), this, browser.createSession(targetType, sessionId), targetInfo, null);
        targetMap.put(targetInfo.getTargetId(), page);
        sessionMap.put(sessionId, page);
        this.defaultPage = page;
    }

    protected ChromePage defaultPage() {
        return defaultPage;
    }


    @Override
    public ChromeBrowser browser() {
        return browser;
    }

    @Override
    public void resetPermissions() throws Exception {
        browser.resetPermissions(browserContextId);
    }

    @Override
    public void grantPermissions(String origin, PermissionType... permissions) throws Exception {
        browser.grantPermissions(browserContextId, origin, permissions);
    }

    @Override
    public ChromePage newPage() throws Exception {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Promise<ChromePage> promise = new DefaultPromise<>();
        promiseMap.put(uuid, promise);
        String targetId = browser.createTarget(browserContextId, uuid);
        try {
            ChromePage page = promise.get(1, TimeUnit.SECONDS);
            if (!Objects.equals(targetId, page.targetInfo().getTargetId())) {
                throw new RuntimeException("targetId not match, expect:" + targetId + ", actual:" + page.targetInfo().getTargetId());
            }
            logger.info("page created, targetId={}", targetId);
            return page;
        } catch (Exception e) {
            browser.closeTarget(targetId);
            logger.warn("create page failed, targetId={}", targetId);
            throw e;
        } finally {
            promiseMap.remove(uuid);
        }
    }

    @Override
    public ChromePage[] pages() throws Exception {
        List<ChromePage> pageList = targetMap.values().stream()
                .filter(page -> page != null)
                .collect(Collectors.toList());
        ChromePage[] pages = new ChromePage[pageList.size()];
        return pageList.toArray(pages);
    }

    @Override
    public void setCookies(Cookie... cookies) throws Exception {
        defaultPage.setCookies(cookies);
        //browser.setCookies(browserContextId, CookieUtils.toList(cookies));
    }

    @Override
    public void deleteCookies(String name, String domain, String path, String url) throws Exception {
        defaultPage.deleteCookies(name, domain, path, url);
    }

    @Override
    public void clearCookies() throws Exception {
        if (browserContextId == null) {
            //初始上下文可以使用Network.clearBrowserCookies
            defaultPage.doClearCookies();
        } else {
            //自己创建的上下文需要自己一个一个删除
            List<Cookie> cookies = cookies();
            List<Future> futures = new ArrayList<>(cookies.size());
            for(Cookie cookie : cookies) {
                futures.add(defaultPage.asyncDeleteCookies(cookie.getName(), cookie.getDomain(), cookie.getPath(), cookie.getUrl()));
            }
            for(Future future : futures) {
                future.get(1, TimeUnit.SECONDS);
            }
        }
        //defaultPage.doClearCookies();
        //browser.clearCookies(browserContextId);
    }

    @Override
    public List<Cookie> cookies() throws Exception {
        return defaultPage.doGetCookies();
//        List<jpuppeteer.cdp.cdp.entity.network.Cookie> cookieList = browser.getCookies(browserContextId);
//        Cookie[] cookies = new Cookie[cookieList.size()];
//        for(int i = 0; i<cookieList.size(); i++) {
//            cookies[i] = CookieUtils.copyOf(cookieList.get(i));
//        }
//        return cookies;
    }

    @FunctionalInterface
    private interface EventHandler<T> {

        void handle(ChromePage pg, T event);

    }
}
