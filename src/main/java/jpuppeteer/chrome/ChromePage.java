package jpuppeteer.chrome;

import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import jpuppeteer.api.Request;
import jpuppeteer.api.Response;
import jpuppeteer.api.*;
import jpuppeteer.api.event.page.RequestInterceptedEvent;
import jpuppeteer.api.event.page.*;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration;
import jpuppeteer.cdp.client.entity.browser.Bounds;
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
import jpuppeteer.cdp.client.entity.target.TargetInfo;
import jpuppeteer.constant.LifecyclePhase;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.entity.BasicHttpHeader;
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

@SuppressWarnings("rawtypes")
public class ChromePage extends ChromeFrame implements Page {

    private static final Logger logger = LoggerFactory.getLogger(ChromePage.class);

    private final ChromeContext browserContext;

    private volatile TargetInfo targetInfo;

    private final URI uri;

    private volatile CDPConnection connection;

    private volatile Interceptor<? extends InterceptedResponse> interceptor;

    private final Map<String, BindingFunction> bindingMap;

    private final Map<String, ChromeFrame> frameMap;

    private final Map<Integer, Isolate> isolateMap;

    private final Map<String, Request> requestMap;

    private final Map<String, Response> responseMap;

    public ChromePage(ChromeContext browserContext, TargetInfo targetInfo) {
        super(null, null);
        this.browserContext = browserContext;
        this.targetInfo = targetInfo;
        try {
            this.uri = new URI(
                    browserContext.browser().uri().getScheme(),
                    browserContext.browser().uri().getUserInfo(),
                    browserContext.browser().uri().getHost(),
                    browserContext.browser().uri().getPort(),
                    "/devtools/page/" + targetId(),
                    null, null
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException("build uri failed", e);
        }
        this.bindingMap = new ConcurrentHashMap<>();
        this.isolateMap = new ConcurrentHashMap<>();
        this.requestMap = new ConcurrentHashMap<>();
        this.responseMap = new ConcurrentHashMap<>();
        this.frameMap = new ConcurrentHashMap<>();
    }

    private void initFrame(ChromeFrame parent, FrameTree node) {
        ChromeFrame frame = parent.appendChild(node.frame);
        frameMap.put(node.frame.id, frame);
        while (node.childFrames != null) {
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
                while (root.childFrames != null) {
                    for(FrameTree node : root.childFrames) {
                        initFrame(this, node);
                    }
                }
                browserContext.browser().onPageInit(this);
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

    protected void setTargetInfo(TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
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

    protected void onCrashed(Integer errorCode, String status) {
        emit(new CrashedEvent(errorCode, status));
    }

    protected void onClosed() {
        emit(new ClosedEvent());
    }

    protected void onNewPage(ChromePage page) {
        emit(new NewPageEvent(page));
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

        @SuppressWarnings("unchecked")
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
        if (targetInfo.openerId == null) {
            return null;
        } else {
            return browserContext.browser().getPage(targetInfo.openerId);
        }
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
    public Future close() {
        Promise promise = eventLoop().newPromise();
        connection.close().addListener(f0 -> {
            if (f0.cause() != null) {
                logger.error("disconnect connection failed, targetId={}, error={}", targetId(), f0.cause().getMessage(), f0.cause());
            }
            browserContext.browser().closeTarget(targetId()).addListener(f1 -> {
                if (f1.cause() != null) {
                    promise.tryFailure(f1.cause());
                } else {
                    promise.trySuccess(null);
                }
            });
        });
        return promise;
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
        return browserContext.browser().setWindowBounds(frameId(), bounds);
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
        return browserContext.browser().activateTarget(frameId());
    }

    class PageConnection extends CDPConnection {

        public PageConnection() {
            super(ChromePage.this.eventLoop(), uri);
        }

        @Override
        protected int genId() {
            return browserContext.browser().genMessageId();
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

        private void onFrameRequestedNavigation(FrameRequestedNavigationEvent event) {
            ChromeFrame frame = frameMap.get(event.frameId);
            if (frame == null) {
                logger.warn("frame not found, frameId={}", event.frameId);
                return;
            }
            if (frame == ChromePage.this) {
                requestMap.clear();
                responseMap.clear();
            }
        }

        private void onFrameNavigated(FrameNavigatedEvent event) {
            ChromeFrame frame = frameMap.get(event.frame.id);
            if (frame == null) {
                logger.warn("frame not found, frameId={}", event.frame.id);
                return;
            }
            frame.setFrameInfo(event.frame);
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
            ChromeIsolate isolate = new ChromeIsolate(frame, description.id, description.name);
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

        @Override
        protected void onEvent(CDPEvent event) {
            switch (event.method) {
                case PAGE_FRAMEATTACHED:
                    FrameAttachedEvent frameAttachedEvent = event.getObject();
                    onFrameAttached(frameAttachedEvent.parentFrameId, frameAttachedEvent.frameId);
                    break;

                case PAGE_FRAMEREQUESTEDNAVIGATION:
                    FrameRequestedNavigationEvent frameRequestedNavigationEvent = event.getObject();
                    onFrameRequestedNavigation(frameRequestedNavigationEvent);
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
