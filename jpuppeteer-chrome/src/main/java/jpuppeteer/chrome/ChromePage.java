package jpuppeteer.chrome;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import jpuppeteer.api.browser.Cookie;
import jpuppeteer.api.browser.Page;
import jpuppeteer.api.browser.*;
import jpuppeteer.api.constant.MediaType;
import jpuppeteer.api.constant.MouseDefinition;
import jpuppeteer.api.constant.ResourceType;
import jpuppeteer.api.constant.USKeyboardDefinition;
import jpuppeteer.api.event.DefaultEventEmitter;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.util.ConcurrentHashSet;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.constant.emulation.ScreenOrientationType;
import jpuppeteer.cdp.cdp.constant.fetch.AuthChallengeResponseResponse;
import jpuppeteer.cdp.cdp.constant.input.DispatchKeyEventRequestType;
import jpuppeteer.cdp.cdp.constant.input.DispatchMouseEventRequestPointerType;
import jpuppeteer.cdp.cdp.constant.input.DispatchMouseEventRequestType;
import jpuppeteer.cdp.cdp.constant.input.DispatchTouchEventRequestType;
import jpuppeteer.cdp.cdp.constant.page.SetTouchEmulationEnabledRequestConfiguration;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.domain.*;
import jpuppeteer.cdp.cdp.entity.emulation.SetDeviceMetricsOverrideRequest;
import jpuppeteer.cdp.cdp.entity.emulation.SetGeolocationOverrideRequest;
import jpuppeteer.cdp.cdp.entity.emulation.SetUserAgentOverrideRequest;
import jpuppeteer.cdp.cdp.entity.emulation.*;
import jpuppeteer.cdp.cdp.entity.fetch.AuthChallengeResponse;
import jpuppeteer.cdp.cdp.entity.fetch.EnableRequest;
import jpuppeteer.cdp.cdp.entity.fetch.RequestPattern;
import jpuppeteer.cdp.cdp.entity.fetch.*;
import jpuppeteer.cdp.cdp.entity.input.DispatchKeyEventRequest;
import jpuppeteer.cdp.cdp.entity.input.DispatchMouseEventRequest;
import jpuppeteer.cdp.cdp.entity.input.DispatchTouchEventRequest;
import jpuppeteer.cdp.cdp.entity.input.TouchPoint;
import jpuppeteer.cdp.cdp.entity.network.GetCookiesResponse;
import jpuppeteer.cdp.cdp.entity.network.*;
import jpuppeteer.cdp.cdp.entity.page.SetTouchEmulationEnabledRequest;
import jpuppeteer.cdp.cdp.entity.page.*;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextCreatedEvent;
import jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextDestroyedEvent;
import jpuppeteer.chrome.constant.ScriptConstants;
import jpuppeteer.chrome.entity.RequestEvent;
import jpuppeteer.chrome.event.Request;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import jpuppeteer.chrome.util.ArgUtils;
import jpuppeteer.chrome.util.CookieUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromePage extends ChromeFrame implements EventEmitter<ChromePageEvent>, Page<CallArgument> {

    private static final Logger logger = LoggerFactory.getLogger(ChromePage.class);

    private static final List<TouchPoint> EMPTY_TOUCHPOINTS = Lists.newArrayListWithCapacity(0);

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    private final EventEmitter<ChromePageEvent> events;

    private final ChromePage opener;

    protected final String sessionId;

    private BrowserContext browserContext;

    protected Performance performance;

    protected Log log;

    protected Emulation emulation;

    protected Network network;

    protected Fetch fetch;

    private volatile Map<String/*requestId*/, Request> requestMap;

    private UserAgent userAgent;

    private Device device;

    private volatile boolean close;

    private volatile Set<USKeyboardDefinition> pressedKeys;

    private volatile int keyModifiers;

    private volatile double mouseX;

    private volatile double mouseY;

    private boolean requestInterceptionEnabled;

    private String username;

    private String password;

    public ChromePage(String browserName, BrowserContext browserContext, CDPSession session, String targetId, ChromePage opener, String sessionId) throws Exception {
        super(
                Executors.newSingleThreadExecutor(r -> new Thread(r, "ChromePage["+browserName+"]:" + COUNTER.getAndIncrement())),
                null,
                targetId,
                session,
                new jpuppeteer.cdp.cdp.domain.Page(session),
                new Runtime(session),
                new DOM(session),
                new Input(session)
        );
        this.events = new DefaultEventEmitter<>(executor);
        this.opener = opener;
        this.sessionId = sessionId;
        this.browserContext = browserContext;
        this.performance = new Performance(session);
        this.log = new Log(session);
        this.emulation = new Emulation(session);
        this.network = new Network(session);
        this.fetch = new Fetch(session);

        this.requestMap = new ConcurrentHashMap<>();
        this.userAgent = null;
        this.device = null;
        this.close = false;

        this.pressedKeys = new ConcurrentHashSet<>();
        this.keyModifiers = 0;
        this.mouseX = 0;
        this.mouseY = 0;
        this.requestInterceptionEnabled = false;

        enablePage();
        enablePageLifecycleEvent();
        enableNetwork();
        enablePerformance();
        enableLog();
        enableRuntime();
        enableDom();
    }

    @Override
    public void addListener(ChromePageEvent type, Consumer<?> consumer) {
        events.addListener(type, consumer);
    }

    @Override
    public void removeListener(ChromePageEvent type, Consumer<?> consumer) {
        events.removeListener(type, consumer);
    }

    @Override
    public void emit(ChromePageEvent type, Object event) {
        events.emit(type, event);
    }



    @Override
    public void authenticate(String username, String password) throws Exception {
        this.username = username;
        this.password = password;
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            enableRequestInterception(true);
        }
    }

    @Override
    public void enableRequestInterception(boolean handleAuthRequest) throws Exception {
        EnableRequest request = new EnableRequest();
        RequestPattern pattern = new RequestPattern();
        pattern.setUrlPattern("*");
        request.setPatterns(Lists.newArrayList(pattern));
        request.setHandleAuthRequests(handleAuthRequest);
        fetch.enable(request, DEFAULT_TIMEOUT);
        //启动拦截器的同时需要禁用缓存
        setCacheEnable(false);
        this.requestInterceptionEnabled = true;
    }

    @Override
    public void disableRequestInterception() throws Exception {
        fetch.disable(DEFAULT_TIMEOUT);
        this.requestInterceptionEnabled = false;
    }

    @Override
    public ChromePage opener() {
        return opener;
    }

    @Override
    public void setCookie(Cookie... cookies) throws Exception {
        SetCookiesRequest request = CookieUtils.create(cookies);
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
        return response.getCookies().stream().map(cookie -> CookieUtils.copyOf(cookie)).collect(Collectors.toList());
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
    public BrowserContext browserContext() {
        return browserContext;
    }

    @Override
    public void close() {
//        try {
//            Browser browser = browserContext.browser();
//            browser.closeTarget(frameId);
//        } catch (Throwable t) {
//            logger.error(t.getMessage(), t);
//        } finally {
//            close = true;
//        }
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
            headerMap.put(header.getName(), header.getValue());
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
    public void setUserAgent(UserAgent userAgent) throws Exception {
        SetUserAgentOverrideRequest request = new SetUserAgentOverrideRequest();
        request.setUserAgent(userAgent.getUserAgent());
        request.setAcceptLanguage(userAgent.getAcceptLanguage());
        request.setPlatform(userAgent.getPlatform());
        emulation.setUserAgentOverride(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void setDevice(Device device) throws Exception {
        SetDeviceMetricsOverrideRequest request = new SetDeviceMetricsOverrideRequest();
        request.setWidth(device.getWidth());
        request.setHeight(device.getHeight());
        request.setDeviceScaleFactor(device.getDeviceScaleFactor());
        request.setMobile(device.isMobile());
        if (device.isLandscape()) {
            ScreenOrientation screen = new ScreenOrientation();
            screen.setType(ScreenOrientationType.LANDSCAPEPRIMARY.getValue());
            screen.setAngle(0);
            request.setScreenOrientation(screen);
        }
        if (device.isHasTouch()) {
            SetTouchEmulationEnabledRequest req = new SetTouchEmulationEnabledRequest();
            req.setEnabled(true);
            req.setConfiguration(SetTouchEmulationEnabledRequestConfiguration.MOBILE.getValue());
            page.setTouchEmulationEnabled(req, DEFAULT_TIMEOUT);
        }
        emulation.setDeviceMetricsOverride(request, DEFAULT_TIMEOUT);
    }

    @Override
    public UserAgent userAgent() {
        return userAgent;
    }

    @Override
    public Device device() {
        return device;
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
    public void reload(boolean force) throws Exception {
        ReloadRequest request = new ReloadRequest();
        request.setIgnoreCache(force);
        page.reload(request, DEFAULT_TIMEOUT);
    }

    public void crash() throws Exception {
        session.asyncSend("Page.crash", null);
    }

    @Override
    public byte[] screenshot() throws Exception {
        CaptureScreenshotRequest request = new CaptureScreenshotRequest();
        request.setFormat("png");
        CaptureScreenshotResponse response = page.captureScreenshot(request, DEFAULT_TIMEOUT);
        return Base64.getDecoder().decode(response.getData());
    }

    @Override
    public Coordinate scroll(int x, int y) throws Exception {
        JSONObject offset = evaluate(ScriptConstants.SCROLL, JSONObject.class, ArgUtils.createFromValue(null), ArgUtils.createFromValue(x), ArgUtils.createFromValue(y));
        return new Coordinate(offset.getDouble("scrollX"), offset.getDouble("scrollY"));
    }

    @Override
    public void clear() {
        children.clear();
        //清空所有的request
        requestMap.clear();
        //清空按键事件
        pressedKeys.clear();
        //重置功能按键
        keyModifiers = 0;
        //重置鼠标位置
        mouseX = 0;
        mouseY = 0;
        logger.info("clear page success, frameId={}", frameId);
    }

    private class NavigatedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            FrameNavigatedEvent evt = event.getParams().toJavaObject(FrameNavigatedEvent.class);
            URL url = null;
            URL unreachableUrl = null;
            try {
                url = new URL(null, evt.getFrame().getUrl());
            } catch (MalformedURLException e) {
                //do nth...
            }
            if (StringUtils.isNotEmpty(evt.getFrame().getUnreachableUrl())) {
                try {
                    unreachableUrl = new URL(null, evt.getFrame().getUnreachableUrl());
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
                //frame.parent.emit(FRAMENAVIGATED, evt);
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
            frame.createExecutionContext(evt.getContext().getId());
            logger.info("frame {} execution created with id:{}", frameId, evt.getContext().getId());
        }
    }

    private class ExecutionDestroyedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            //do nth...
            ExecutionContextDestroyedEvent evt = event.getParams().toJavaObject(ExecutionContextDestroyedEvent.class);
            if (evt == null || evt.getExecutionContextId() == null) {
                return;
            }
            ChromeFrame frame = find(evt.getExecutionContextId());
            if (frame == null) {
                return;
            }
            logger.info("frame {} execution destroyed with id:{}", frame.frameId(), evt.getExecutionContextId());
            frame.destroyExecutionContext();
        }
    }

    private class ExecutionClearedHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            //do nth...
        }
    }

    private class RequestInterceptor implements Consumer<CDPEvent> {

        private void continueRequest(String interceptorId) {
            ContinueRequestRequest request = new ContinueRequestRequest();
            request.setRequestId(interceptorId);
            try {
                fetch.continueRequest(request, DEFAULT_TIMEOUT);
            } catch (Exception e) {
                logger.error("continue request failed, interceptorId={}, error={}", interceptorId, e.getMessage(), e);
            }
        }

        @Override
        public void accept(CDPEvent event) {
            RequestPausedEvent evt = event.getParams().toJavaObject(RequestPausedEvent.class);
            logger.info("request intercepted, requestId={}, interceptorId={}", evt.getNetworkId(), evt.getRequestId());
            String interceptorId = evt.getRequestId();
            String requestId = evt.getNetworkId();
            if (StringUtils.isEmpty(interceptorId)) {
                //不存在interceptorId 直接返回
                return;
            }
            if (StringUtils.isEmpty(requestId)) {
                //没有requestId的不拦截, 直接放行
                continueRequest(interceptorId);
                return;
            }
            RequestEvent requestEvent = RequestEvent.builder()
                    .requestId(requestId)
                    .loaderId(requestId)
                    .interceptorId(interceptorId)
                    .frameId(evt.getFrameId())
                    .request(evt.getRequest())
                    .resourceType(ResourceType.findByValue(evt.getResourceType()))
                    .build();

            //handleRequestEvent(requestEvent);
        }
    }

    private class AuthHandler implements Consumer<CDPEvent> {

        @Override
        public void accept(CDPEvent event) {
            AuthRequiredEvent evt = event.getParams().toJavaObject(AuthRequiredEvent.class);
            AuthChallengeResponse authChallenge = new AuthChallengeResponse();
            authChallenge.setResponse(AuthChallengeResponseResponse.DEFAULT.getValue());
            if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
                authChallenge.setResponse(AuthChallengeResponseResponse.PROVIDECREDENTIALS.getValue());
            } else {
                authChallenge.setResponse(AuthChallengeResponseResponse.CANCELAUTH.getValue());
            }
            authChallenge.setUsername(username);
            authChallenge.setPassword(password);
            ContinueWithAuthRequest request = new ContinueWithAuthRequest();
            request.setAuthChallengeResponse(authChallenge);
            request.setRequestId(evt.getRequestId());
            try {
                fetch.continueWithAuth(request, DEFAULT_TIMEOUT);
            } catch (Exception e) {
                logger.error("auth failed, error={}", e.getMessage(), e);
            }
        }
    }
}
