package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import io.netty.channel.EventLoop;
import jpuppeteer.api.Request;
import jpuppeteer.api.Response;
import jpuppeteer.api.*;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.browser.TargetClosed;
import jpuppeteer.api.event.browser.TargetCrashed;
import jpuppeteer.api.event.browser.TargetCreated;
import jpuppeteer.api.event.browser.TargetInfoChanged;
import jpuppeteer.api.event.page.RequestInterceptedEvent;
import jpuppeteer.api.event.page.*;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration;
import jpuppeteer.cdp.client.entity.browser.Bounds;
import jpuppeteer.cdp.client.entity.browser.GetWindowForTargetRequest;
import jpuppeteer.cdp.client.entity.browser.SetWindowBoundsRequest;
import jpuppeteer.cdp.client.entity.deviceorientation.SetDeviceOrientationOverrideRequest;
import jpuppeteer.cdp.client.entity.emulation.SetDeviceMetricsOverrideRequest;
import jpuppeteer.cdp.client.entity.emulation.SetGeolocationOverrideRequest;
import jpuppeteer.cdp.client.entity.emulation.SetTouchEmulationEnabledRequest;
import jpuppeteer.cdp.client.entity.emulation.SetUserAgentOverrideRequest;
import jpuppeteer.cdp.client.entity.emulation.*;
import jpuppeteer.cdp.client.entity.fetch.AuthRequiredEvent;
import jpuppeteer.cdp.client.entity.fetch.HeaderEntry;
import jpuppeteer.cdp.client.entity.fetch.RequestPausedEvent;
import jpuppeteer.cdp.client.entity.input.TouchPoint;
import jpuppeteer.cdp.client.entity.network.*;
import jpuppeteer.cdp.client.entity.page.LifecycleEvent;
import jpuppeteer.cdp.client.entity.page.*;
import jpuppeteer.cdp.client.entity.runtime.*;
import jpuppeteer.cdp.client.entity.target.ActivateTargetRequest;
import jpuppeteer.cdp.client.entity.target.CloseTargetRequest;
import jpuppeteer.cdp.client.entity.target.TargetInfo;
import jpuppeteer.constant.LifecyclePhase;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.entity.BasicHttpHeader;
import jpuppeteer.entity.HttpResource;
import jpuppeteer.entity.Point;
import jpuppeteer.util.XFuture;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ChromePage extends ChromeFrame implements Page {

    private static final Logger logger = LoggerFactory.getLogger(ChromePage.class);

    private final ChromeContext browserContext;

    private volatile TargetInfo targetInfo;

    private final ChromePage opener;

    private final URI uri;

    private volatile CDPConnection connection;

    private volatile Interceptor<? extends InterceptedResponse> interceptor;

    private final Map<String, BindingFunction> bindingMap;

    private final Map<String, ChromeFrame> frameMap;

    private final Map<Integer, Isolate> isolateMap;

    private final Map<String, Request> requestMap;

    private final Map<String, Response> responseMap;

    public ChromePage(ChromeContext browserContext, URI uri, TargetInfo targetInfo, ChromePage opener) {
        super(null, null);
        this.browserContext = browserContext;
        this.targetInfo = targetInfo;
        this.opener = opener;
        this.uri = uri;
        this.bindingMap = new ConcurrentHashMap<>();
        this.isolateMap = new ConcurrentHashMap<>();
        this.requestMap = new ConcurrentHashMap<>();
        this.responseMap = new ConcurrentHashMap<>();
        this.frameMap = new ConcurrentHashMap<>();
        this.initEventListeners();
    }

    public ChromePage(ChromeContext browserContext, TargetInfo targetInfo, ChromePage opener) {
        this(
                browserContext,
                createURI(browserContext.browser().uri(), targetInfo.getTargetId()),
                targetInfo, opener
        );
    }

    public ChromePage(ChromeContext browserContext, TargetInfo targetInfo) {
        this(browserContext, targetInfo, null);
    }

    private static URI createURI(URI parent, String targetId) {
        try {
            return new URI(
                    parent.getScheme(),
                    parent.getUserInfo(),
                    parent.getHost(),
                    parent.getPort(),
                    "/devtools/page/" + targetId,
                    null, null
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException("build uri failed", e);
        }
    }

    private void initFrame(ChromeFrame parent, FrameTree node) {
        ChromeFrame frame = parent.appendChild(node.getFrame());
        frameMap.put(node.getFrame().getId(), frame);
        if (node.getChildFrames() != null) {
            for(FrameTree child : node.getChildFrames()) {
                initFrame(frame, child);
            }
        }
    }

    public XFuture<Page> attach() {
        this.connection = new PageConnection();
        return this.connection.page.enable()
                .async(o -> this.connection.page.getFrameTree())
                .sync(response -> {
                    FrameTree root = response.getFrameTree();
                    setFrameInfo(root.getFrame());
                    frameMap.put(root.getFrame().getId(), this);
                    if (root.getChildFrames() != null) {
                        for(FrameTree node : root.getChildFrames()) {
                            initFrame(this, node);
                        }
                    }
                    return response;
                })
                .async(o -> {
                    SetLifecycleEventsEnabledRequest request = new SetLifecycleEventsEnabledRequest(true);
                    return this.connection.page.setLifecycleEventsEnabled(request);
                })
                .async(o -> this.connection.runtime.enable())
                .sync(o -> this);
    }

    protected EventLoop eventLoop() {
        return browserContext.browser().eventLoop();
    }

    protected CDPConnection connection() {
        return connection;
    }

    protected ChromeFrame getFrame(String frameId) {
        return frameMap.get(frameId);
    }

    protected ChromePage newOpener(TargetInfo info) {
        return new ChromePage(browserContext, info, this);
    }

    protected void initEventListeners() {
        AbstractListener<TargetCreated> createdListener = new AbstractListener<TargetCreated>() {
            @Override
            public void accept(TargetCreated event) {
                onTargetCreated(event.targetInfo);
            }
        };
        AbstractListener<TargetInfoChanged> changedListener = new AbstractListener<TargetInfoChanged>() {
            @Override
            public void accept(TargetInfoChanged event) {
                onTargetInfoChanged(event.targetInfo);
            }
        };
        AbstractListener<TargetCrashed> crashedListener = new AbstractListener<TargetCrashed>() {
            @Override
            public void accept(TargetCrashed event) {
                onTargetCrashed(event.targetId, event.status, event.errorCode);
            }
        };
        AbstractListener<TargetClosed> closedListener = new AbstractListener<TargetClosed>() {
            @Override
            public void accept(TargetClosed event) {
                //移除在浏览器对象上绑定的事件
                try {
                    onTargetDestroyed(event.targetId);
                } finally {
                    if (targetInfo.getTargetId().equals(event.targetId)) {
                        browserContext().browser().removeListener(createdListener);
                        browserContext().browser().removeListener(changedListener);
                        browserContext().browser().removeListener(crashedListener);
                        browserContext().browser().removeListener(this);
                    }
                }
            }
        };
        this.browserContext().browser().addListener(createdListener);
        this.browserContext().browser().addListener(changedListener);
        this.browserContext().browser().addListener(crashedListener);
        this.browserContext().browser().addListener(closedListener);
    }

    private void onTargetCreated(TargetInfo info) {
        if (targetInfo.getTargetId().equals(info.getTargetId())) {
            targetInfo = info;
        }
        if (targetInfo.getTargetId().equals(info.getOpenerId()) || (frameId() != null && frameId().equals(info.getOpenerId()))) {
            //如果targetId或者frameId有一个是相同的，则就是这个页面打开的
            ChromePage newPage = newOpener(info);
            newPage.attach().addListener(f -> {
                if (f.isSuccess()) {
                    emit(new NewPageEvent((ChromePage) f.getNow()));
                } else {
                    logger.error("new page attach failed", f.cause());
                }
            });
        }
    }

    private void onTargetInfoChanged(TargetInfo info) {
        if (targetInfo.getTargetId().equals(info.getTargetId())) {
            targetInfo = info;
        }
    }

    private void onTargetCrashed(String targetId, String status, int errorCode) {
        if (targetInfo.getTargetId().equals(targetId)) {
            emit(new CrashedEvent(errorCode, status));
        }
    }

    private void onTargetDestroyed(String targetId) {
        if (targetInfo.getTargetId().equals(targetId)) {
            emit(new ClosedEvent());
        }
    }

    private void onFrameAttached(String parentId, String frameId) {
        ChromeFrame parent = frameMap.get(parentId);
        if (parent == null) {
            logger.warn("parent frame not found, parentId={}", parentId);
            return;
        }
        ChromeFrame frame = parent.appendChild(frameId);
        frameMap.put(frameId, frame);
    }

    private void onFrameNavigated(FrameNavigatedEvent event) {
        ChromeFrame frame = frameMap.get(event.getFrame().getId());
        if (frame == null) {
            logger.warn("frame not found, frameId={}", event.getFrame().getId());
            return;
        }
        frame.setFrameInfo(event.getFrame());
        if (frame == ChromePage.this) {
            //如果是页面的跳转，则清空所有的请求跟响应map
            Request request = requestMap.remove(loaderId());
            Response response = responseMap.remove(loaderId());
            requestMap.clear();
            responseMap.clear();
            if (request != null) {
                requestMap.put(request.requestId(), request);
            }
            if (response != null) {
                responseMap.put(response.requestId(), response);
            }
        }
    }

    private void onFrameDetached(String frameId) {
        frameMap.remove(frameId);
    }

    private void onExecutionCreated(ExecutionContextDescription description) {
        Map<String, Object> auxData = description.getAuxData();
        String frameId = (String) auxData.get("frameId");
        ChromeFrame frame = frameMap.get(frameId);
        if (frame == null) {
            logger.warn("frame not found, frameId={}, isolateId={}", frameId, description.getId());
            return;
        }
        boolean isDefault = (boolean) auxData.get("isDefault");
        String type = (String) auxData.get("type");
        ChromeIsolate isolate = new ChromeIsolate(frame, description.getId(), description.getName(), description.getUniqueId());
        if (isDefault && "default".equals(type)) {
            frame.setIsolate(isolate);
            isolateMap.put(description.getId(), frame);
        } else {
            isolateMap.putIfAbsent(description.getId(), isolate);
        }
    }

    private void onExecutionDestroyed(Integer executionId) {
        Isolate isolate = isolateMap.remove(executionId);
        if (isolate instanceof ChromeFrame) {
            ChromeFrame frame = (ChromeFrame) isolate;
            frame.setIsolate(null);
        }
    }

    private void onExecutionCleared() {
        Iterator<Map.Entry<Integer, Isolate>> iterator = isolateMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Isolate> entry = iterator.next();
            Isolate isolate = entry.getValue();
            if (isolate instanceof ChromeFrame) {
                ChromeFrame frame = (ChromeFrame) isolate;
                frame.setIsolate(null);
            }
            iterator.remove();
        }
    }

    protected XFuture<?> addBinding0(String isolateName, String name, BindingFunction function) {
        AddBindingRequest request = new AddBindingRequest(name, null, isolateName);
        bindingMap.put(name, function);
        return connection.runtime.addBinding(request);
    }

    protected XFuture<?> removeBinding0(String name) {
        RemoveBindingRequest request = new RemoveBindingRequest(name);
        bindingMap.remove(name);
        return connection.runtime.removeBinding(request);
    }

    protected void onBindingCall(BindingCalledEvent event) {
        BindingFunction function = bindingMap.get(event.getName());
        if (function == null) {
            logger.warn("binding function not found, targetId={}, name={}", targetId(), event.getName());
            return;
        }
        Isolate isolate = this.isolateMap.get(event.getExecutionContextId());
        if (isolate == null) {
            logger.warn("isolate not found, targetId={}, isolateId={}", targetId(), event.getExecutionContextId());
            return;
        }
        function.call(isolate, event.getPayload());
    }

    protected void onLifecycle(LifecycleEvent event) {
        ChromeFrame frame = this.frameMap.get(event.getFrameId());
        if (frame == null) {
            logger.warn("handle lifecycle event failed, targetId={}, frameId={}", targetId(), event.getFrameId());
            return;
        }
        LifecyclePhase phase = LifecyclePhase.findByValue(event.getName());
        if (phase == null) {
            logger.warn("unsupported lifecycle, targetId={}, event={}", targetId(), event.getName());
            return;
        }
        emit(new jpuppeteer.api.event.page.LifecycleEvent(frame, phase));
    }

    protected void onDomContentLoaded(DomContentEventFiredEvent event) {
        emit(new DomReadyEvent(event.getTimestamp()));
    }

    protected void onPageLoaded(LoadEventFiredEvent event) {
        emit(new LoadedEvent(event.getTimestamp()));
    }

    protected void onJavascriptDialog(JavascriptDialogOpeningEvent event) {
        emit(new DialogEvent(connection.page, event.getUrl(), event.getType(), event.getMessage(), event.getDefaultPrompt(), event.getHasBrowserHandler()));
    }

    protected void onExceptionThrown(ExceptionThrownEvent event) {
        emit(new ErrorEvent(event.getExceptionDetails()));
    }

    private static HttpHeader[] parseHeaders(Map<String, Object> headerMap) {
        if (headerMap == null) {
            return null;
        }
        List<HttpHeader> headerList = new ArrayList<>(headerMap.size());
        for(Map.Entry<String, Object> entry : headerMap.entrySet()) {
            String[] items = entry.getValue().toString().split("\n");
            for(String item : items) {
                item = StringUtils.trim(item);
                headerList.add(new BasicHttpHeader(entry.getKey(), item));
            }
        }
        HttpHeader[] headers = new HttpHeader[headerList.size()];
        headerList.toArray(headers);
        return headers;
    }

    private RequestEvent.RequestEventBuilder requestBuilder(jpuppeteer.cdp.client.entity.network.Request request) {
        HttpHeader[] headers = parseHeaders(request.getHeaders());
        String url = request.getUrl();
        if (StringUtils.isNotEmpty(request.getUrlFragment())) {
            url += "#" + request.getUrlFragment();
        }
        return RequestEvent.newBuilder()
                .network(connection.network)
                .executor(eventLoop())
                .url(url)
                .method(request.getMethod())
                .headers(headers)
                .hasPostData(request.getHasPostData() != null && request.getHasPostData())
                .postData(request.getPostData());
    }

    protected void onRequest(RequestWillBeSentEvent event) {
        if (event.getFrameId() == null) {
            return;
        }
        ChromeFrame frame = this.frameMap.get(event.getFrameId());
        if (frame == null) {
            logger.error("handle request failed, targetId={}, frameId={}", targetId(), event.getFrameId());
            return;
        }
        String location = event.getRedirectResponse() != null ? event.getRedirectResponse().getUrl() : null;
        RequestEvent requestEvent = requestBuilder(event.getRequest())
                .requestId(event.getRequestId())
                .loaderId(event.getLoaderId())
                .frame(frame)
                .resourceType(event.getType())
                .location(location)
                .build();
        requestMap.put(event.getRequestId(), requestEvent);
        emit(requestEvent);
    }

    protected void onResponse(ResponseReceivedEvent event) {
        if (event.getFrameId() == null) {
            return;
        }
        ChromeFrame frame = this.frameMap.get(event.getFrameId());
        if (frame == null) {
            logger.error("handle response failed, targetId={}, frameId={}", targetId(), event.getFrameId());
            return;
        }
        HttpHeader[] headers = parseHeaders(event.getResponse().getHeaders());
        HttpHeader[] requestHeaders = parseHeaders(event.getResponse().getRequestHeaders());
        InetSocketAddress remoteAddress = null;
        if (StringUtils.isNotEmpty(event.getResponse().getRemoteIPAddress())) {
            remoteAddress = new InetSocketAddress(event.getResponse().getRemoteIPAddress(), event.getResponse().getRemotePort());
        }

        ResponseEvent responseEvent = ResponseEvent.newBuilder()
                .network(connection.network)
                .executor(eventLoop())
                .requestId(event.getRequestId())
                .loaderId(event.getLoaderId())
                .frame(frame)
                .resourceType(event.getType())
                .url(event.getResponse().getUrl())
                .protocol(event.getResponse().getProtocol())
                .status(event.getResponse().getStatus())
                .statusText(event.getResponse().getStatusText())
                .mimeType(event.getResponse().getMimeType())
                .headers(headers)
                .requestHeaders(requestHeaders)
                .connectionReused(event.getResponse().getConnectionReused())
                .connectionId(event.getResponse().getConnectionId().intValue())
                .remoteAddress(remoteAddress)
                .fromDiskCache(event.getResponse().getFromDiskCache())
                .fromServiceWorker(event.getResponse().getFromServiceWorker())
                .fromPrefetchCache(event.getResponse().getFromPrefetchCache())
                .encodedDataLength(event.getResponse().getEncodedDataLength().intValue())
                .build();
        responseMap.put(event.getRequestId(), responseEvent);
        emit(responseEvent);
    }

    protected void onRequestFailed(LoadingFailedEvent event) {
        Request request = requestMap.remove(event.getRequestId());
        Response response = responseMap.remove(event.getRequestId());
        emit(new RequestFailedEvent(request, response, event.getRequestId(), event.getErrorText(), event.getCanceled()));
    }

    protected void onRequestFinished(LoadingFinishedEvent event) {
        Request request = requestMap.remove(event.getRequestId());
        Response response = responseMap.remove(event.getRequestId());
        emit(new RequestFinishedEvent(request, response, event.getRequestId(), event.getEncodedDataLength().intValue()));
    }

    protected void onRequestPaused(RequestPausedEvent event) {
        if (event.getFrameId() == null) {
            return;
        }
        ChromeFrame frame = this.frameMap.get(event.getFrameId());
        if (frame == null) {
            logger.error("handle request intercept failed, targetId={}, frameId={}", targetId(), event.getFrameId());
            return;
        }
        Request request = requestBuilder(event.getRequest())
                .requestId(event.getNetworkId())
                .loaderId(null)
                .frame(frame)
                .resourceType(event.getResourceType())
                .build();

        HttpHeader[] responseHeaders = null;
        if (event.getResponseHeaders() != null && event.getResponseHeaders().size() > 0) {
            List<HttpHeader> responseHeaderList = new ArrayList<>(event.getResponseHeaders().size());
            for (int i = 0; i< event.getResponseHeaders().size(); i++) {
                HeaderEntry entry = event.getResponseHeaders().get(i);
                String[] items = entry.getValue().split("\n");
                for(String item : items) {
                    item = StringUtils.trim(item);
                    responseHeaderList.add(new BasicHttpHeader(entry.getName(), item));
                }
            }
            responseHeaders = new HttpHeader[responseHeaderList.size()];
            responseHeaderList.toArray(responseHeaders);
        }
        InterceptedResponse interceptedRequest = RequestInterceptedEvent.newBuilder()
                .fetch(connection.fetch)
                .executor(eventLoop())
                .frame(frame)
                .interceptorId(event.getRequestId())
                .request(request)
                .responseErrorReason(event.getResponseErrorReason())
                .responseStatusCode(event.getResponseStatusCode())
                .responseHeaders(responseHeaders)
                .build();

        Interceptor<InterceptedResponse> interceptor = (Interceptor<InterceptedResponse>) this.interceptor;
        if (interceptor == null) {
            logger.error("interceptor not found, targetId={}", targetId());
            //找不到interceptor的时候直接继续
            interceptedRequest.continues();
            return;
        }

        interceptor.intercept(interceptedRequest);
    }

    protected void onAuthRequired(AuthRequiredEvent event) {
        ChromeFrame frame = this.frameMap.get(event.getFrameId());
        if (frame == null) {
            logger.error("handle auth failed, targetId={}, frameId={}", targetId(), event.getFrameId());
            return;
        }
        Request request = requestBuilder(event.getRequest())
                .requestId(null)
                .loaderId(null)
                .frame(frame)
                .resourceType(event.getResourceType())
                .build();
        AuthEvent auth = new AuthEvent(
                frame, connection.fetch, event.getRequestId(),
                event.getAuthChallenge(), request);
        interceptor.authenticate(auth);
    }

    @Override
    public String targetId() {
        return targetInfo.getTargetId();
    }

    @Override
    public String title() {
        return targetInfo.getTitle();
    }

    @Override
    public String url() {
        return targetInfo.getUrl();
    }

    @Override
    public ChromePage page() {
        return this;
    }

    @Override
    public XFuture<?> reload(Boolean ignoreCache, String scriptToEvaluateOnLoad) {
        return connection.page.reload(new ReloadRequest(ignoreCache, scriptToEvaluateOnLoad));
    }

    @Override
    public ChromePage opener() {
        return opener;
    }

    @Override
    public ChromeFrame openerFrame() {
        if (targetInfo.getOpenerFrameId() == null) {
            return null;
        }
        ChromePage opener = opener();
        if (opener == null) {
            return null;
        }
        return opener.frameMap.get(targetInfo.getOpenerFrameId());
    }

    @Override
    public XFuture<?> bringToFront() {
        return connection.page.bringToFront();
    }

    @Override
    public BrowserContext browserContext() {
        return browserContext;
    }

    @Override
    public XFuture<?> setCookies(CookieParam... cookies) {
        SetCookiesRequest request = new SetCookiesRequest(Lists.newArrayList(cookies));
        return connection.network.setCookies(request);
    }

    @Override
    public XFuture<?> clearCookies() {
        return connection.network.clearBrowserCookies();
    }

    @Override
    public XFuture<Cookie[]> getCookies(String... urls) {
        return connection.network.getCookies(new GetCookiesRequest(Lists.newArrayList(urls)))
                .sync(o -> {
                    Cookie[] cookies = new Cookie[o.getCookies().size()];
                    o.getCookies().toArray(cookies);
                    return cookies;
                });
    }

    @Override
    public XFuture<?> close() {
        requestMap.clear();
        responseMap.clear();
        return connection.target.closeTarget(new CloseTargetRequest(targetId()));
    }

    @Override
    public XFuture<String> addScriptToEvaluateOnNewDocument(String script) {
        return connection.page.addScriptToEvaluateOnNewDocument(new AddScriptToEvaluateOnNewDocumentRequest(script))
                .sync(AddScriptToEvaluateOnNewDocumentResponse::getIdentifier);
    }

    @Override
    public XFuture<?> removeScriptToEvaluateOnNewDocument(String scriptId) {
        RemoveScriptToEvaluateOnNewDocumentRequest request = new RemoveScriptToEvaluateOnNewDocumentRequest(scriptId);
        return connection.page.removeScriptToEvaluateOnNewDocument(request);
    }

    @Override
    public XFuture<?> enableNetwork(EnableRequest request) {
        return connection.network.enable(request);
    }

    @Override
    public XFuture<?> disableNetwork() {
        return connection.network.disable();
    }

    @Override
    public XFuture<?> enableCache() {
        SetCacheDisabledRequest request = new SetCacheDisabledRequest(false);
        return connection.network.setCacheDisabled(request);
    }

    @Override
    public XFuture<?> disableCache() {
        SetCacheDisabledRequest request = new SetCacheDisabledRequest(true);
        return connection.network.setCacheDisabled(request);
    }

    @Override
    public XFuture<HttpResource> loadResource(String url, boolean disableCache) {
        LoadNetworkResourceRequest request = new LoadNetworkResourceRequest(frameId(), url, new LoadNetworkResourceOptions(disableCache, true));
        return connection.network.loadNetworkResource(request)
                        .sync(o -> {
                            if (!o.getResource().getSuccess()) {
                                throw new RuntimeException("load resource failed:" + o.getResource().getNetErrorName() + "("+ o.getResource().getNetError() +")");
                            } else {
                                return new HttpResource(
                                        connection,
                                        o.getResource().getHttpStatusCode().intValue(),
                                        parseHeaders(o.getResource().getHeaders()),
                                        o.getResource().getStream()
                                );
                            }
                        });
    }

    @Override
    public XFuture<?> enableRequestInterception(jpuppeteer.cdp.client.entity.fetch.EnableRequest request, Interceptor<? extends InterceptedResponse> interceptor) {
        this.interceptor = interceptor;
        return connection.fetch.enable(request);
    }

    @Override
    public XFuture<?> disableRequestInterception() {
        this.interceptor = null;
        return connection.fetch.disable();
    }

    @Override
    public XFuture<?> enableTouchEmulation(boolean enable, Integer maxTouchPoints) {
        return connection.emulation.setTouchEmulationEnabled(new SetTouchEmulationEnabledRequest(enable, maxTouchPoints));
    }

    @Override
    public XFuture<?> enableEmitTouchEventsForMouse(boolean enable, SetEmitTouchEventsForMouseRequestConfiguration configuration) {
        return connection.emulation.setEmitTouchEventsForMouse(new SetEmitTouchEventsForMouseRequest(enable, configuration));
    }

    @Override
    public XFuture<?> setHeaders(HttpHeader... headers) {
        Map<String, Object> extraHeaders = new HashMap<>();
        for(HttpHeader header : headers) {
            extraHeaders.put(header.name(), header.value());
        }
        SetExtraHTTPHeadersRequest request = new SetExtraHTTPHeadersRequest(extraHeaders);
        return connection.network.setExtraHTTPHeaders(request);
    }

    @Override
    public XFuture<?> setGeolocation(double latitude, double longitude, double accuracy) {
        SetGeolocationOverrideRequest request = new SetGeolocationOverrideRequest(
                BigDecimal.valueOf(latitude),
                BigDecimal.valueOf(longitude),
                BigDecimal.valueOf(accuracy));
        return connection.emulation.setGeolocationOverride(request);
    }

    @Override
    public XFuture<?> setUserAgent(SetUserAgentOverrideRequest userAgent) {
        return connection.emulation.setUserAgentOverride(userAgent);
    }

    @Override
    public XFuture<?> setDevice(SetDeviceMetricsOverrideRequest device) {
        return connection.emulation.setDeviceMetricsOverride(device);
    }

    @Override
    public XFuture<?> setOrientation(double alpha, double beta, double gamma) {
        SetDeviceOrientationOverrideRequest request = new SetDeviceOrientationOverrideRequest(
                BigDecimal.valueOf(alpha),
                BigDecimal.valueOf(beta),
                BigDecimal.valueOf(gamma)
        );
        return connection.deviceOrientation.setDeviceOrientationOverride(request);
    }

    @Override
    public XFuture<?> setWindow(Bounds bounds) {
        return connection.browser.getWindowForTarget(new GetWindowForTargetRequest(targetId()))
                .async(o -> connection.browser.setWindowBounds(new SetWindowBoundsRequest(o.getWindowId(), bounds)));
    }

    @Override
    public XFuture<byte[]> screenshot(CaptureScreenshotRequest request) {
        XFuture<byte[]> future = connection.page.captureScreenshot(request)
                .sync(o -> Base64.getDecoder().decode(o.getData()));
        bringToFront().addListener(f -> {
            if (f.cause() != null) {
                future.cancel(true);
            }
        });
        return future;
    }

    @Override
    public XFuture<?> stopLoading() {
        return connection.page.stopLoading();
    }

    @Override
    public XFuture<?> enableInput() {
        return connection.inputWrapper.enable();
    }

    @Override
    public XFuture<?> disableInput() {
        return connection.inputWrapper.disable();
    }

    @Override
    public XFuture<?> keyDown(USKeyboardDefinition key) {
        return connection.inputWrapper.keyDown(key);
    }

    @Override
    public XFuture<?> keyUp(USKeyboardDefinition key) {
        return connection.inputWrapper.keyUp(key);
    }

    @Override
    public XFuture<?> press(USKeyboardDefinition key, int delay) {
        return connection.inputWrapper.press(key, delay);
    }

    @Override
    public XFuture<?> mouseDown(MouseDefinition mouseDefinition) {
        return connection.inputWrapper.mouseDown(mouseDefinition);
    }

    @Override
    public XFuture<?> mouseUp(MouseDefinition mouseDefinition) {
        return connection.inputWrapper.mouseUp(mouseDefinition);
    }

    @Override
    public XFuture<?> click(MouseDefinition mouseDefinition, int delay) {
        return connection.inputWrapper.click(mouseDefinition, delay);
    }

    @Override
    public XFuture<?> mouseMove(int x, int y) {
        return connection.inputWrapper.mouseMove(x, y);
    }

    @Override
    public Point mousePosition() {
        return connection.inputWrapper.mousePosition();
    }

    @Override
    public XFuture<?> mouseWheel(int deltaX, int deltaY) {
        return connection.inputWrapper.mouseWheel(deltaX, deltaY);
    }

    @Override
    public XFuture<?> touchStart(TouchPoint[] touchPoints) {
        return connection.inputWrapper.touchStart(touchPoints);
    }

    @Override
    public XFuture<?> touchStart(int x, int y) {
        return connection.inputWrapper.touchStart(x, y);
    }

    @Override
    public XFuture<?> touchEnd() {
        return connection.inputWrapper.touchEnd();
    }

    @Override
    public XFuture<?> touchMove(TouchPoint[] touchPoints) {
        return connection.inputWrapper.touchMove(touchPoints);
    }

    @Override
    public XFuture<?> touchMove(int x, int y) {
        return connection.inputWrapper.touchMove(x, y);
    }

    @Override
    public XFuture<?> touchCancel() {
        return connection.inputWrapper.touchCancel();
    }

    @Override
    public XFuture<?> activate() {
        return connection.target.activateTarget(new ActivateTargetRequest(targetId()));
    }

    class PageConnection extends CDPConnection {

        public PageConnection() {
            super(ChromePage.this.eventLoop(), uri);
        }

        @Override
        protected void onEvent(CDPEvent event) {
            switch (event.method) {

                case PAGE_FRAMEATTACHED:
                    FrameAttachedEvent frameAttachedEvent = event.getObject();
                    onFrameAttached(frameAttachedEvent.getParentFrameId(), frameAttachedEvent.getFrameId());
                    break;

                case PAGE_FRAMENAVIGATED:
                    FrameNavigatedEvent frameNavigatedEvent = event.getObject();
                    onFrameNavigated(frameNavigatedEvent);
                    break;

                case PAGE_FRAMEDETACHED:
                    FrameDetachedEvent frameDetachedEvent = event.getObject();
                    onFrameDetached(frameDetachedEvent.getFrameId());
                    break;

                case PAGE_LIFECYCLEEVENT:
                    LifecycleEvent lifecycleEvent = event.getObject();
                    onLifecycle(lifecycleEvent);
                    break;

                case PAGE_DOMCONTENTEVENTFIRED:
                    DomContentEventFiredEvent domContentEventFiredEvent = event.getObject();
                    onDomContentLoaded(domContentEventFiredEvent);
                    break;

                case PAGE_LOADEVENTFIRED:
                    LoadEventFiredEvent loadEventFiredEvent = event.getObject();
                    onPageLoaded(loadEventFiredEvent);
                    break;

                case PAGE_JAVASCRIPTDIALOGOPENING:
                    JavascriptDialogOpeningEvent javascriptDialogOpeningEvent = event.getObject();
                    onJavascriptDialog(javascriptDialogOpeningEvent);
                    break;

                case RUNTIME_EXECUTIONCONTEXTCREATED:
                    ExecutionContextCreatedEvent executionContextCreatedEvent = event.getObject();
                    onExecutionCreated(executionContextCreatedEvent.getContext());
                    break;

                case RUNTIME_EXECUTIONCONTEXTDESTROYED:
                    ExecutionContextDestroyedEvent executionContextDestroyedEvent = event.getObject();
                    onExecutionDestroyed(executionContextDestroyedEvent.getExecutionContextId());
                    break;

                case RUNTIME_EXECUTIONCONTEXTSCLEARED:
                    onExecutionCleared();
                    break;

                case RUNTIME_BINDINGCALLED:
                    BindingCalledEvent bindingCalledEvent = event.getObject();
                    onBindingCall(bindingCalledEvent);
                    break;

                case RUNTIME_EXCEPTIONTHROWN:
                    ExceptionThrownEvent exceptionThrownEvent = event.getObject();
                    onExceptionThrown(exceptionThrownEvent);
                    break;

                case NETWORK_REQUESTWILLBESENT:
                    RequestWillBeSentEvent requestWillBeSentEvent = event.getObject();
                    onRequest(requestWillBeSentEvent);
                    break;

                case NETWORK_RESPONSERECEIVED:
                    ResponseReceivedEvent responseReceivedEvent = event.getObject();
                    onResponse(responseReceivedEvent);
                    break;

                case NETWORK_LOADINGFAILED:
                    LoadingFailedEvent loadingFailedEvent = event.getObject();
                    onRequestFailed(loadingFailedEvent);
                    break;

                case NETWORK_LOADINGFINISHED:
                    LoadingFinishedEvent loadingFinishedEvent = event.getObject();
                    onRequestFinished(loadingFinishedEvent);
                    break;

                case FETCH_REQUESTPAUSED:
                    RequestPausedEvent requestPausedEvent = event.getObject();
                    onRequestPaused(requestPausedEvent);
                    break;

                case FETCH_AUTHREQUIRED:
                    AuthRequiredEvent authRequiredEvent = event.getObject();
                    onAuthRequired(authRequiredEvent);
                    break;
            }
        }
    }
}
