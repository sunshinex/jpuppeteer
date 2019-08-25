package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import jpuppeteer.api.browser.Cookie;
import jpuppeteer.api.browser.Page;
import jpuppeteer.api.browser.Viewport;
import jpuppeteer.api.browser.*;
import jpuppeteer.api.constant.MediaType;
import jpuppeteer.api.constant.MouseDefinition;
import jpuppeteer.api.constant.ResourceType;
import jpuppeteer.api.constant.USKeyboardDefinition;
import jpuppeteer.api.util.ConcurrentHashSet;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.constant.emulation.ScreenOrientationType;
import jpuppeteer.cdp.cdp.constant.input.DispatchKeyEventRequestType;
import jpuppeteer.cdp.cdp.constant.input.DispatchMouseEventRequestPointerType;
import jpuppeteer.cdp.cdp.constant.input.DispatchMouseEventRequestType;
import jpuppeteer.cdp.cdp.constant.input.DispatchTouchEventRequestType;
import jpuppeteer.cdp.cdp.constant.network.BlockedReason;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.domain.*;
import jpuppeteer.cdp.cdp.entity.emulation.SetDeviceMetricsOverrideRequest;
import jpuppeteer.cdp.cdp.entity.emulation.SetGeolocationOverrideRequest;
import jpuppeteer.cdp.cdp.entity.emulation.SetUserAgentOverrideRequest;
import jpuppeteer.cdp.cdp.entity.emulation.*;
import jpuppeteer.cdp.cdp.entity.input.DispatchKeyEventRequest;
import jpuppeteer.cdp.cdp.entity.input.DispatchMouseEventRequest;
import jpuppeteer.cdp.cdp.entity.input.DispatchTouchEventRequest;
import jpuppeteer.cdp.cdp.entity.input.TouchPoint;
import jpuppeteer.cdp.cdp.entity.log.EntryAddedEvent;
import jpuppeteer.cdp.cdp.entity.network.GetCookiesResponse;
import jpuppeteer.cdp.cdp.entity.network.*;
import jpuppeteer.cdp.cdp.entity.page.*;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextCreatedEvent;
import jpuppeteer.cdp.cdp.entity.runtime.ReleaseObjectRequest;
import jpuppeteer.cdp.cdp.entity.runtime.RemoteObject;
import jpuppeteer.cdp.cdp.entity.target.TargetCrashedEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetDestroyedEvent;
import jpuppeteer.chrome.entity.CookieEvent;
import jpuppeteer.chrome.util.CookieUtils;
import jpuppeteer.chrome.util.TransUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static jpuppeteer.cdp.cdp.CDPEventType.*;
import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;
import static jpuppeteer.chrome.event.PageEvent.*;

public class ChromePage extends ChromeFrame implements Page<CallArgument> {

    private static final Logger logger = LoggerFactory.getLogger(ChromePage.class);

    private static final List<TouchPoint> EMPTY_TOUCHPOINTS = Lists.newArrayListWithCapacity(0);

    protected CDPSession session;

    private ChromeContext browserContext;

    protected Performance performance;

    protected Log log;

    protected Emulation emulation;

    protected Network network;

    private volatile Map<String/*requestId*/, ChromeRequest> requestMap;

    private String userAgent;

    private Viewport viewport;

    private volatile boolean close;

    private volatile Set<USKeyboardDefinition> pressedKeys;

    private volatile int keyModifiers;

    private volatile double mouseX;

    private volatile double mouseY;

    public ChromePage(ChromeContext browserContext, CDPSession session, String targetId) throws Exception {
        super(
                null,
                targetId,
                new jpuppeteer.cdp.cdp.domain.Page(session),
                new Runtime(session),
                new DOM(session),
                new Input(session)
        );
        this.session = session;
        this.browserContext = browserContext;
        this.performance = new Performance(session);
        this.log = new Log(session);
        this.emulation = new Emulation(session);
        this.network = new Network(session);

        this.requestMap = new ConcurrentHashMap<>();
        this.userAgent = null;
        this.viewport = null;
        this.close = false;

        this.pressedKeys = new ConcurrentHashSet<>();
        this.keyModifiers = 0;
        this.mouseX = 0;
        this.mouseY = 0;

        enablePage();
        enablePageLifecycleEvent();
        enableNetwork();
        enablePerformance();
        enableLog();
        enableRuntime();
        enableDom();

        //绑定事件
        session.addListener(TARGET_TARGETCRASHED, new CrashedHandler());
        session.addListener(TARGET_TARGETDESTROYED, new DestroyedHandler());
        session.addListener(PAGE_LIFECYCLEEVENT, new LifecycleHandler());
        session.addListener(PAGE_DOMCONTENTEVENTFIRED, ev -> emit(DOMCONTENTLOADED, ev.getParams().toJavaObject(DOMCONTENTLOADED.eventClass())));
        session.addListener(PAGE_LOADEVENTFIRED, ev -> emit(LOAD, ev.getParams().toJavaObject(LOAD.eventClass())));
        session.addListener(LOG_ENTRYADDED, new ConsoleHandler());
        session.addListener(PAGE_JAVASCRIPTDIALOGOPENING, ev -> emit(DIALOG, ev.getParams().toJavaObject(DIALOG.eventClass())));
        session.addListener(PAGE_WINDOWOPEN, ev -> emit(POPUP, ev.getParams().toJavaObject(POPUP.eventClass())));
        session.addListener(RUNTIME_EXCEPTIONTHROWN, ev -> emit(PAGEERROR, ev.getParams().toJavaObject(PAGEERROR.eventClass())));
        session.addListener(NETWORK_REQUESTWILLBESENT, new RequestHandler());
        session.addListener(NETWORK_RESPONSERECEIVED, new ResponseHandler());
        session.addListener(NETWORK_LOADINGFAILED, new LoadingFailedHandler());
        session.addListener(NETWORK_LOADINGFINISHED, new LoadingFinishedHandler());
        //这三个事件用于维护frame tree
        session.addListener(PAGE_FRAMEATTACHED, new AttachedHandler());
        session.addListener(PAGE_FRAMEDETACHED, new DetahcedHandler());
        session.addListener(PAGE_FRAMENAVIGATED, new NavigatedHandler());
        //这三个事件用于维护execution context
        session.addListener(RUNTIME_EXECUTIONCONTEXTCREATED, new ExecutionCreatedHandler());
        session.addListener(RUNTIME_EXECUTIONCONTEXTDESTROYED, new ExecutionDestroyedHandler());
        session.addListener(RUNTIME_EXECUTIONCONTEXTSCLEARED, new ExecutionClearedHandler());
    }

    @Override
    public void setCookie(Cookie... cookies) throws Exception {
        SetCookiesRequest request = new SetCookiesRequest();
        List<CookieParam> cookieParams = Lists.newArrayListWithCapacity(cookies.length);
        for(Cookie cookie : cookies) {
            CookieParam cookieParam = new CookieParam();
            cookieParam.setName(cookie.getName());
            cookieParam.setValue(cookie.getValue());
            cookieParam.setDomain(cookie.getDomain());
            cookieParam.setPath(cookie.getPath());
            cookieParam.setExpires(cookie.getExpires().doubleValue());
            cookieParam.setSecure(cookie.isSecure());
            cookieParam.setHttpOnly(cookie.isHttpOnly());
            cookieParam.setSameSite(cookie.getSameSite());
            cookieParam.setUrl(cookie.getUrl());
            cookieParams.add(cookieParam);
        }
        request.setCookies(cookieParams);
        network.setCookies(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void clearCookie() throws Exception {
        for(Cookie cookie : cookies()) {
            DeleteCookiesRequest request = new DeleteCookiesRequest();
            request.setName(cookie.getName());
            request.setDomain(cookie.getDomain());
            request.setPath(cookie.getPath());
            request.setUrl(cookie.getUrl());
            network.deleteCookies(request, DEFAULT_TIMEOUT);
        }
    }

    @Override
    public List<Cookie> cookies() throws Exception {
        GetCookiesRequest request = new GetCookiesRequest();
        request.setUrls(Lists.newArrayList(url.toString()));
        GetCookiesResponse response = network.getCookies(request, DEFAULT_TIMEOUT);
        return response.getCookies().stream().map(cookie -> TransUtils.cookie(cookie)).collect(Collectors.toList());
    }


    protected void enablePage() throws Exception {
        page.enable(DEFAULT_TIMEOUT);
    }

    protected void enablePageLifecycleEvent() throws Exception {
        SetLifecycleEventsEnabledRequest request = new SetLifecycleEventsEnabledRequest();
        request.setEnabled(true);
        page.setLifecycleEventsEnabled(request, DEFAULT_TIMEOUT);
    }

    protected void enableNetwork() throws Exception {
        network.enable(null, DEFAULT_TIMEOUT);
    }

    protected void enablePerformance() throws Exception {
        performance.enable(DEFAULT_TIMEOUT);
    }

    protected void enableLog() throws Exception {
        log.enable(DEFAULT_TIMEOUT);
    }

    protected void enableRuntime() throws Exception {
        runtime.enable(DEFAULT_TIMEOUT);
    }

    protected void enableDom() throws Exception {
        dom.enable(DEFAULT_TIMEOUT);
    }

    private static int getModifier(USKeyboardDefinition key) {

        switch (key) {
            case ALTLEFT:
            case ALTRIGHT:
            case ALT:
                return 1;

            case CONTROLLEFT:
            case CONTROLRIGHT:
            case CONTROL:
                return 2;

            case METALEFT:
            case METARIGHT:
            case META:
                return 4;

            case SHIFTLEFT:
            case SHIFTRIGHT:
            case SHIFT:
                return 8;
        }

        return 0;
    }

    private DispatchKeyEventRequest buildKeyEvent(USKeyboardDefinition key) {
        boolean shift = (keyModifiers & 8) == 8;
        DispatchKeyEventRequest request = new DispatchKeyEventRequest();
        request.setModifiers(keyModifiers);
        request.setWindowsVirtualKeyCode(shift && key.getShiftKeyCode() != null ? key.getShiftKeyCode() : key.getKeyCode());
        request.setCode(key.getCode());
        request.setKey(shift && key.getShiftKey() != null ? key.getShiftKey() : key.getKey());
        request.setLocation(key.getLocation() != null ? key.getLocation() : 0);
        request.setIsKeypad(key.getLocation() != null && key.getLocation() == 3);
        return request;
    }

    @Override
    public void keyDown(USKeyboardDefinition key) throws Exception {
        DispatchKeyEventRequest request = buildKeyEvent(key);
        request.setAutoRepeat(pressedKeys.contains(key));
        pressedKeys.add(key);
        keyModifiers |= getModifier(key);
        request.setType(DispatchKeyEventRequestType.RAWKEYDOWN.getValue());
        if (request.getKey().length() == 1) {
            request.setText(request.getKey());
            request.setUnmodifiedText(request.getKey());
        }
        if ((keyModifiers & ~8) != 0) {
            request.setText(null);
            request.setUnmodifiedText(null);
        }
        if (request.getText() != null && request.getUnmodifiedText() != null) {
            request.setType(DispatchKeyEventRequestType.KEYDOWN.getValue());
        }
        input.dispatchKeyEvent(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void keyUp(USKeyboardDefinition key) throws Exception {
        DispatchKeyEventRequest request = buildKeyEvent(key);
        pressedKeys.remove(key);
        keyModifiers &= ~getModifier(key);
        request.setType(DispatchKeyEventRequestType.KEYUP.getValue());
        input.dispatchKeyEvent(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void press(USKeyboardDefinition key, int delay) throws Exception {
        keyDown(key);
        if (delay > 0) {
            TimeUnit.MILLISECONDS.sleep(delay);
        }
        keyUp(key);
    }

    private DispatchMouseEventRequest buildMouseEvent(MouseDefinition mouseDefinition) {
        DispatchMouseEventRequest request = new DispatchMouseEventRequest();
        request.setButton(mouseDefinition.getName());
        request.setButtons(mouseDefinition.getCode());
        request.setModifiers(keyModifiers);
        request.setPointerType(DispatchMouseEventRequestPointerType.MOUSE.getValue());
        request.setX(this.mouseX);
        request.setY(this.mouseY);
        return request;
    }

    private void doMouseDown(MouseDefinition mouseDefinition, int count) throws Exception {
        DispatchMouseEventRequest request = buildMouseEvent(mouseDefinition);
        request.setType(DispatchMouseEventRequestType.MOUSEPRESSED.getValue());
        request.setClickCount(count);
        input.dispatchMouseEvent(request, DEFAULT_TIMEOUT);
    }

    private void doMouseUp(MouseDefinition mouseDefinition, int count) throws Exception {
        DispatchMouseEventRequest request = buildMouseEvent(mouseDefinition);
        request.setType(DispatchMouseEventRequestType.MOUSERELEASED.getValue());
        request.setClickCount(count);
        input.dispatchMouseEvent(request, DEFAULT_TIMEOUT);
    }

    private void doMouseMove(double x, double y) throws Exception {
        DispatchMouseEventRequest request = buildMouseEvent(MouseDefinition.NONE);
        request.setType(DispatchMouseEventRequestType.MOUSEMOVED.getValue());
        request.setX(x);
        request.setY(y);
        input.dispatchMouseEvent(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void mouseDown(MouseDefinition mouseDefinition) throws Exception {
        doMouseDown(mouseDefinition, 1);
    }

    @Override
    public void mouseUp(MouseDefinition mouseDefinition) throws Exception {
        doMouseUp(mouseDefinition, 1);
    }

    @Override
    public void mouseMove(double x, double y, int steps) throws Exception {
        double stepX = (x - mouseX) / steps;
        double stepY = (y - mouseY) / steps;
        for(int i = 1; i<=steps; i++) {
            double toX = mouseX + stepX * i;
            double toY = mouseY + stepY * i;
            doMouseMove(toX, mouseY + stepY * i);
            logger.debug("mouse move from {},{} to {},{}", mouseX, mouseY, toX, toY);
            this.mouseX = toX;
            this.mouseY = toY;
        }
    }

    private DispatchTouchEventRequest buildTouchEvent(double x, double y) {
        DispatchTouchEventRequest request = new DispatchTouchEventRequest();
        TouchPoint touchPoint = new TouchPoint();
        touchPoint.setX(x);
        touchPoint.setY(y);
        request.setModifiers(keyModifiers);
        request.setTouchPoints(Lists.newArrayList(touchPoint));
        return request;
    }

    @Override
    public void touchStart(double x, double y) throws Exception {
        DispatchTouchEventRequest request = buildTouchEvent(x, y);
        request.setType(DispatchTouchEventRequestType.TOUCHSTART.getValue());
        input.dispatchTouchEvent(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void touchEnd() throws Exception {
        DispatchTouchEventRequest request = new DispatchTouchEventRequest();
        request.setType(DispatchTouchEventRequestType.TOUCHEND.getValue());
        request.setModifiers(keyModifiers);
        request.setTouchPoints(EMPTY_TOUCHPOINTS);
        input.dispatchTouchEvent(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void touchMove(double x, double y) throws Exception {
        DispatchTouchEventRequest request = buildTouchEvent(x, y);
        request.setType(DispatchTouchEventRequestType.TOUCHMOVE.getValue());
        input.dispatchTouchEvent(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void touchCancel() throws Exception {
        DispatchTouchEventRequest request = new DispatchTouchEventRequest();
        request.setType(DispatchTouchEventRequestType.TOUCHCANCEL.getValue());
        request.setModifiers(keyModifiers);
        request.setTouchPoints(EMPTY_TOUCHPOINTS);
        input.dispatchTouchEvent(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void bringToFront() throws Exception {
        page.bringToFront(DEFAULT_TIMEOUT);
    }

    @Override
    public ChromeContext browserContext() {
        return browserContext;
    }

    @Override
    public void close() {
        try {
            ChromeBrowser browser = browserContext.browser();
            browser.closeTarget(frameId);
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
        } finally {
            close = true;
        }
    }

    @Override
    public void emulate(Emulator emulator) throws Exception {
        SetDeviceMetricsOverrideRequest request = new SetDeviceMetricsOverrideRequest();
        request.setWidth(emulator.getViewport().getWidth());
        request.setHeight(emulator.getViewport().getHeight());
        request.setDeviceScaleFactor(Double.valueOf(emulator.getViewport().getDeviceScaleFactor()));
        if (emulator.getViewport().isLandscape()) {
            ScreenOrientation screenOrientation = new ScreenOrientation();
            screenOrientation.setType(ScreenOrientationType.LANDSCAPEPRIMARY.getValue());
            screenOrientation.setAngle(0);
            request.setScreenOrientation(screenOrientation);
        }
        emulation.setDeviceMetricsOverride(request, DEFAULT_TIMEOUT);
        SetUserAgentOverrideRequest userAgentRequest = new SetUserAgentOverrideRequest();
        userAgentRequest.setUserAgent(emulator.getUserAgent().getUserAgent());
        userAgentRequest.setAcceptLanguage(emulator.getUserAgent().getAcceptLanguage());
        userAgentRequest.setPlatform(emulator.getUserAgent().getPlatform());
        emulation.setUserAgentOverride(userAgentRequest, DEFAULT_TIMEOUT);
        this.viewport = emulator.getViewport();
        this.userAgent = emulator.getUserAgent() != null ? emulator.getUserAgent().getUserAgent() : null;
    }

    @Override
    public void emulateMedia(MediaType mediaType) throws Exception {
        SetEmulatedMediaRequest request = new SetEmulatedMediaRequest();
        request.setMedia(mediaType.getValue());
        emulation.setEmulatedMedia(request, DEFAULT_TIMEOUT);
    }

    @Override
    public String evaluateOnNewDocument(String script) throws Exception {
        AddScriptToEvaluateOnNewDocumentRequest request = new AddScriptToEvaluateOnNewDocumentRequest();
        request.setSource(script);
        AddScriptToEvaluateOnNewDocumentResponse response = page.addScriptToEvaluateOnNewDocument(request, DEFAULT_TIMEOUT);
        return response.getIdentifier();
    }

    @Override
    public boolean isClosed() {
        return close;
    }

    @Override
    public void setByPassCSP(boolean enable) throws Exception {
        SetBypassCSPRequest request = new SetBypassCSPRequest();
        request.setEnabled(enable);
        page.setBypassCSP(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void setCacheEnable(boolean enable) throws Exception {
        SetCacheDisabledRequest request = new SetCacheDisabledRequest();
        request.setCacheDisabled(!enable);
        network.setCacheDisabled(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void setExtraHTTPHeaders(Header... headers) throws Exception {
        SetExtraHTTPHeadersRequest request = new SetExtraHTTPHeadersRequest();
        Map<String, Object> headerMap = new HashMap<>();
        for(Header header : headers) {
            headerMap.put(header.getName(), header.getValues());
        }
        request.setHeaders(headerMap);
        network.setExtraHTTPHeaders(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void setGeolocation(double latitude, double longitude, int accuracy) throws Exception {
        SetGeolocationOverrideRequest request = new SetGeolocationOverrideRequest();
        request.setLatitude(latitude);
        request.setLongitude(longitude);
        request.setAccuracy(Integer.valueOf(accuracy).doubleValue());
        emulation.setGeolocationOverride(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void setUserAgent(String userAgent) throws Exception {
        emulate(Emulator.newBuilder().userAgent(userAgent).build());
    }

    @Override
    public void setViewport(Viewport viewport) throws Exception {
        emulate(Emulator.newBuilder()
                .width(viewport.getWidth())
                .height(viewport.getHeight())
                .deviceScaleFactor(viewport.getDeviceScaleFactor())
                .hasTouch(viewport.isHasTouch())
                .isMobile(viewport.isMobile())
                .isLandscape(viewport.isLandscape())
                .build());
    }

    @Override
    public String userAgent() {
        return userAgent;
    }

    @Override
    public Viewport viewport() {
        return viewport;
    }

    private void go(int steps) throws Exception {
        GetNavigationHistoryResponse history = page.getNavigationHistory(DEFAULT_TIMEOUT);
        int index = history.getCurrentIndex() + steps;
        if (index < 0 || index >= history.getEntries().size()) {
            throw new Exception("不合法的history entry");
        }
        NavigateToHistoryEntryRequest request = new NavigateToHistoryEntryRequest();
        request.setEntryId(history.getEntries().get(index).getId());
        page.navigateToHistoryEntry(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void goBack() throws Exception {
        go(-1);
    }

    @Override
    public void goForward() throws Exception {
        go(1);
    }

    @Override
    public void reload() throws Exception {
        page.reload(null, DEFAULT_TIMEOUT);
    }

    private static List<Header> parseHeader(Map<String, Object> headerMap) {
        List<Header> headers = Lists.newArrayListWithCapacity(0);
        if (MapUtils.isNotEmpty(headerMap)) {
            for (Map.Entry<String, Object> entry : headerMap.entrySet()) {
                String[] items = entry.getValue().toString().split("\n");
                Header header = null;
                for (String item : items) {
                    if (header == null) {
                        header = new Header(entry.getKey(), item);
                    } else {
                        header.add(item);
                    }
                }
                if (header == null) {
                    continue;
                }
                headers.add(header);
            }
        }
        return headers;
    }

    private class DestroyedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            TargetDestroyedEvent evt = event.getParams().toJavaObject(TargetDestroyedEvent.class);
            if (!frameId.equals(evt.getTargetId())) {
                return;
            }
            emit(CLOSE, evt);
        }
    }

    private class CrashedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            TargetCrashedEvent evt = event.getParams().toJavaObject(TargetCrashedEvent.class);
            if (!frameId.equals(evt.getTargetId())) {
                return;
            }
            emit(ERROR, evt);
        }
    }

    private class LifecycleHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            LifecycleEvent evt = event.getParams().toJavaObject(LifecycleEvent.class);
            ChromeFrame frame = find(evt.getFrameId());
            if (frame == null) {
                return;
            }
            frame.emit(LIFECYCLEEVENT, evt);
            //emit(LIFECYCLEEVENT, evt);
        }
    }

    private class RequestHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            RequestWillBeSentEvent evt = event.getParams().toJavaObject(RequestWillBeSentEvent.class);
            jpuppeteer.cdp.cdp.entity.network.Request req = evt.getRequest();
            ChromeFrame frame = find(evt.getFrameId());
            if (frame == null) {
                //对于找不到frame的请求事件, 丢弃...
                return;
            }
            String urlStr = req.getUrl();
            String fragment = req.getUrlFragment();
            URL url = null;
            try {
                url = new URL(urlStr + (fragment != null ? fragment : ""));
            } catch (MalformedURLException e) {
                //do nth... 解析不了的url, 跳过就算了
            }
            String requestId = evt.getRequestId();
            //处理redirect
            ChromeRequest prev = requestMap.get(requestId);
            ChromeRequest request = ChromeRequest.builder()
                    .session(session)
                    .network(network)
                    .frame(frame)
                    .loaderId(evt.getLoaderId())
                    .requestId(evt.getRequestId())
                    .method(req.getMethod())
                    .url(url)
                    .resourceType(ResourceType.findByValue(evt.getType()))
                    .headers(parseHeader(req.getHeaders()))
                    .hasPostData(Boolean.TRUE.equals(req.getHasPostData()))
                    .prev(prev)
                    //postData的内容需要的时候调用接口拿回来, 省内存
                    //.postData(req.getPostData())
                    .build();
            //每个请求的request都记录下来, 后续会用到
            if (requestMap.putIfAbsent(requestId, request) != null) {
                //此处用乐观锁
                while(!requestMap.replace(requestId, prev, request)) {
                    prev = requestMap.get(requestId);
                    request.setPrev(prev);
                }
            }
            //frame.emit(REQUEST, request);
            emit(REQUEST, request);
        }
    }

    private class ResponseHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            ResponseReceivedEvent evt = event.getParams().toJavaObject(ResponseReceivedEvent.class);
            jpuppeteer.cdp.cdp.entity.network.Response res = evt.getResponse();
            ChromeRequest request = requestMap.get(evt.getRequestId());
            if (request == null) {
                return;
            }
            ChromeFrame frame = find(evt.getFrameId());
            if (frame == null) {
                return;
            }

            URL url = null;
            try {
                url = new URL(res.getUrl());
            } catch (MalformedURLException e) {
                //do nth... 解析不了的url, 跳过就算了
            }

            //处理securityDetails
            ChromeSecurityDetails securityDetails = null;
            if (res.getSecurityDetails() != null) {
                securityDetails = ChromeSecurityDetails.builder()
                        .issuer(res.getSecurityDetails().getIssuer())
                        .protocol(res.getSecurityDetails().getProtocol())
                        .subjectName(res.getSecurityDetails().getSubjectName())
                        .vaildFrom(new Date(res.getSecurityDetails().getValidFrom().longValue() * 1000))
                        .vaildTo(new Date(res.getSecurityDetails().getValidTo().longValue() * 1000))
                        .build();
            }

            List<Header> headers = parseHeader(res.getHeaders());

            ChromeResponse response = ChromeResponse.builder()
                    .session(session)
                    .network(network)
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

            Optional<Header> header = headers.stream().filter(h -> StringUtils.equalsIgnoreCase(CookieUtils.SET_COOKIE, h.getName())).findFirst();
            if (header.isPresent()) {
                try {
                    emit(COOKIE, new CookieEvent(response, CookieUtils.parse(header.get(), url)));
                } catch (Throwable t) {
                    logger.warn("emit cookie event failed, error={}", t.getMessage(), t);
                }
            }

            request.setResponse(response);
            //frame.emit(RESPONSE, response);
            emit(RESPONSE, response);
        }
    }

    private class LoadingFailedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            LoadingFailedEvent evt = event.getParams().toJavaObject(LoadingFailedEvent.class);
            ChromeRequest request = requestMap.get(evt.getRequestId());
            if (request == null) {
                return;
            }
            ChromeFrame frame = find(request.getFrame().frameId);
            if (frame == null) {
                return;
            }
            ChromeRequestFailed requestFailed = new ChromeRequestFailed();
            requestFailed.setRequest(request);
            requestFailed.setCanceled(evt.getCanceled());
            requestFailed.setBlockedReason(BlockedReason.findByValue(evt.getBlockedReason()));
            requestFailed.setErrorText(evt.getErrorText());
            try {
                //frame.emit(REQUESTFAILED, requestFailed);
                emit(REQUESTFAILED, requestFailed);
            } finally {
                requestMap.remove(evt.getRequestId());
            }
        }
    }

    private class LoadingFinishedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            LoadingFinishedEvent evt = event.getParams().toJavaObject(LoadingFinishedEvent.class);
            ChromeRequest request = requestMap.get(evt.getRequestId());
            if (request == null) {
                return;
            }
            ChromeFrame frame = find(request.getFrame().frameId);
            if (frame == null) {
                return;
            }
            //frame.emit(REQUESTFINISHED, request);
            emit(REQUESTFINISHED, request);
        }
    }

    private class AttachedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            FrameAttachedEvent evt = event.getParams().toJavaObject(FrameAttachedEvent.class);
            ChromeFrame parent = find(evt.getParentFrameId());
            if (parent == null) {
                return;
            }
            logger.info("frame attached success, parentId={}, frameId={}", parent.frameId, evt.getFrameId());
            parent.append(evt.getFrameId());
            parent.emit(FRAMEATTACHED, evt);
            //emit(FRAMEATTACHED, evt);
        }
    }

    private class DetahcedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            FrameDetachedEvent evt = event.getParams().toJavaObject(FrameDetachedEvent.class);
            ChromeFrame frame = find(evt.getFrameId());
            if (frame == null) {
                return;
            }
            frame.remove();
            frame.parent.emit(FRAMEDETACHED, evt);
            //emit(FRAMEDETACHED, evt);
        }
    }

    private class NavigatedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            FrameNavigatedEvent evt = event.getParams().toJavaObject(FrameNavigatedEvent.class);
            URL url = null;
            URL unreachableUrl = null;
            try {
                url = new URL(evt.getFrame().getUrl());
            } catch (MalformedURLException e) {
                //do nth...
            }
            if (StringUtils.isNotEmpty(evt.getFrame().getUnreachableUrl())) {
                try {
                    unreachableUrl = new URL(evt.getFrame().getUnreachableUrl());
                } catch (MalformedURLException e) {
                    //do nth...
                }
            }
            ChromeFrame frame = find(evt.getFrame().getId());
            if (frame == null) {
                return;
            }
            frame.setUrl(url);
            frame.setName(evt.getFrame().getName());
            frame.setMimeType(evt.getFrame().getMimeType());
            frame.setUnreachableUrl(unreachableUrl);
            frame.setSecurityOrigin(evt.getFrame().getSecurityOrigin());
            if (!(frame instanceof ChromePage)) {
                frame.parent.emit(FRAMENAVIGATED, evt);
            }
            //emit(FRAMENAVIGATED, evt);
        }
    }

    private class ExecutionCreatedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            ExecutionContextCreatedEvent evt = event.getParams().toJavaObject(ExecutionContextCreatedEvent.class);
            if (evt ==  null || evt.getContext() == null || MapUtils.isEmpty(evt.getContext().getAuxData())) {
                return;
            }
            Object frameIdObj = evt.getContext().getAuxData().get("frameId");
            if (frameIdObj == null) {
                return;
            }
            String frameId = (String) frameIdObj;
            ChromeFrame frame = find(frameId);
            if (frame == null) {
                return;
            }
            Integer executionContextId = evt.getContext().getId();
            frame.setExecutionContextId(executionContextId);
            logger.info("frame {} init execution with id:{}", frameId, executionContextId);
        }
    }

    private class ExecutionDestroyedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            //do nth...
            //等frame的destory事件处理
        }
    }

    private class ExecutionClearedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            //do nth...
        }
    }

    private class ConsoleHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            EntryAddedEvent evt = event.getParams().toJavaObject(EntryAddedEvent.class);
            List<RemoteObject> args = evt.getEntry().getArgs();
            emit(CONSOLE, evt);
            if (CollectionUtils.isEmpty(args)) {
                return;
            }
            args.forEach(object -> {
                if (object != null ) releaseObjectQuietly(object.getObjectId());
            });
        }
    }

    private void releaseObjectQuietly(String objectId) {
        ReleaseObjectRequest request = new ReleaseObjectRequest();
        request.setObjectId(objectId);
        try {
            runtime.releaseObject(request, DEFAULT_TIMEOUT);
        } catch (Exception e) {
            logger.warn("release object failed, objectId={}", objectId, e);
        }
    }
}
