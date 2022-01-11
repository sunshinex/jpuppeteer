package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;
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
import jpuppeteer.util.SeriesPromise;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings({"rawtypes", "unchecked"})
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
                createURI(browserContext.browser().uri(), targetInfo.targetId),
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
        ChromeFrame frame = parent.appendChild(node.frame);
        frameMap.put(node.frame.id, frame);
        if (node.childFrames != null) {
            for(FrameTree child : node.childFrames) {
                initFrame(frame, child);
            }
        }
    }

    public void attach() {
        this.connection = new PageConnection();
        this.connection.page.enable();
        this.connection.page.getFrameTree().addListener(f -> {
            if (f.cause() != null) {
                logger.error("init page frame tree failed, targetId={}, error={}", targetId(), f.cause().getMessage(), f.cause());
            } else {
                GetFrameTreeResponse response = (GetFrameTreeResponse) f.getNow();
                FrameTree root = response.frameTree;
                setFrameInfo(root.frame);
                frameMap.put(root.frame.id, this);
                if (root.childFrames != null) {
                    for(FrameTree node : root.childFrames) {
                        initFrame(this, node);
                    }
                }
                this.connection.page.setLifecycleEventsEnabled(new SetLifecycleEventsEnabledRequest(true));
                this.connection.runtime.enable();
            }
        });
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
                    if (targetInfo.targetId.equals(event.targetId)) {
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
        if (targetInfo.targetId.equals(info.targetId)) {
            targetInfo = info;
        }
        if (targetInfo.targetId.equals(info.openerId) || (frameId() != null && frameId().equals(info.openerId))) {
            //如果targetId或者frameId有一个是相同的，则就是这个页面打开的
            ChromePage newPage = newOpener(info);
            emit(new NewPageEvent(newPage));
        }
    }

    private void onTargetInfoChanged(TargetInfo info) {
        if (targetInfo.targetId.equals(info.targetId)) {
            targetInfo = info;
        }
    }

    private void onTargetCrashed(String targetId, String status, int errorCode) {
        if (targetInfo.targetId.equals(targetId)) {
            emit(new CrashedEvent(errorCode, status));
        }
    }

    private void onTargetDestroyed(String targetId) {
        if (targetInfo.targetId.equals(targetId)) {
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
        ChromeFrame frame = frameMap.get(event.frame.id);
        if (frame == null) {
            logger.warn("frame not found, frameId={}", event.frame.id);
            return;
        }
        frame.setFrameInfo(event.frame);
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
        Map<String, Object> auxData = description.auxData;
        String frameId = (String) auxData.get("frameId");
        ChromeFrame frame = frameMap.get(frameId);
        if (frame == null) {
            logger.warn("frame not found, frameId={}, isolateId={}", frameId, description.id);
            return;
        }
        boolean isDefault = (boolean) auxData.get("isDefault");
        String type = (String) auxData.get("type");
        ChromeIsolate isolate = new ChromeIsolate(frame, description.id, description.name, description.uniqueId);
        if (isDefault && "default".equals(type)) {
            frame.setIsolate(isolate);
            isolateMap.put(description.id, frame);
        } else {
            isolateMap.putIfAbsent(description.id, isolate);
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

    protected Future addBinding0(String isolateName, String name, BindingFunction function) {
        AddBindingRequest request = new AddBindingRequest(name, null, isolateName);
        bindingMap.put(name, function);
        return connection.runtime.addBinding(request);
    }

    protected Future removeBinding0(String name) {
        RemoveBindingRequest request = new RemoveBindingRequest(name);
        bindingMap.remove(name);
        return connection.runtime.removeBinding(request);
    }

    protected void onBindingCall(BindingCalledEvent event) {
        BindingFunction function = bindingMap.get(event.name);
        if (function == null) {
            logger.warn("binding function not found, targetId={}, name={}", targetId(), event.name);
            return;
        }
        Isolate isolate = this.isolateMap.get(event.executionContextId);
        if (isolate == null) {
            logger.warn("isolate not found, targetId={}, isolateId={}", targetId(), event.executionContextId);
            return;
        }
        function.call(isolate, event.payload);
    }

    protected void onLifecycle(LifecycleEvent event) {
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.warn("handle lifecycle event failed, targetId={}, frameId={}", targetId(), event.frameId);
            return;
        }
        LifecyclePhase phase = LifecyclePhase.findByValue(event.name);
        if (phase == null) {
            logger.warn("unsupported lifecycle, targetId={}, event={}", targetId(), event.name);
            return;
        }
        emit(new jpuppeteer.api.event.page.LifecycleEvent(frame, phase));
    }

    protected void onDomContentLoaded(DomContentEventFiredEvent event) {
        emit(new DomReadyEvent(event.timestamp));
    }

    protected void onPageLoaded(LoadEventFiredEvent event) {
        emit(new LoadedEvent(event.timestamp));
    }

    protected void onJavascriptDialog(JavascriptDialogOpeningEvent event) {
        emit(new DialogEvent(connection.page, event.url, event.type, event.message, event.defaultPrompt, event.hasBrowserHandler));
    }

    protected void onExceptionThrown(ExceptionThrownEvent event) {
        emit(new ErrorEvent(event.exceptionDetails));
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
        HttpHeader[] headers = parseHeaders(request.headers);
        String url = request.url;
        if (StringUtils.isNotEmpty(request.urlFragment)) {
            url += "#" + request.urlFragment;
        }
        return RequestEvent.newBuilder()
                .network(connection.network)
                .executor(eventLoop())
                .url(url)
                .method(request.method)
                .headers(headers)
                .hasPostData(request.hasPostData != null && request.hasPostData)
                .postData(request.postData);
    }

    protected void onRequest(RequestWillBeSentEvent event) {
        if (event.frameId == null) {
            return;
        }
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.error("handle request failed, targetId={}, frameId={}", targetId(), event.frameId);
            return;
        }
        String location = event.redirectResponse != null ? event.redirectResponse.url : null;
        RequestEvent requestEvent = requestBuilder(event.request)
                .requestId(event.requestId)
                .loaderId(event.loaderId)
                .frame(frame)
                .resourceType(event.type)
                .location(location)
                .build();
        requestMap.put(event.requestId, requestEvent);
        emit(requestEvent);
    }

    protected void onResponse(ResponseReceivedEvent event) {
        if (event.frameId == null) {
            return;
        }
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.error("handle response failed, targetId={}, frameId={}", targetId(), event.frameId);
            return;
        }
        HttpHeader[] headers = parseHeaders(event.response.headers);
        HttpHeader[] requestHeaders = parseHeaders(event.response.requestHeaders);
        InetSocketAddress remoteAddress = null;
        if (StringUtils.isNotEmpty(event.response.remoteIPAddress)) {
            remoteAddress = new InetSocketAddress(event.response.remoteIPAddress, event.response.remotePort);
        }

        ResponseEvent responseEvent = ResponseEvent.newBuilder()
                .network(connection.network)
                .executor(eventLoop())
                .requestId(event.requestId)
                .loaderId(event.loaderId)
                .frame(frame)
                .resourceType(event.type)
                .url(event.response.url)
                .protocol(event.response.protocol)
                .status(event.response.status)
                .statusText(event.response.statusText)
                .mimeType(event.response.mimeType)
                .headers(headers)
                .requestHeaders(requestHeaders)
                .connectionReused(event.response.connectionReused)
                .connectionId(event.response.connectionId.intValue())
                .remoteAddress(remoteAddress)
                .fromDiskCache(event.response.fromDiskCache)
                .fromServiceWorker(event.response.fromServiceWorker)
                .fromPrefetchCache(event.response.fromPrefetchCache)
                .encodedDataLength(event.response.encodedDataLength.intValue())
                .build();
        responseMap.put(event.requestId, responseEvent);
        emit(responseEvent);
    }

    protected void onRequestFailed(LoadingFailedEvent event) {
        Request request = requestMap.remove(event.requestId);
        Response response = responseMap.remove(event.requestId);
        emit(new RequestFailedEvent(request, response, event.requestId, event.errorText, event.canceled));
    }

    protected void onRequestFinished(LoadingFinishedEvent event) {
        Request request = requestMap.remove(event.requestId);
        Response response = responseMap.remove(event.requestId);
        emit(new RequestFinishedEvent(request, response, event.requestId, event.encodedDataLength.intValue()));
    }

    protected void onRequestPaused(RequestPausedEvent event) {
        if (event.frameId == null) {
            return;
        }
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.error("handle request intercept failed, targetId={}, frameId={}", targetId(), event.frameId);
            return;
        }
        Request request = requestBuilder(event.request)
                .requestId(event.networkId)
                .loaderId(null)
                .frame(frame)
                .resourceType(event.resourceType)
                .build();

        HttpHeader[] responseHeaders = null;
        if (event.responseHeaders != null && event.responseHeaders.size() > 0) {
            List<HttpHeader> responseHeaderList = new ArrayList<>(event.responseHeaders.size());
            for (int i=0; i<event.responseHeaders.size(); i++) {
                HeaderEntry entry = event.responseHeaders.get(i);
                String[] items = entry.value.split("\n");
                for(String item : items) {
                    item = StringUtils.trim(item);
                    responseHeaderList.add(new BasicHttpHeader(entry.name, item));
                }
            }
            responseHeaders = new HttpHeader[responseHeaderList.size()];
            responseHeaderList.toArray(responseHeaders);
        }
        InterceptedResponse interceptedRequest = RequestInterceptedEvent.newBuilder()
                .fetch(connection.fetch)
                .executor(eventLoop())
                .frame(frame)
                .interceptorId(event.requestId)
                .request(request)
                .responseErrorReason(event.responseErrorReason)
                .responseStatusCode(event.responseStatusCode)
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
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.error("handle auth failed, targetId={}, frameId={}", targetId(), event.frameId);
            return;
        }
        Request request = requestBuilder(event.request)
                .requestId(null)
                .loaderId(null)
                .frame(frame)
                .resourceType(event.resourceType)
                .build();
        AuthEvent auth = new AuthEvent(
                frame, connection.fetch, event.requestId,
                event.authChallenge, request);
        interceptor.authenticate(auth);
    }

    @Override
    public String targetId() {
        return targetInfo.targetId;
    }

    @Override
    public String title() {
        return targetInfo.title;
    }

    @Override
    public String url() {
        return targetInfo.url;
    }

    @Override
    public ChromePage page() {
        return this;
    }

    @Override
    public Future reload(Boolean ignoreCache, String scriptToEvaluateOnLoad) {
        return connection.page.reload(new ReloadRequest(ignoreCache, scriptToEvaluateOnLoad));
    }

    @Override
    public ChromePage opener() {
        return opener;
    }

    @Override
    public ChromeFrame openerFrame() {
        if (targetInfo.openerFrameId == null) {
            return null;
        }
        ChromePage opener = opener();
        if (opener == null) {
            return null;
        }
        return opener.frameMap.get(targetInfo.openerFrameId);
    }

    @Override
    public Future bringToFront() {
        return connection.page.bringToFront();
    }

    @Override
    public BrowserContext browserContext() {
        return browserContext;
    }

    @Override
    public Future setCookies(CookieParam... cookies) {
        SetCookiesRequest request = new SetCookiesRequest(Lists.newArrayList(cookies));
        return connection.network.setCookies(request);
    }

    @Override
    public Future clearCookies() {
        return connection.network.clearBrowserCookies();
    }

    @Override
    public Future<Cookie[]> getCookies(String... urls) {
        return SeriesPromise
                .wrap(connection.network.getCookies(new GetCookiesRequest(Lists.newArrayList(urls))))
                .sync(o -> {
                    Cookie[] cookies = new Cookie[o.cookies.size()];
                    o.cookies.toArray(cookies);
                    return cookies;
                });
    }

    @Override
    public Future close() {
        requestMap.clear();
        responseMap.clear();
        return connection.target.closeTarget(new CloseTargetRequest(targetId()));
    }

    @Override
    public Future<String> addScriptToEvaluateOnNewDocument(String script) {
        return SeriesPromise
                .wrap(connection.page.addScriptToEvaluateOnNewDocument(new AddScriptToEvaluateOnNewDocumentRequest(script)))
                .sync(o -> o.identifier);
    }

    @Override
    public Future removeScriptToEvaluateOnNewDocument(String scriptId) {
        RemoveScriptToEvaluateOnNewDocumentRequest request = new RemoveScriptToEvaluateOnNewDocumentRequest(scriptId);
        return connection.page.removeScriptToEvaluateOnNewDocument(request);
    }

    @Override
    public Future enableNetwork(EnableRequest request) {
        return connection.network.enable(request);
    }

    @Override
    public Future disableNetwork() {
        return connection.network.disable();
    }

    @Override
    public Future enableCache() {
        SetCacheDisabledRequest request = new SetCacheDisabledRequest(false);
        return connection.network.setCacheDisabled(request);
    }

    @Override
    public Future disableCache() {
        SetCacheDisabledRequest request = new SetCacheDisabledRequest(true);
        return connection.network.setCacheDisabled(request);
    }

    @Override
    public Future<HttpResource> loadResource(String url, boolean disableCache) {
        LoadNetworkResourceRequest request = new LoadNetworkResourceRequest(frameId(), url, new LoadNetworkResourceOptions(disableCache, true));
        return SeriesPromise.wrap(connection.network.loadNetworkResource(request))
                        .sync(o -> {
                            if (!o.resource.success) {
                                throw new RuntimeException("load resource failed:" + o.resource.netErrorName + "("+o.resource.netError+")");
                            } else {
                                return new HttpResource(
                                        connection,
                                        o.resource.httpStatusCode.intValue(),
                                        parseHeaders(o.resource.headers),
                                        o.resource.stream
                                );
                            }
                        });
    }

    @Override
    public Future enableRequestInterception(jpuppeteer.cdp.client.entity.fetch.EnableRequest request, Interceptor<? extends InterceptedResponse> interceptor) {
        this.interceptor = interceptor;
        return connection.fetch.enable(request);
    }

    @Override
    public Future disableRequestInterception() {
        this.interceptor = null;
        return connection.fetch.disable();
    }

    @Override
    public Future enableTouchEmulation(boolean enable, Integer maxTouchPoints) {
        return connection.emulation.setTouchEmulationEnabled(new SetTouchEmulationEnabledRequest(enable, maxTouchPoints));
    }

    @Override
    public Future enableEmitTouchEventsForMouse(boolean enable, SetEmitTouchEventsForMouseRequestConfiguration configuration) {
        return connection.emulation.setEmitTouchEventsForMouse(new SetEmitTouchEventsForMouseRequest(enable, configuration));
    }

    @Override
    public Future setHeaders(HttpHeader... headers) {
        Map<String, Object> extraHeaders = new HashMap<>();
        for(HttpHeader header : headers) {
            extraHeaders.put(header.name(), header.value());
        }
        SetExtraHTTPHeadersRequest request = new SetExtraHTTPHeadersRequest(extraHeaders);
        return connection.network.setExtraHTTPHeaders(request);
    }

    @Override
    public Future setGeolocation(double latitude, double longitude, double accuracy) {
        SetGeolocationOverrideRequest request = new SetGeolocationOverrideRequest(
                BigDecimal.valueOf(latitude),
                BigDecimal.valueOf(longitude),
                BigDecimal.valueOf(accuracy));
        return connection.emulation.setGeolocationOverride(request);
    }

    @Override
    public Future setUserAgent(SetUserAgentOverrideRequest userAgent) {
        return connection.emulation.setUserAgentOverride(userAgent);
    }

    @Override
    public Future setDevice(SetDeviceMetricsOverrideRequest device) {
        return connection.emulation.setDeviceMetricsOverride(device);
    }

    @Override
    public Future setWindow(Bounds bounds) {
        return SeriesPromise
                .wrap(connection.browser.getWindowForTarget(new GetWindowForTargetRequest(targetId())))
                .async(o -> connection.browser.setWindowBounds(new SetWindowBoundsRequest(o.windowId, bounds)));
    }

    @Override
    public Future<byte[]> screenshot(CaptureScreenshotRequest request) {
        Future<byte[]> future = SeriesPromise
                .wrap(connection.page.captureScreenshot(request))
                .sync(o -> Base64.getDecoder().decode(o.data));
        bringToFront().addListener(f -> {
            if (f.cause() != null) {
                future.cancel(true);
            }
        });
        return future;
    }

    @Override
    public Future stopLoading() {
        return connection.page.stopLoading();
    }

    @Override
    public Future enableInput() {
        return connection.inputWrapper.enable();
    }

    @Override
    public Future disableInput() {
        return connection.inputWrapper.disable();
    }

    @Override
    public Future keyDown(USKeyboardDefinition key) {
        return connection.inputWrapper.keyDown(key);
    }

    @Override
    public Future keyUp(USKeyboardDefinition key) {
        return connection.inputWrapper.keyUp(key);
    }

    @Override
    public Future press(USKeyboardDefinition key, int delay) {
        return connection.inputWrapper.press(key, delay);
    }

    @Override
    public Future mouseDown(MouseDefinition mouseDefinition) {
        return connection.inputWrapper.mouseDown(mouseDefinition);
    }

    @Override
    public Future mouseUp(MouseDefinition mouseDefinition) {
        return connection.inputWrapper.mouseUp(mouseDefinition);
    }

    @Override
    public Future click(MouseDefinition mouseDefinition, int delay) {
        return connection.inputWrapper.click(mouseDefinition, delay);
    }

    @Override
    public Future mouseMove(int x, int y) {
        return connection.inputWrapper.mouseMove(x, y);
    }

    @Override
    public Point mousePosition() {
        return connection.inputWrapper.mousePosition();
    }

    @Override
    public Future mouseWheel(int deltaX, int deltaY) {
        return connection.inputWrapper.mouseWheel(deltaX, deltaY);
    }

    @Override
    public Future touchStart(TouchPoint[] touchPoints) {
        return connection.inputWrapper.touchStart(touchPoints);
    }

    @Override
    public Future touchStart(int x, int y) {
        return connection.inputWrapper.touchStart(x, y);
    }

    @Override
    public Future touchEnd() {
        return connection.inputWrapper.touchEnd();
    }

    @Override
    public Future touchMove(TouchPoint[] touchPoints) {
        return connection.inputWrapper.touchMove(touchPoints);
    }

    @Override
    public Future touchMove(int x, int y) {
        return connection.inputWrapper.touchMove(x, y);
    }

    @Override
    public Future touchCancel() {
        return connection.inputWrapper.touchCancel();
    }

    @Override
    public Future activate() {
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
                    onFrameAttached(frameAttachedEvent.parentFrameId, frameAttachedEvent.frameId);
                    break;

                case PAGE_FRAMENAVIGATED:
                    FrameNavigatedEvent frameNavigatedEvent = event.getObject();
                    onFrameNavigated(frameNavigatedEvent);
                    break;

                case PAGE_FRAMEDETACHED:
                    FrameDetachedEvent frameDetachedEvent = event.getObject();
                    onFrameDetached(frameDetachedEvent.frameId);
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
                    onExecutionCreated(executionContextCreatedEvent.context);
                    break;

                case RUNTIME_EXECUTIONCONTEXTDESTROYED:
                    ExecutionContextDestroyedEvent executionContextDestroyedEvent = event.getObject();
                    onExecutionDestroyed(executionContextDestroyedEvent.executionContextId);
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
