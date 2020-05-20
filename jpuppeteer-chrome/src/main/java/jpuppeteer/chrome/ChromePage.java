package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.SettableFuture;
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
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.constant.emulation.ScreenOrientationType;
import jpuppeteer.cdp.cdp.constant.fetch.AuthChallengeResponseResponse;
import jpuppeteer.cdp.cdp.constant.input.DispatchKeyEventRequestType;
import jpuppeteer.cdp.cdp.constant.input.DispatchMouseEventRequestPointerType;
import jpuppeteer.cdp.cdp.constant.input.DispatchMouseEventRequestType;
import jpuppeteer.cdp.cdp.constant.input.DispatchTouchEventRequestType;
import jpuppeteer.cdp.cdp.constant.network.BlockedReason;
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
import jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextCreatedEvent;
import jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextDestroyedEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetInfo;
import jpuppeteer.chrome.entity.RequestEvent;
import jpuppeteer.chrome.entity.SecurityDetails;
import jpuppeteer.chrome.event.Request;
import jpuppeteer.chrome.event.RequestFailed;
import jpuppeteer.chrome.event.RequestFinished;
import jpuppeteer.chrome.event.Response;
import jpuppeteer.chrome.event.type.ChromeContextEvent;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import jpuppeteer.chrome.util.CookieUtils;
import jpuppeteer.chrome.util.HttpUtils;
import jpuppeteer.chrome.util.URLUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromePage extends ChromeFrame implements EventEmitter<ChromePageEvent>, Page {

    private static final Logger logger = LoggerFactory.getLogger(ChromePage.class);

    private static final List<TouchPoint> EMPTY_TOUCHPOINTS = Lists.newArrayListWithCapacity(0);

    private final DefaultEventEmitter<ChromePageEvent> events;

    private ChromePage opener;

    private ChromeContext browserContext;

    protected Performance performance;

    protected Log log;

    protected Emulation emulation;

    protected Network network;

    protected Fetch fetch;

    private UserAgent userAgent;

    private Device device;

    private volatile boolean close;

    private Set<USKeyboardDefinition> pressedKeys;

    private volatile int keyModifiers;

    private volatile double mouseX;

    private volatile double mouseY;

    private String username;

    private String password;

    private Map<String/*requestId*/, Request> requestMap;

    private TargetInfo targetInfo;

    private BlockingQueue<Runnable> eventQueue;

    private Pattern requestPattern;

    public ChromePage(String name, ChromeContext browserContext, CDPSession session, TargetInfo targetInfo, ChromePage opener) throws Exception {
        super(
                null,
                targetInfo.getTargetId(),
                session,
                new jpuppeteer.cdp.cdp.domain.Page(session),
                new Runtime(session),
                new DOM(session),
                new Input(session)
        );
        this.targetInfo = targetInfo;
        this.eventQueue = new LinkedBlockingQueue<>();
        this.events = new DefaultEventEmitter<>(
                new ThreadPoolExecutor(
                        1, 1, 0,
                        TimeUnit.SECONDS, eventQueue, r -> new Thread(r, name)
                )
        );
        this.opener = opener;
        this.browserContext = browserContext;
        this.performance = new Performance(session);
        this.log = new Log(session);
        this.emulation = new Emulation(session);
        this.network = new Network(session);
        this.fetch = new Fetch(session);

        this.userAgent = null;
        this.device = null;
        this.close = false;

        this.pressedKeys = new ConcurrentHashSet<>();
        this.keyModifiers = 0;
        this.mouseX = 0;
        this.mouseY = 0;
        this.requestMap = new ConcurrentHashMap<>();

        List<Future> enableFutures = new ArrayList<>();
        enableFutures.add(enablePage());
        enableFutures.add(enablePageLifecycleEvent());
        enableFutures.add(enableNetwork());
        enableFutures.add(enableLog());
        enableFutures.add(enableRuntime());
        enableFutures.add(enableDom());

        for(Future future : enableFutures) {
            future.get();
        }

    }

    protected String sessionId() {
        return session.sessionId();
    }


    protected Future<Void> enablePage() {
        return page.asyncEnable();
    }

    protected Future<Void> enablePageLifecycleEvent() {
        SetLifecycleEventsEnabledRequest request = new SetLifecycleEventsEnabledRequest();
        request.setEnabled(true);
        return page.asyncSetLifecycleEventsEnabled(request);
    }

    protected Future<Void> enableNetwork() {
        return network.asyncEnable(null);
    }

    protected Future<Void> enableLog() {
        return log.asyncEnable();
    }

    protected Future<Void> enableRuntime() {
        return runtime.asyncEnable();
    }

    protected Future<Void> enableDom() {
        return dom.asyncEnable();
    }

    protected void doAuthenticate(String requestId) {
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
        request.setRequestId(requestId);
        try {
            fetch.continueWithAuth(request, DEFAULT_TIMEOUT);
        } catch (Exception e) {
            logger.error("auth failed, error={}", e.getMessage(), e);
        }
    }

    protected void continueRequest(String interceptorId) {
        ContinueRequestRequest request = new ContinueRequestRequest();
        request.setRequestId(interceptorId);
        try {
            fetch.continueRequest(request, DEFAULT_TIMEOUT);
        } catch (Exception e) {
            logger.error("continue request failed, interceptorId={}, error={}", interceptorId, e.getMessage(), e);
        }
    }

    private Request handleRequestEvent(RequestEvent event) {
        jpuppeteer.cdp.cdp.entity.network.Request req = event.getRequest();
        //判断是否为frame导航request
        String requestId = event.getRequestId();
        String loaderId = event.getLoaderId();
        ResourceType resourceType = event.getResourceType();
        if (Objects.equals(requestId, loaderId) && ResourceType.DOCUMENT.equals(resourceType)) {
            //navigation request
            if (Objects.equals(frameId, event.getFrameId())) {
                //如果是top frame则直接clear整个requestMap即可
                requestMap.clear();
            } else {
                //否则清空指定frame的request
                Iterator<Map.Entry<String, Request>> iterator = requestMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Request> entry = iterator.next();
                    if (event.getFrameId().equals(entry.getValue().frame().frameId())) {
                        iterator.remove();
                    }
                }
            }
        }
        ChromeFrame frame = find(event.getFrameId());
        if (frame == null) {
            logger.warn("request event frame not found, requestId={}, frameId={}", event.getRequestId(), event.getFrameId());
            return null;
        }
        String urlStr = req.getUrl();
        String fragment = req.getUrlFragment();
        URL url = URLUtils.parse(urlStr + (fragment != null ? fragment : ""));
        boolean hasPostData = req.getPostData() != null || (req.getHasPostData() != null && req.getHasPostData()) ? true : false;
        Request request = Request.builder()
                .session(session)
                .network(network)
                .fetch(fetch)
                .frame(frame)
                .loaderId(event.getLoaderId())
                .requestId(event.getRequestId())
                .interceptorId(event.getInterceptorId())
                .method(req.getMethod())
                .url(url)
                .resourceType(event.getResourceType())
                .headers(HttpUtils.parseHeader(req.getHeaders()))
                .hasPostData(hasPostData)
                .postData(req.getPostData())
                .build();
        requestMap.put(event.getRequestId(), request);
        return request;
    }

    protected Request handleRequest(RequestWillBeSentEvent event) {
        String url = event.getRequest().getUrl();
        if (requestPattern != null && requestPattern.matcher(url).matches()) {
            //如果存在拦截器表达式，且拦截器匹配当前url，则此请求等待拦截器处理，此处不处理
            logger.info("request matched pattern, ignore Network.requestWillBeSent event! pattern={}, url={}", requestPattern, url);
            return null;
        }
        logger.info("request will be sent, requestId={}", event.getRequestId());
        RequestEvent requestEvent = RequestEvent.builder()
                .frameId(event.getFrameId())
                .loaderId(event.getLoaderId())
                .requestId(event.getRequestId())
                .resourceType(ResourceType.findByValue(event.getType()))
                .request(event.getRequest())
                .build();
        return handleRequestEvent(requestEvent);
    }

    protected Request handleRequestInterception(RequestPausedEvent event) {
        String interceptorId = event.getRequestId();
        String requestId = event.getNetworkId();
        logger.info("request intercepted, requestId={}, interceptorId={}", requestId, interceptorId);
        if (StringUtils.isEmpty(interceptorId)) {
            //不存在interceptorId 直接返回
            return null;
        }
        if (StringUtils.isEmpty(requestId)) {
            //没有requestId的不拦截, 直接放行
            continueRequest(interceptorId);
            return null;
        }

        RequestEvent requestEvent = RequestEvent.builder()
                .requestId(requestId)
                .loaderId(requestId)
                .interceptorId(interceptorId)
                .frameId(event.getFrameId())
                .request(event.getRequest())
                .resourceType(ResourceType.findByValue(event.getResourceType()))
                .build();
        return handleRequestEvent(requestEvent);
    }

    protected Response handleResponse(ResponseReceivedEvent event) {
        ChromeFrame frame = find(event.getFrameId());
        Request request = requestMap.get(event.getRequestId());
        jpuppeteer.cdp.cdp.entity.network.Response res = event.getResponse();
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
                .session(session)
                .network(network)
                .requestId(event.getRequestId())
                .loaderId(event.getLoaderId())
                .type(event.getType())
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

        if (request != null) {
            request.setResponse(response);
        }

        return response;
    }

    protected RequestFailed handleRequestFailed(LoadingFailedEvent event) {
        Request request = requestMap.remove(event.getRequestId());
        return new RequestFailed(event.getRequestId(), request, event.getErrorText(), event.getCanceled(), BlockedReason.findByValue(event.getBlockedReason()));
    }

    protected RequestFinished handleRequestFinished(LoadingFinishedEvent event) {
        Request request = requestMap.remove(event.getRequestId());
        return new RequestFinished(event.getRequestId(), request, event.getEncodedDataLength(), event.getShouldReportCorbBlocking());
    }

    protected void handleExecutionCreated(ExecutionContextCreatedEvent event) {
        if (event ==  null || event.getContext() == null || MapUtils.isEmpty(event.getContext().getAuxData())) {
            return;
        }
        Object frameIdObj = event.getContext().getAuxData().get("frameId");
        if (frameIdObj == null) {
            return;
        }
        String frameId = (String) frameIdObj;
        ChromeFrame frame = find(frameId);
        if (frame == null) {
            return;
        }
        frame.createExecutionContext(event.getContext().getId());
        logger.info("frame {} execution created with id:{}", frameId, event.getContext().getId());
    }

    protected void handleExecutionDestroyed(ExecutionContextDestroyedEvent event) {
        if (event == null || event.getExecutionContextId() == null) {
            return;
        }
        ChromeFrame frame = find(event.getExecutionContextId());
        if (frame == null) {
            return;
        }
        frame.destroyExecutionContext();
        logger.info("frame {} execution destroyed with id:{}", frame.frameId(), event.getExecutionContextId());
    }

    protected void handleExecutionCleared() {
        logger.info("frame {} execution cleared", frameId);
    }

    protected void handleTargetChanged(TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
        this.keyModifiers = 0;
        this.mouseX = 0;
        this.mouseY = 0;
        //在target change的时候清空事件队列, 前面的那些事件都不需要了
        this.eventQueue.clear();
    }

    protected FrameTree getFrameTree() throws Exception {
        GetFrameTreeResponse response = page.getFrameTree(DEFAULT_TIMEOUT);
        return response.getFrameTree();
    }

    protected TargetInfo targetInfo() {
        return targetInfo;
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

    private static String compile(String urlPattern) {
        String p = urlPattern;
        char[] escapeChars = new char[]{'*', '?'};
        StringBuilder sb = new StringBuilder();
        int offset;
        while ((offset = StringUtils.indexOfAny(p, escapeChars)) != -1) {
            String p0 = p.substring(0, offset);
            boolean endWithBackslash = p0.endsWith("\\");
            if (endWithBackslash) {
                p0 = p0.substring(0, p0.length() - 1);
            }
            char eChar = p.charAt(offset);
            p = p.substring(offset + 1);
            if (endWithBackslash) {
                sb.append(Pattern.quote(p0 + eChar));
            } else {
                if (p0.length() > 0) {
                    sb.append(Pattern.quote(p0));
                }
                sb.append(".");
                sb.append(eChar);
            }
        }
        if (p.length() > 0) {
            sb.append(Pattern.quote(p));
        }
        return sb.toString();
    }

    @Override
    public void enableRequestInterception(boolean handleAuthRequest, String... urlPatterns) throws Exception {
        EnableRequest request = new EnableRequest();
        List<String> patterns = new ArrayList<>(urlPatterns.length);
        List<RequestPattern> ptns = new ArrayList<>(urlPatterns.length);
        for(String p : urlPatterns) {
            if (StringUtils.isEmpty(p)) {
                continue;
            }
            RequestPattern ptn = new RequestPattern();
            ptn.setUrlPattern(p);
            ptns.add(ptn);
            patterns.add(compile(p));
        }
        request.setPatterns(ptns);
        request.setHandleAuthRequests(handleAuthRequest);
        fetch.enable(request, DEFAULT_TIMEOUT);
        this.requestPattern = Pattern.compile("("+ StringUtils.join(patterns, "|") +")");
    }

    @Override
    public void disableRequestInterception() throws Exception {
        fetch.disable(DEFAULT_TIMEOUT);
        this.requestPattern = null;
    }

    @Override
    public ChromePage opener() {
        return opener;
    }

    @Override
    public void setCookies(Cookie... cookies) throws Exception {
        SetCookiesRequest request = CookieUtils.create(cookies);
        network.setCookies(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void deleteCookies(String name, String domain, String path, String url) throws Exception {
        DeleteCookiesRequest request = new DeleteCookiesRequest();
        request.setName(name);
        request.setDomain(domain);
        request.setPath(path);
        request.setUrl(url);
        network.deleteCookies(request, DEFAULT_TIMEOUT);
    }

    protected void doClearCookies() throws Exception {
        network.clearBrowserCookies(DEFAULT_TIMEOUT);
    }

    protected List<Cookie> doGetCookies(String... urls) throws Exception {
        List<jpuppeteer.cdp.cdp.entity.network.Cookie> cookies;
        if (urls.length == 0) {
            GetAllCookiesResponse response = network.getAllCookies(DEFAULT_TIMEOUT);
            cookies = response.getCookies();
        } else {
            GetCookiesRequest request = new GetCookiesRequest();
            request.setUrls(Lists.newArrayList(urls));
            GetCookiesResponse response = network.getCookies(request, DEFAULT_TIMEOUT);
            cookies = response.getCookies();
        }
        return cookies.stream()
                .map(cookie -> CookieUtils.copyOf(cookie))
                .collect(Collectors.toList());
    }

    protected Future<Void> asyncDeleteCookies(String name, String domain, String path, String url) {
        DeleteCookiesRequest request = new DeleteCookiesRequest();
        request.setName(name);
        request.setDomain(domain);
        request.setPath(path);
        request.setUrl(url);
        return network.asyncDeleteCookies(request);
    }

    @Override
    public void clearCookies() throws Exception {
        List<Cookie> cookies = cookies();
        List<Future> futures = new ArrayList<>(cookies.size());
        for(Cookie cookie : cookies) {
            futures.add(asyncDeleteCookies(cookie.getName(), cookie.getDomain(), cookie.getPath(), cookie.getUrl()));
        }
        for(Future future : futures) {
            future.get(1, TimeUnit.SECONDS);
        }
    }

    @Override
    public List<Cookie> cookies() throws Exception {
        return doGetCookies(url.toString());
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
    public void close() throws Exception {
        SettableFuture future = SettableFuture.create();
        Consumer<String> consumer = targetId -> {
            if (Objects.equals(frameId, targetId)) {
                future.set(targetId);
            }
        };
        browserContext.addListener(ChromeContextEvent.TARGETDESTROYED, consumer);
        try {
            browserContext.browser().closeTarget(frameId);
            future.get(1, TimeUnit.SECONDS);
        } finally {
            browserContext.removeListener(ChromeContextEvent.TARGETDESTROYED, consumer);
            events.close();
            close = true;
        }
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
    public void removeOnNewDocument(String scriptId) throws Exception {
        RemoveScriptToEvaluateOnNewDocumentRequest request = new RemoveScriptToEvaluateOnNewDocumentRequest();
        request.setIdentifier(scriptId);
        page.removeScriptToEvaluateOnNewDocument(request, DEFAULT_TIMEOUT);
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

    @Override
    public byte[] screenshot() throws Exception {
        CaptureScreenshotRequest request = new CaptureScreenshotRequest();
        request.setFormat("png");
        CaptureScreenshotResponse response = page.captureScreenshot(request, DEFAULT_TIMEOUT);
        return Base64.getDecoder().decode(response.getData());
    }

    @Override
    public void stopLoading() throws Exception {
        page.stopLoading(DEFAULT_TIMEOUT);
    }
}
