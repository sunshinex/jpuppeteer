package jpuppeteer.chrome;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.Page;
import jpuppeteer.api.Request;
import jpuppeteer.api.Response;
import jpuppeteer.api.*;
import jpuppeteer.api.event.AbstractEventEmitter;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.event.PageEvent;
import jpuppeteer.api.event.page.RequestInterceptedEvent;
import jpuppeteer.api.event.page.*;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.client.constant.browser.WindowState;
import jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration;
import jpuppeteer.cdp.client.domain.Browser;
import jpuppeteer.cdp.client.domain.Runtime;
import jpuppeteer.cdp.client.domain.*;
import jpuppeteer.cdp.client.entity.browser.Bounds;
import jpuppeteer.cdp.client.entity.dom.GetFrameOwnerRequest;
import jpuppeteer.cdp.client.entity.dom.ResolveNodeRequest;
import jpuppeteer.cdp.client.entity.dom.ResolveNodeResponse;
import jpuppeteer.cdp.client.entity.emulation.SetDeviceMetricsOverrideRequest;
import jpuppeteer.cdp.client.entity.emulation.SetEmitTouchEventsForMouseRequest;
import jpuppeteer.cdp.client.entity.emulation.SetGeolocationOverrideRequest;
import jpuppeteer.cdp.client.entity.emulation.SetTouchEmulationEnabledRequest;
import jpuppeteer.cdp.client.entity.emulation.SetUserAgentOverrideRequest;
import jpuppeteer.cdp.client.entity.fetch.AuthRequiredEvent;
import jpuppeteer.cdp.client.entity.fetch.HeaderEntry;
import jpuppeteer.cdp.client.entity.fetch.RequestPausedEvent;
import jpuppeteer.cdp.client.entity.input.TouchPoint;
import jpuppeteer.cdp.client.entity.network.*;
import jpuppeteer.cdp.client.entity.page.LifecycleEvent;
import jpuppeteer.cdp.client.entity.page.*;
import jpuppeteer.cdp.client.entity.runtime.*;
import jpuppeteer.constant.LifecyclePhase;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.entity.BasicHttpHeader;
import jpuppeteer.entity.Point;
import jpuppeteer.util.Input;
import jpuppeteer.util.SeriesFuture;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("rawtypes")
public class ChromePage extends ChromeFrame implements Page {

    private static final Logger logger = LoggerFactory.getLogger(ChromePage.class);

    private final EventEmitter<PageEvent> emitter;

    private final String name;

    private final ChromeContext browserContext;

    private final CDPSession session;

    private final ChromePage opener;

    private final jpuppeteer.cdp.client.domain.Page page;

    private final Fetch fetch;

    private final Network network;

    private final Runtime runtime;

    private final Emulation emulation;

    private final jpuppeteer.util.Input input;

    private volatile Interceptor<? extends InterceptedResponse> interceptor;

    private final Map<String, BindingFunction> bindingMap;

    private final Map<String, ChromeFrame> frameMap;

    private final Map<Integer, Isolate> isolateMap;

    private final Map<String, Request> requestMap;

    private final Map<String, Response> responseMap;

    public ChromePage(String name, ChromeContext browserContext, CDPSession session, ChromePage opener) {
        super(null, null, session.targetId(), null,
                new jpuppeteer.cdp.client.domain.Page(session),
                new DOM(session), new Runtime(session),
                new Input(new jpuppeteer.cdp.client.domain.Input(session), browserContext.executor()),
                browserContext.executor()
        );
        this.emitter = new AbstractEventEmitter<PageEvent>() {
            @Override
            protected void emitInternal(AbstractListener<PageEvent> listener, PageEvent event) {
                EventExecutor executor = browserContext.executor();
                if (executor.inEventLoop()) {
                    listener.accept(event);
                } else {
                    executor.execute(() -> listener.accept(event));
                }
            }
        };
        this.name = name;
        this.browserContext = browserContext;
        this.session = session;
        this.opener = opener;
        this.page = pageDomain();
        this.fetch = new Fetch(session);
        this.network = new Network(session);
        this.runtime = runtime();
        this.emulation = new Emulation(session);
        this.input = input();
        this.bindingMap = new ConcurrentHashMap<>();
        this.frameMap = new ConcurrentHashMap<>();
        //将自己丢到frameMap里面
        this.frameMap.put(targetId(), this);
        this.isolateMap = new ConcurrentHashMap<>();
        //保存request跟response,后面会用到
        this.requestMap = new ConcurrentHashMap<>();
        this.responseMap = new ConcurrentHashMap<>();
        //enable features
        this.page.enable();
        this.page.setLifecycleEventsEnabled(new SetLifecycleEventsEnabledRequest(true));
        //this.dom.enable();
        this.runtime.enable();
    }

    public String targetId() {
        return session.targetId();
    }

    public String sessionId() {
        return session.sessionId();
    }

    public void handleFrameAttached(FrameAttachedEvent event) {
        ChromeFrame parent = this.frameMap.get(event.parentFrameId);
        if (parent == null) {
            logger.warn("[{}] parent frame not found, parentId={}, frameId={}", targetId(), event.parentFrameId, event.frameId);
            return;
        }
        Future<Element> ownerFuture = SeriesFuture
                .wrap(dom().getFrameOwner(new GetFrameOwnerRequest(event.frameId)))
                .async(o -> dom().resolveNode(new ResolveNodeRequest(null, o.backendNodeId, null, null)))
                .sync(o -> {
                    BrowserObject ownerObject = new ChromeObject(parent, runtime, o.object.objectId, executor());
                    return new ChromeElement(this, dom(), parent, runtime, input, ownerObject, executor());
                });
        ChromeFrame child = parent.appendChild(event.frameId, ownerFuture);
        frameMap.put(event.frameId, child);
    }

    public void handleFrameNavigated(FrameNavigatedEvent event) {
        ChromeFrame frame = this.frameMap.get(event.frame.id);
        if (frame == null) {
            logger.warn("[{}] parent frame not found, frameId={}", targetId(), event.frame.id);
        } else if (frame.parent() == null) {
            //页面导航完成的时候需要清空，requestMap跟responseMap，但是导航页本身的请求要保留
            Request request = requestMap.get(event.frame.loaderId);
            Response response = responseMap.get(event.frame.loaderId);
            requestMap.clear();
            responseMap.clear();
            if (request != null) {
                requestMap.put(request.requestId(), request);
                responseMap.put(request.requestId(), response);
            }
        }
    }


    public void handleFrameDetached(FrameDetachedEvent event) {
        ChromeFrame frame = this.frameMap.remove(event.frameId);
        if (frame == null) {
            logger.warn("[{}] frame not found, frameId={}", targetId(), event.frameId);
        }
    }

    public void handleIsolateCreated(ExecutionContextCreatedEvent event) {
        Map<String, Object> auxData = event.context.auxData;
        String frameId = (String) auxData.get("frameId");
        ChromeFrame frame = this.frameMap.get(frameId);
        if (frame == null) {
            logger.error("[{}] handle isolate created failed, frameId={}, isolateId={}", targetId(), frameId, event.context.id);
            return;
        }
        logger.info("[{}] isolate created, frameId={}, isolateId={}", targetId(), frameId, event.context.id);
        boolean isDefault = (boolean) auxData.get("isDefault");
        String type = (String) auxData.get("type");
        if (isDefault && "default".equals(type)) {
            frame.createIsolate(event.context.id, event.context.name);
            isolateMap.put(event.context.id, frame);
        } else {
            ChromeIsolate isolate = new ChromeIsolate(runtime, event.context.id, event.context.name, frame, executor());
            isolateMap.putIfAbsent(event.context.id, isolate);
        }
    }

    public void handleIsolateDestroyed(ExecutionContextDestroyedEvent event) {
        Isolate isolate = this.isolateMap.remove(event.executionContextId);
        if (isolate == null) {
            logger.error("[{}] isolate not found, isolateId={}", targetId(), event.executionContextId);
            return;
        }
        logger.info("[{}] isolate destroyed, isolateId={}", targetId(), event.executionContextId);
        if (isolate instanceof ChromeFrame) {
            //如果对应的isolate是frame，则销毁当前frame的isolate，等待重建
            ((ChromeFrame) isolate).destroyIsolate();
        }
    }

    public void handleIsolateCleared() {
        Iterator<Map.Entry<Integer, Isolate>> iterator = this.isolateMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Isolate> entry = iterator.next();
            Isolate isolate = entry.getValue();
            if (isolate instanceof ChromeFrame) {
                //如果对应的isolate是frame，则销毁当前frame的isolate，等待重建
                ((ChromeFrame) isolate).destroyIsolate();
            }
            iterator.remove();
        }
    }

    public void handleBindingCall(BindingCalledEvent event) {
        BindingFunction function = bindingMap.get(event.name);
        if (function == null) {
            logger.warn("[{}] binding function not found, name={}", targetId(), event.name);
            return;
        }
        Isolate isolate = this.isolateMap.get(event.executionContextId);
        if (isolate == null) {
            logger.warn("[{}] isolate not found, isolateId={}", targetId(), event.executionContextId);
            return;
        }
        function.call(isolate, event.payload);
    }

    public void handleLifecycle(LifecycleEvent event) {
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.warn("[{}] handle lifecycle failed, frameId={}", targetId(), event.frameId);
            return;
        }
        LifecyclePhase phase = LifecyclePhase.findByValue(event.name);
        if (phase == null) {
            logger.warn("[{}] unsupported lifecycle event: {}", targetId(), event.name);
            return;
        }
        emit(new jpuppeteer.api.event.page.LifecycleEvent(frame, phase));
    }

    public void handleDomContentLoaded(DomContentEventFiredEvent event) {
        emit(new DomReadyEvent(event.timestamp));
    }

    public void handlePageLoaded(LoadEventFiredEvent event) {
        emit(new LoadedEvent(event.timestamp));
    }

    public void handleJavascriptDialog(JavascriptDialogOpeningEvent event) {
        emit(new DialogEvent(page, event.url, event.type, event.message, event.defaultPrompt, event.hasBrowserHandler));
    }

    public void handleExceptionThrown(ExceptionThrownEvent event) {
        //TODO 此处可以考虑找到对应的isolate然后传递事件
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
                .network(network)
                .executor(executor())
                .url(url)
                .method(request.method)
                .headers(headers)
                .hasPostData(request.hasPostData != null && request.hasPostData)
                .postData(request.postData);
    }

    public void handleRequest(RequestWillBeSentEvent event) {
        if (event.frameId == null) {
            return;
        }
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.error("[{}] handle request failed, frameId={}", targetId(), event.frameId);
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

    public void handleResponse(ResponseReceivedEvent event) {
        if (event.frameId == null) {
            return;
        }
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.error("[{}] handle response failed, frameId={}", targetId(), event.frameId);
            return;
        }
        HttpHeader[] headers = parseHeaders(event.response.headers);
        HttpHeader[] requestHeaders = parseHeaders(event.response.requestHeaders);
        InetSocketAddress remoteAddress = null;
        if (StringUtils.isNotEmpty(event.response.remoteIPAddress)) {
            remoteAddress = new InetSocketAddress(event.response.remoteIPAddress, event.response.remotePort);
        }

        ResponseEvent responseEvent = ResponseEvent.newBuilder()
                .network(network)
                .executor(executor())
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

    public void handleRequestFailed(LoadingFailedEvent event) {
        Request request = requestMap.remove(event.requestId);
        Response response = responseMap.remove(event.requestId);
        emit(new RequestFailedEvent(request, response, event.requestId, event.errorText, event.canceled));
    }

    public void handleRequestFinished(LoadingFinishedEvent event) {
        Request request = requestMap.remove(event.requestId);
        Response response = responseMap.remove(event.requestId);
        emit(new RequestFinishedEvent(request, response, event.requestId, event.encodedDataLength.intValue()));
    }

    public void handleRequestPaused(RequestPausedEvent event) {
        if (event.frameId == null) {
            return;
        }
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.error("[{}] handle request intercept failed, frameId={}", targetId(), event.frameId);
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
                .fetch(fetch)
                .executor(executor())
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
            logger.error("[{}] interceptor not found", targetId());
            //找不到interceptor的时候直接继续
            interceptedRequest.continues();
            return;
        }

        interceptor.intercept(interceptedRequest);
    }

    public void handleAuthRequired(AuthRequiredEvent event) {
        ChromeFrame frame = this.frameMap.get(event.frameId);
        if (frame == null) {
            logger.error("[{}] handle auth failed, frameId={}", targetId(), event.frameId);
            return;
        }
        Request request = requestBuilder(event.request)
                .requestId(null)
                .loaderId(null)
                .frame(frame)
                .resourceType(event.resourceType)
                .build();
        AuthEvent auth = new AuthEvent(
                frame, fetch, event.requestId,
                event.authChallenge, request);
        interceptor.authenticate(auth);
    }

    @Override
    public Page page() {
        return this;
    }

    @Override
    public void emit(PageEvent event) {
        emitter.emit(event);
    }

    @Override
    public void addListener(AbstractListener<? extends PageEvent> listener) {
        emitter.addListener(listener);
    }

    @Override
    public void removeListener(AbstractListener<? extends PageEvent> listener) {
        emitter.removeListener(listener);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Future reload(Boolean ignoreCache, String scriptToEvaluateOnLoad) {
        return page.reload(new ReloadRequest(ignoreCache, scriptToEvaluateOnLoad));
    }

    @Override
    public Page opener() {
        return opener;
    }

    @Override
    public Future bringToFront() {
        return page.bringToFront();
    }

    @Override
    public BrowserContext browserContext() {
        return browserContext;
    }

    @Override
    public Future close() {
        return browserContext.closeTarget(session.targetId());
    }

    @Override
    public Future<String> addScriptToEvaluateOnNewDocument(String script) {
        return SeriesFuture
                .wrap(page.addScriptToEvaluateOnNewDocument(new AddScriptToEvaluateOnNewDocumentRequest(script)))
                .sync(o -> o.identifier);
    }

    @Override
    public Future removeScriptToEvaluateOnNewDocument(String scriptId) {
        RemoveScriptToEvaluateOnNewDocumentRequest request = new RemoveScriptToEvaluateOnNewDocumentRequest(scriptId);
        return page.removeScriptToEvaluateOnNewDocument(request);
    }

    @Override
    public Future enableNetwork(EnableRequest request) {
        return network.enable(request);
    }

    @Override
    public Future disableNetwork() {
        return network.disable();
    }

    @Override
    public Future enableCache() {
        SetCacheDisabledRequest request = new SetCacheDisabledRequest(false);
        return network.setCacheDisabled(request);
    }

    @Override
    public Future disableCache() {
        SetCacheDisabledRequest request = new SetCacheDisabledRequest(true);
        return network.setCacheDisabled(request);
    }

    @Override
    public Future addBinding(String name, BindingFunction function) {
        AddBindingRequest request = new AddBindingRequest(name, null);
        bindingMap.put(name, function);
        return runtime.addBinding(request);
    }

    @Override
    public Future removeBinding(String name) {
        RemoveBindingRequest request = new RemoveBindingRequest(name);
        bindingMap.remove(name);
        return runtime.removeBinding(request);
    }

    @Override
    public Future enableRequestInterception(jpuppeteer.cdp.client.entity.fetch.EnableRequest request, Interceptor<? extends InterceptedResponse> interceptor) {
        this.interceptor = interceptor;
        return fetch.enable(request);
    }

    @Override
    public Future disableRequestInterception() {
        this.interceptor = null;
        return fetch.disable();
    }

    @Override
    public Future enableTouchEmulation(boolean enable, Integer maxTouchPoints) {
        return emulation.setTouchEmulationEnabled(new SetTouchEmulationEnabledRequest(enable, maxTouchPoints));
    }

    @Override
    public Future enableEmitTouchEventsForMouse(boolean enable, SetEmitTouchEventsForMouseRequestConfiguration configuration) {
        return emulation.setEmitTouchEventsForMouse(new SetEmitTouchEventsForMouseRequest(enable, configuration));
    }

    @Override
    public Future setHeaders(HttpHeader... headers) {
        Map<String, Object> extraHeaders = new HashMap<>();
        for(HttpHeader header : headers) {
            extraHeaders.put(header.name(), header.value());
        }
        SetExtraHTTPHeadersRequest request = new SetExtraHTTPHeadersRequest(extraHeaders);
        return network.setExtraHTTPHeaders(request);
    }

    @Override
    public Future setGeolocation(double latitude, double longitude, double accuracy) {
        SetGeolocationOverrideRequest request = new SetGeolocationOverrideRequest(
                BigDecimal.valueOf(latitude),
                BigDecimal.valueOf(longitude),
                BigDecimal.valueOf(accuracy));
        return emulation.setGeolocationOverride(request);
    }

    @Override
    public Future setUserAgent(SetUserAgentOverrideRequest userAgent) {
        return emulation.setUserAgentOverride(userAgent);
    }

    @Override
    public Future setDevice(SetDeviceMetricsOverrideRequest device) {
        ChromeBrowser browser = (ChromeBrowser) browserContext().browser();
        Bounds bounds = new Bounds(0, 0, device.width, device.height, WindowState.NORMAL);
        return SeriesFuture
                .wrap(browser.setWindowBounds(targetId(), bounds))
                .async(o -> emulation.setDeviceMetricsOverride(device));
    }

    @Override
    public Future setWindow(Bounds bounds) {
        ChromeBrowser browser = (ChromeBrowser) browserContext.browser();
        return browser.setWindowBounds(targetId(), bounds);
    }

    @Override
    public Future<byte[]> screenshot(CaptureScreenshotRequest request) {
        Future<byte[]> future = SeriesFuture
                .wrap(page.captureScreenshot(request))
                .sync(o -> Base64.getDecoder().decode(o.data));
        page.bringToFront().addListener(f -> {
            if (f.cause() != null) {
                future.cancel(true);
            }
        });
        return future;
    }

    @Override
    public Future stopLoading() {
        return page.stopLoading();
    }

    @Override
    public Future expose(String bindingName) {
        return browserContext.exposeTarget(targetId(), bindingName);
    }

    @Override
    public Future enableInput() {
        return input.enable();
    }

    @Override
    public Future disableInput() {
        return input.disable();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Future keyDown(USKeyboardDefinition key) {
        return input.keyDown(key);
    }

    @Override
    public Future keyUp(USKeyboardDefinition key) {
        return input.keyUp(key);
    }

    @Override
    public Future press(USKeyboardDefinition key, int delay) {
        return input.press(key, delay);
    }

    @Override
    public Future mouseDown(MouseDefinition mouseDefinition) {
        return input.mouseDown(mouseDefinition);
    }

    @Override
    public Future mouseUp(MouseDefinition mouseDefinition) {
        return input.mouseUp(mouseDefinition);
    }

    @Override
    public Future click(MouseDefinition mouseDefinition, int delay) {
        return input.click(mouseDefinition, delay);
    }

    @Override
    public Future mouseMove(int x, int y) {
        return input.mouseMove(x, y);
    }

    @Override
    public Point mousePosition() {
        return input.mousePosition();
    }

    @Override
    public Future mouseWheel(int deltaX, int deltaY) {
        return input.mouseWheel(deltaX, deltaY);
    }

    @Override
    public Future touchStart(TouchPoint[] touchPoints) {
        return input.touchStart(touchPoints);
    }

    @Override
    public Future touchStart(int x, int y) {
        return input.touchStart(x, y);
    }

    @Override
    public Future touchEnd() {
        return input.touchEnd();
    }

    @Override
    public Future touchMove(TouchPoint[] touchPoints) {
        return input.touchMove(touchPoints);
    }

    @Override
    public Future touchMove(int x, int y) {
        return input.touchMove(x, y);
    }

    @Override
    public Future touchCancel() {
        return input.touchCancel();
    }

    @Override
    public Future activate() {
        return browserContext.activateTarget(targetId());
    }
}
