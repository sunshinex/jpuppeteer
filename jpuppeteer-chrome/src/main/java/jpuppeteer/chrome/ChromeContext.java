package jpuppeteer.chrome;

import com.google.common.collect.MapMaker;
import com.sun.webkit.network.data.Handler;
import jpuppeteer.api.browser.BrowserContext;
import jpuppeteer.api.browser.Header;
import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.constant.ResourceType;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.future.DefaultPromise;
import jpuppeteer.api.future.Promise;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.constant.network.BlockedReason;
import jpuppeteer.cdp.cdp.domain.Browser;
import jpuppeteer.cdp.cdp.domain.Target;
import jpuppeteer.cdp.cdp.entity.browser.GrantPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.browser.ResetPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.log.EntryAddedEvent;
import jpuppeteer.cdp.cdp.entity.network.LoadingFailedEvent;
import jpuppeteer.cdp.cdp.entity.network.LoadingFinishedEvent;
import jpuppeteer.cdp.cdp.entity.network.RequestWillBeSentEvent;
import jpuppeteer.cdp.cdp.entity.network.ResponseReceivedEvent;
import jpuppeteer.cdp.cdp.entity.page.*;
import jpuppeteer.cdp.cdp.entity.target.*;
import jpuppeteer.cdp.constant.TargetType;
import jpuppeteer.chrome.entity.RequestEvent;
import jpuppeteer.chrome.entity.SecurityDetails;
import jpuppeteer.chrome.event.Dialog;
import jpuppeteer.chrome.event.Request;
import jpuppeteer.chrome.event.RequestFailed;
import jpuppeteer.chrome.event.Response;
import jpuppeteer.chrome.event.type.ChromeBrowserEvent;
import jpuppeteer.chrome.event.type.ChromeFrameEvent;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import jpuppeteer.chrome.util.HttpUtils;
import jpuppeteer.chrome.util.URLUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;
import static jpuppeteer.chrome.event.type.ChromeBrowserEvent.*;

public class ChromeContext implements EventEmitter<ChromeBrowserEvent>, BrowserContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeContext.class);

    private CDPConnection connection;

    private ChromeBrowser browser;

    private String browserContextId;

    private Browser domainBrowser;

    private Target target;

    private Map<String/*targetId*/, ChromePage> pageMap;

    private Map<String/*sessionId*/, ChromePage> sessionMap;

    private Map<String/*targetId*/, Promise<ChromePage>> promiseMap;

    private Map<String/*sessionId*/, Map<String/*requestId*/, Request>> requestMap;

    public ChromeContext(ChromeBrowser browser, String browserContextId) {
        this.connection = connection;
        this.browser = browser;
        this.browserContextId = browserContextId;
        MapMaker mapMaker = new MapMaker().weakValues().concurrencyLevel(16);
        this.pageMap = mapMaker.makeMap();
        this.sessionMap = mapMaker.makeMap();
        this.promiseMap = new ConcurrentHashMap<>();
        this.requestMap = new ConcurrentHashMap<>();
        this.domainBrowser = new Browser(connection);
        this.target = new Target(connection);

        //绑定事件
        addListener(TARGETCREATED, (CDPEvent event) -> {
            TargetCreatedEvent evt = event.getObject(TargetCreatedEvent.class);
            TargetInfo target = evt.getTargetInfo();
            TargetType targetType = TargetType.findByValue(target.getType());
            if (!(TargetType.PAGE.equals(targetType))) {
                logger.debug("target is not page, ignore! target={}", target);
                return;
            }
            String targetId = target.getTargetId();
            try {
                //对所有创建的页面, 自动附加
                String sessionId = browser.attachToTarget(targetId);
                logger.info("attach target success, targetId={}, sessionId={}", targetId, sessionId);
            } catch (Exception e) {
                logger.error("attach target failed, targetId={}, error={}", targetId, e.getMessage(), e);
            }
        });
        addListener(ATTACHEDTOTARGET, (CDPEvent event) -> {
            AttachedToTargetEvent evt = event.getObject(AttachedToTargetEvent.class);
            TargetInfo target = evt.getTargetInfo();
            String sessionId = event.getSessionId();
            String targetId = target.getTargetId();
            TargetType targetType = TargetType.findByValue(target.getType());
            logger.info("target attached, targetId={}, sessionId={}", targetId, sessionId);
            String openerId = target.getOpenerId();
            ChromePage opener = null;
            if (StringUtils.isNotEmpty(openerId)) {
                opener = pageMap.get(openerId);
                if (opener == null) {
                    logger.error("target opener not found, openerId={}, targetId={}", openerId, targetId);
                    return;
                }
            }
            Promise<ChromePage> promise = promiseMap.get(targetId);
            try {
                ChromePage page = new ChromePage(browser.getName(), this, new CDPSession(connection, targetType, sessionId), targetId, opener, sessionId);
                if (pageMap.put(targetId, page) != null) {
                    logger.warn("target exists, targetId={}", targetId);
                }
                if (sessionMap.put(sessionId, page) != null) {
                    logger.warn("session exists, sessionId={}", sessionId);
                }
                requestMap.put(sessionId, new ConcurrentHashMap<>());
                if (promise != null) {
                    promise.setSuccess(page);
                }
                if (opener != null) {
                    opener.emit(ChromePageEvent.OPENPAGE, page);
                }
            } catch (Exception e) {
                if (promise != null) {
                    promise.setFailure(e);
                }
                logger.error("create page instance failed, error={}", e.getMessage(), e);
            }
        });
        addListener(TARGETDESTROYED, (CDPEvent event) -> {
            TargetDestroyedEvent evt = event.getObject(TargetDestroyedEvent.class);
            String targetId = evt.getTargetId();
            ChromePage pg = pageMap.remove(targetId);
            if (pg != null) {
                sessionMap.remove(pg.sessionId);
                requestMap.remove(pg.sessionId);
                pg.emit(ChromePageEvent.CLOSED, null);
                logger.info("target destroyed, targetId={}", targetId);
            }
        });
        addListener(TARGETCRASHED, (CDPEvent event) -> {
            TargetCrashedEvent evt = event.getObject(TargetCrashedEvent.class);
            String targetId = evt.getTargetId();
            ChromePage pg = pageMap.get(targetId);
            if (pg != null) {
                pg.emit(ChromePageEvent.CRASHED, event);
                logger.error("target crashed, targetId={}, sessionId={}", targetId, pg.sessionId);
            }
        });
        addListener(TARGETINFOCHANGED, (CDPEvent object) -> {
            TargetInfoChangedEvent event =  object.getObject(TargetInfoChangedEvent.class);
            ChromePage pg = pageMap.get(event.getTargetInfo().getTargetId());
            if (pg != null) {
                pg.emit(ChromePageEvent.CHANGED, event.getTargetInfo());
            }
        });
        addSessionListener(FRAMEATTACHED, (pg, event) -> {
            FrameAttachedEvent evt = event.getObject(FrameAttachedEvent.class);
            ChromeFrame parent = pg.find(evt.getParentFrameId());
            if (parent == null) {
                logger.warn("parent frame not found, parentId={}", evt.getParentFrameId());
                return;
            }
            parent.emit(ChromeFrameEvent.FRAMEATTACHED, evt.getFrameId());
        });
        addSessionListener(FRAMEDETACHED, (pg, event) -> {
            FrameDetachedEvent evt = event.getObject(FrameDetachedEvent.class);
            ChromeFrame frame = pg.find(evt.getFrameId());
            if (frame == null) {
                logger.warn("detached frame not found, frameId={}", evt.getFrameId());
                return;
            }
            frame.parent.emit(ChromeFrameEvent.FRAMEDETACHED, frame);
        });
        addSessionListener(FRAMENAVIGATED, (pg, event) -> {
            FrameNavigatedEvent evt = event.getObject(FrameNavigatedEvent.class);
            Frame frm = evt.getFrame();
            ChromeFrame frame = pg.find(frm.getId());
            if (frame == null) {
                logger.warn("navigated frame not found, frameId={}", frm.getId());
                return;
            }
            frame.emit(ChromeFrameEvent.FRAMENAVIGATED, frm);
        });
        transmitFrameListener(LIFECYCLEEVENT, ChromeFrameEvent.LIFECYCLEEVENT);
        addSessionListener(DOMCONTENTEVENTFIRED, (pg, event) -> {
            DomContentEventFiredEvent evt = event.getObject(DomContentEventFiredEvent.class);
            pg.emit(ChromePageEvent.DOMCONTENTLOADED, evt.getTimestamp());
        });
        addSessionListener(LOADEVENTFIRED, (pg, event) -> {
            LoadEventFiredEvent evt = event.getObject(LoadEventFiredEvent.class);
            pg.emit(ChromePageEvent.LOAD, evt.getTimestamp());
        });
        addSessionListener(ENTRYADDED, (pg, event) -> {
            EntryAddedEvent evt = event.getObject(EntryAddedEvent.class);
            pg.emit(ChromePageEvent.CONSOLE, evt.getEntry());
        });
        addSessionListener(JAVASCRIPTDIALOGOPENING, (pg, event) -> {
            JavascriptDialogOpeningEvent evt = event.getObject(JavascriptDialogOpeningEvent.class);
            pg.emit(ChromePageEvent.DIALOG, new Dialog(pg.page, evt.getType(), evt.getMessage(), evt.getDefaultPrompt()));
        });
        transmitPageListener(EXCEPTIONTHROWN, ChromePageEvent.PAGEERROR);
        //处理请求
        addSessionListener(REQUESTWILLBESENT, (pg, event) -> {
            RequestWillBeSentEvent evt = event.getObject(RequestWillBeSentEvent.class);
            RequestEvent requestEvent = RequestEvent.builder()
                    .frameId(evt.getFrameId())
                    .loaderId(evt.getLoaderId())
                    .requestId(evt.getRequestId())
                    .resourceType(ResourceType.findByValue(evt.getType()))
                    .request(evt.getRequest())
                    .build();
            handleRequestEvent(pg, requestEvent);
        });
        addSessionListener(RESPONSERECEIVED, (pg, event) -> {
            ResponseReceivedEvent evt = event.getObject(ResponseReceivedEvent.class);
            ChromeFrame frame = pg.find(evt.getFrameId());
            if (frame == null) {
                logger.warn("response event frame not found, requestId={}, frameId={}", evt.getRequestId(), evt.getFrameId());
                return;
            }
            Request request = getRequest(pg.sessionId, evt.getRequestId());
            if (request == null) {
                return;
            }
            jpuppeteer.cdp.cdp.entity.network.Response res = evt.getResponse();
            URL url = URLUtils.parse(res.getUrl());
            SecurityDetails securityDetails = null;
            if (res.getSecurityDetails() != null) {
                securityDetails = SecurityDetails.builder()
                        .issuer(res.getSecurityDetails().getIssuer())
                        .protocol(res.getSecurityDetails().getProtocol())
                        .subjectName(res.getSecurityDetails().getSubjectName())
                        .vaildFrom(new Date(res.getSecurityDetails().getValidFrom().longValue() * 1000))
                        .vaildTo(new Date(res.getSecurityDetails().getValidTo().longValue() * 1000))
                        .build();
            }
            List<Header> headers = HttpUtils.parseHeader(res.getHeaders());
            Response response = Response.builder()
                    .session(pg.session)
                    .network(pg.network)
                    .frame(frame)
                    .fromCache(res.getFromDiskCache())
                    .request(request)
                    .url(url)
                    .status(res.getStatus())
                    .statusText(res.getStatusText())
                    .headers(headers)
                    .remoteAddress(res.getRemoteIPAddress() + ":" + res.getRemotePort())
                    .securityDetails(securityDetails)
                    .build();

            request.setResponse(response);
            pg.emit(ChromePageEvent.RESPONSE, response);
        });
        addSessionListener(LOADINGFAILED, (pg, event) -> {
            LoadingFailedEvent evt = event.getObject(LoadingFailedEvent.class);
            Request request = getRequest(pg.sessionId, evt.getRequestId());
            if (request == null) {
                return;
            }
            pg.emit(ChromePageEvent.REQUESTFAILED, new RequestFailed(request, evt.getErrorText(), evt.getCanceled(), BlockedReason.findByValue(evt.getBlockedReason())));
        });
        addSessionListener(LOADINGFINISHED, (pg, event) -> {
            LoadingFinishedEvent evt = event.getObject(LoadingFinishedEvent.class);
            Request request = getRequest(pg.sessionId, evt.getRequestId());
            if (request == null) {
                return;
            }
            pg.emit(ChromePageEvent.REQUESTFINISHED, request);
        });
    }

    private Request getRequest(String sessionId, String requestId) {
        Map<String, Request> map = requestMap.get(sessionId);
        if (map == null) {
            logger.error("request map is null, sessionId={}", sessionId);
            return null;
        }
        Request request = map.get(requestId);
        if (request == null) {
            logger.error("request for response is null, sessionId={}, requestId={}", sessionId, requestId);
            return null;
        }
        return request;
    }

    private void handleRequestEvent(ChromePage pg, RequestEvent event) {
        jpuppeteer.cdp.cdp.entity.network.Request req = event.getRequest();
        ChromeFrame frame = pg.find(event.getFrameId());
        if (frame == null) {
            logger.warn("request event frame not found, requestId={}, frameId={}", event.getRequestId(), event.getFrameId());
            return;
        }
        String urlStr = req.getUrl();
        String fragment = req.getUrlFragment();
        URL url = URLUtils.parse(urlStr + (fragment != null ? fragment : ""));
        Request request = Request.builder()
                .session(pg.session)
                .network(pg.network)
                .fetch(pg.fetch)
                .frame(frame)
                .loaderId(event.getLoaderId())
                .requestId(event.getRequestId())
                .interceptorId(event.getInterceptorId())
                .method(req.getMethod())
                .url(url)
                .resourceType(event.getResourceType())
                .headers(HttpUtils.parseHeader(req.getHeaders()))
                .hasPostData(Boolean.TRUE.equals(req.getHasPostData()))
                .build();
        //requestMap.put(buildRequestId(pg.sessionId, event.getRequestId()), request);
        pg.emit(ChromePageEvent.REQUEST, request);
    }

    @FunctionalInterface
    private interface SessionHandler<T> {

        void accept(ChromePage pg, T event);

    }

    private void addSessionListener(ChromeBrowserEvent from, SessionHandler<CDPEvent> handler) {
        addListener(from, (CDPEvent object) -> {
            String sessionId = object.getSessionId();
            if (StringUtils.isEmpty(sessionId)) {
                return;
            }
            ChromePage pg = sessionMap.get(sessionId);
            if (pg == null) {
                return;
            }
            handler.accept(pg, object);
        });
    }

    private <T> void addSessionListener(ChromeBrowserEvent from, SessionHandler<T> handler, Class<T> clazz) {
        addSessionListener(from, (pg, event) -> {
            T obj = event.getObject(clazz);
            handler.accept(pg, obj);
        });
    }

    private void transmitPageListener(ChromeBrowserEvent from, ChromePageEvent to) {
        addSessionListener(from, (pg, event) -> pg.emit(to, event), to.getClazz());
    }

    private void transmitFrameListener(ChromeBrowserEvent from, ChromeFrameEvent to) {
        addSessionListener(from, (pg, event) -> pg.emit(to, event), to.getClazz());
    }

    @Override
    public void addListener(ChromeBrowserEvent type, Consumer<?> consumer) {
        browser.addListener(type, consumer);
    }

    @Override
    public void removeListener(ChromeBrowserEvent type, Consumer<?> consumer) {
        browser.removeListener(type, consumer);
    }

    @Override
    public void emit(ChromeBrowserEvent type, Object event) {
        browser.emit(type, event);
    }

    @Override
    public ChromeBrowser browser() {
        return browser;
    }

    @Override
    public void resetPermissions() throws Exception {
        ResetPermissionsRequest request = new ResetPermissionsRequest();
        request.setBrowserContextId(browserContextId);
        domainBrowser.resetPermissions(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void grantPermissions(String origin, PermissionType... permissions) throws Exception {
        GrantPermissionsRequest request = new GrantPermissionsRequest();
        request.setBrowserContextId(browserContextId);
        request.setOrigin(origin);
        request.setPermissions(Arrays.stream(permissions).map(permission -> permission.getValue()).collect(Collectors.toList()));
        domainBrowser.grantPermissions(request, DEFAULT_TIMEOUT);
    }

    @Override
    public boolean isIncognito() {
        //暂不支持创建上下文, 故此处直接返回false
        return false;
    }

    @Override
    public ChromePage newPage() throws Exception {
        Promise<ChromePage> promise = new DefaultPromise<>();
        String targetId = browser.createTarget(browserContextId);
        promiseMap.put(targetId, promise);
        try {
            return promise.get(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            CloseTargetRequest request = new CloseTargetRequest();
            request.setTargetId(targetId);
            target.closeTarget(request, DEFAULT_TIMEOUT);
            throw e;
        } finally {
            promiseMap.remove(targetId);
        }
    }

    @Override
    public ChromePage[] pages() throws Exception {
        ChromePage[] pages = new ChromePage[pageMap.size()];
        return pageMap.values().toArray(pages);
    }
}
