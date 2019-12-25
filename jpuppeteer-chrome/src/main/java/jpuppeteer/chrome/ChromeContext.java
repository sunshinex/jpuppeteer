package jpuppeteer.chrome;

import com.google.common.collect.MapMaker;
import jpuppeteer.api.browser.BrowserContext;
import jpuppeteer.api.browser.Cookie;
import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.event.DefaultEventEmitter;
import jpuppeteer.api.future.DefaultPromise;
import jpuppeteer.api.future.Promise;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.CDPSession;
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
import jpuppeteer.chrome.event.Dialog;
import jpuppeteer.chrome.event.Request;
import jpuppeteer.chrome.event.RequestFailed;
import jpuppeteer.chrome.event.Response;
import jpuppeteer.chrome.event.type.ChromeContextEvent;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import jpuppeteer.chrome.util.CookieUtils;
import jpuppeteer.chrome.util.URLUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.event.type.ChromeContextEvent.*;

public class ChromeContext extends DefaultEventEmitter<ChromeContextEvent> implements BrowserContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeContext.class);

    private final String name;

    private final AtomicInteger pageCounter;

    private ChromeBrowser browser;

    private String browserContextId;

    private Map<String/*targetId*/, ChromePage> targetMap;

    private Map<String/*sessionId*/, ChromePage> sessionMap;

    private ChromePage defaultPage;

    private Lock lock;

    public ChromeContext(String name, ChromeBrowser browser, String browserContextId) throws Exception {
        super(Executors.newSingleThreadExecutor(r -> new Thread(r, name)));
        this.name = name;
        this.pageCounter = new AtomicInteger(0);
        this.browser = browser;
        this.browserContextId = browserContextId;
        MapMaker mapMaker = new MapMaker().weakValues().concurrencyLevel(16);
        this.targetMap = mapMaker.makeMap();
        this.sessionMap = mapMaker.makeMap();
        this.lock = new ReentrantLock();
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
            Request request = pg.handleRequestFinished(event);
            if (request != null) {
                pg.emit(ChromePageEvent.REQUESTFINISHED, request);
            }
        }, LoadingFinishedEvent.class);

        handleSessionEvent(REQUESTPAUSED, (pg, event) -> {
            Request request = pg.handleRequestInterception(event);
            if (request != null) {
                pg.emit(ChromePageEvent.REQUEST, request);
            }
        }, RequestPausedEvent.class);

        handleSessionEvent(AUTHREQUIRED, (pg, event) -> pg.doAuthenticate(event.getRequestId()), AuthRequiredEvent.class);

        //@TODO 需要考虑无用的页面定时关闭, 避免某些页面弹出的窗口无法手动关闭
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

    private ChromePage getPageWithLock(String targetId) {
        lock.lock();
        try {
            return targetMap.get(targetId);
        } finally {
            lock.unlock();
        }
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

        if (ChromePage.PLACEHOLDER.equals(getPageWithLock(targetId))) {
            logger.debug("manual page creation not done, ignore this event targetId={}", targetId);
            return;
        }

        TargetType targetType = TargetType.findByValue(targetInfo.getType());

        try {
            ChromePage page = new ChromePage(nextPageName(), this, browser.createSession(targetType, sessionId), targetInfo, opener);
            targetMap.put(targetId, page);
            sessionMap.put(sessionId, page);
            if (opener != null) {
                opener.emit(ChromePageEvent.OPENPAGE, page);
            } else {
                emit(NEWPAGE, page);
            }
        } catch (Exception e) {
            logger.error("create page instance failed, error={}", e.getMessage(), e);
        }
    }

    private void handleTargetDestroyed(String targetId) {
        if (ChromePage.PLACEHOLDER.equals(getPageWithLock(targetId))) {
            logger.debug("manual page creation not done, ignore this event targetId={}", targetId);
            return;
        }
        ChromePage pg = targetMap.remove(targetId);
        if (pg != null) {
            //@TODO 此处没有从sessionMap中删除, sessionMap为value弱引用, 理论来说下一次垃圾回收的时候是会被干掉的
            logger.info("target destroyed, targetId={}", targetId);
        }
    }

    private void handleTargetChanged(TargetInfo targetInfo) {
        if (ChromePage.PLACEHOLDER.equals(getPageWithLock(targetInfo.getTargetId()))) {
            logger.debug("manual page creation not done, ignore this event targetId={}", targetInfo.getTargetId());
            return;
        }
        ChromePage pg = targetMap.get(targetInfo.getTargetId());
        if (pg == null) {
            logger.error("target changed failed, targetId={}", targetInfo.getTargetId());
            return;
        }
        pg.emit(ChromePageEvent.CHANGED, targetInfo);
    }

    private void handleTargetCrashed(TargetCrashedEvent event) {
        if (ChromePage.PLACEHOLDER.equals(getPageWithLock(event.getTargetId()))) {
            logger.debug("manual page creation not done, ignore this event targetId={}", event.getTargetId());
            return;
        }
        ChromePage pg = targetMap.get(event.getTargetId());
        if (pg == null) {
            logger.error("target crashed failed, targetId={}", event.getTargetId());
            return;
        }
        pg.emit(ChromePageEvent.CRASHED, event);
    }

    private void handleFrameAttached(ChromePage pg, FrameAttachedEvent event) {
        ChromeFrame parent = pg.find(event.getParentFrameId());
        if (parent == null) {
            logger.warn("parent frame not found, parentId={}", event.getParentFrameId());
            return;
        }
        pg.emit(ChromePageEvent.FRAMEATTACHED, parent.append(event.getFrameId()));
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
    }

    private void createDefaultPage() throws Exception {
        List<TargetInfo> targets = browser.getTargets(browserContextId).stream()
                .filter(targetInfo -> TargetType.PAGE.getValue().equals(targetInfo.getType()))
                .collect(Collectors.toList());
        TargetInfo targetInfo;
        if (targets.size() == 0) {
            //没有默认页
            //创建一个
            targetInfo = doCreateTarget();
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
        this.defaultPage = doAttachTarget(targetInfo);
    }

    private TargetInfo doCreateTarget() throws Exception {
        String targetId;
        lock.lock();
        try {
            targetId = browser.createTarget(browserContextId);
            //为了尽量缩短锁的时间, 采用占位符的方式
            targetMap.put(targetId, ChromePage.PLACEHOLDER);
        } finally {
            lock.unlock();
        }
        try {
            return browser.getTargets(browserContextId).stream()
                    .filter(targetInfo -> targetId.equals(targetInfo.getTargetId()))
                    .findAny()
                    .get();
        } catch (Exception e) {
            targetMap.remove(targetId);
            browser.closeTarget(targetId);
            throw e;
        }
    }

    private ChromePage doAttachTarget(TargetInfo targetInfo) throws Exception {
        String sessionId = browser.attachToTarget(targetInfo.getTargetId());
        ChromePage page = new ChromePage(nextPageName(), this, browser.createSession(TargetType.PAGE, sessionId), targetInfo, null);
        targetMap.put(targetInfo.getTargetId(), page);
        sessionMap.put(sessionId, page);
        logger.info("target attached, targetId={}, sessionId={}", targetInfo.getTargetId(), sessionId);
        return page;
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
        TargetInfo targetInfo = doCreateTarget();
        try {
            return doAttachTarget(targetInfo);
        } catch (Exception e) {
            browser.closeTarget(targetInfo.getTargetId());
            throw e;
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
        browser.setCookies(browserContextId, CookieUtils.toList(cookies));
    }

    @Override
    public void clearCookies() throws Exception {
        browser.clearCookies(browserContextId);
    }

    @Override
    public Cookie[] cookies() throws Exception {
        List<jpuppeteer.cdp.cdp.entity.network.Cookie> cookieList = browser.getCookies(browserContextId);
        Cookie[] cookies = new Cookie[cookieList.size()];
        for(int i = 0; i<cookieList.size(); i++) {
            cookies[i] = CookieUtils.copyOf(cookieList.get(i));
        }
        return cookies;
    }

    @FunctionalInterface
    private interface EventHandler<T> {

        void handle(ChromePage pg, T event);

    }
}
