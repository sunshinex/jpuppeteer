package jpuppeteer.chrome;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Promise;
import jpuppeteer.api.*;
import jpuppeteer.api.event.AbstractEventEmitter;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.page.PageEvent;
import jpuppeteer.cdp.client.entity.page.CreateIsolatedWorldRequest;
import jpuppeteer.cdp.client.entity.page.NavigateRequest;
import jpuppeteer.cdp.client.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.client.entity.runtime.EvaluateRequest;
import jpuppeteer.constant.WatchAction;
import jpuppeteer.util.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static jpuppeteer.constant.WatchConsts.UNWATCH_PREFIX;
import static jpuppeteer.constant.WatchConsts.WATCH_PREFIX;

public class ChromeFrame extends AbstractEventEmitter<PageEvent> implements Frame {

    private static final Logger logger = LoggerFactory.getLogger(ChromeFrame.class);

    private static final String SCRIPT_WATCH = ScriptUtil.load("script/watch.js");

    private final ChromePage page;

    private volatile jpuppeteer.cdp.client.entity.page.Frame frameInfo;

    private volatile ChromeIsolate isolate;

    public ChromeFrame(ChromePage page, jpuppeteer.cdp.client.entity.page.Frame frameInfo) {
        this.page = page;
        this.frameInfo = frameInfo;
    }

    protected EventLoop eventLoop() {
        return page().eventLoop();
    }

    protected ChromeFrame appendChild(jpuppeteer.cdp.client.entity.page.Frame frameInfo) {
        return new ChromeFrame(page(), frameInfo);
    }

    protected ChromeFrame appendChild(String frameId) {
        jpuppeteer.cdp.client.entity.page.Frame frameInfo = new jpuppeteer.cdp.client.entity.page.Frame(
                frameId, frameId(), null, null,
                null, null, null,
                null, null);
        return appendChild(frameInfo);
    }

    protected void setIsolate(ChromeIsolate isolate) {
        this.isolate = isolate;
    }

    protected jpuppeteer.cdp.client.entity.page.Frame frameInfo() {
        return frameInfo;
    }

    protected void setFrameInfo(jpuppeteer.cdp.client.entity.page.Frame frameInfo) {
        this.frameInfo = frameInfo;
    }

    private ChromeIsolate assertIsolateNotNull() {
        if (this.isolate == null) {
            throw new IllegalStateException("isolate not ready");
        }
        return isolate;
    }

    @Override
    protected void emitInternal(AbstractListener<PageEvent> listener, PageEvent event) {
        if (eventLoop().inEventLoop()) {
            listener.accept(event);
        } else {
            eventLoop().execute(() -> listener.accept(event));
        }
    }

    @Override
    public ChromePage page() {
        return page;
    }

    @Override
    public Frame parent() {
        return frameInfo != null && frameInfo.getParentId() != null ? page().getFrame(frameInfo.getParentId()) : null;
    }

    @Override
    public String frameId() {
        return frameInfo != null ? frameInfo.getId() : null;
    }

    @Override
    public String loaderId() {
        return frameInfo != null ? frameInfo.getLoaderId() : null;
    }

    @Override
    public String url() {
        if (frameInfo == null) {
            return null;
        }
        String url = frameInfo.getUrl();
        if (frameInfo.getUrlFragment() != null) {
            url += frameInfo.getUrlFragment();
        }
        return url;
    }

    @Override
    public XFuture<String> navigate(String url, String referer) {
        return page().connection().page.navigate(new NavigateRequest(url, referer, null, frameId(), null))
                .sync(o -> {
                    if (StringUtils.isNoneEmpty(o.getErrorText())) {
                        throw new RuntimeException(o.getErrorText());
                    } else {
                        return o.getLoaderId();
                    }
                });
    }

    @Override
    public XFuture<Isolate> createIsolate(String isolateName) {
        return page().connection().page.createIsolatedWorld(new CreateIsolatedWorldRequest(frameId(), isolateName, true))
                .sync(o -> new ChromeIsolate(this, o.getExecutionContextId(), isolateName, null));
    }

    @Override
    public String name() {
        return isolate.name();
    }

    @Override
    public Frame frame() {
        return this;
    }

    @Override
    public XFuture<BrowserObject> eval(EvaluateRequest request) {
        return assertIsolateNotNull().eval(request);
    }

    @Override
    public <R> XFuture<R> eval(EvaluateRequest request, Class<R> clazz) {
        return assertIsolateNotNull().eval(request, clazz);
    }

    @Override
    public <R> XFuture<R> eval(EvaluateRequest request, JavaType type) {
        return assertIsolateNotNull().eval(request, type);
    }

    @Override
    public XFuture<BrowserObject> eval(String expression, Integer timeout) {
        return assertIsolateNotNull().eval(expression, timeout);
    }

    @Override
    public <R> XFuture<R> eval(String expression, Integer timeout, Class<R> clazz) {
        return assertIsolateNotNull().eval(expression, timeout, clazz);
    }

    @Override
    public <R> XFuture<R> eval(String expression, Integer timeout, JavaType type) {
        return assertIsolateNotNull().eval(expression, timeout, type);
    }

    @Override
    public XFuture<BrowserObject> call(CallFunctionOnRequest request) {
        return assertIsolateNotNull().call(request);
    }

    @Override
    public <R> XFuture<R> call(CallFunctionOnRequest request, Class<R> clazz) {
        return assertIsolateNotNull().call(request, clazz);
    }

    @Override
    public <R> XFuture<R> call(CallFunctionOnRequest request, JavaType type) {
        return assertIsolateNotNull().call(request, type);
    }

    @Override
    public XFuture<BrowserObject> call(String declaration, String objectId, Object... args) {
        return assertIsolateNotNull().call(declaration, objectId, args);
    }

    @Override
    public <R> XFuture<R> call(String declaration, String objectId, Class<R> clazz, Object... args) {
        return assertIsolateNotNull().call(declaration, objectId, clazz, args);
    }

    @Override
    public <R> XFuture<R> call(String declaration, String objectId, JavaType type, Object... args) {
        return assertIsolateNotNull().call(declaration, objectId, type, args);
    }

    @Override
    public XFuture<BrowserObject> call(String declaration, Object... args) {
        return assertIsolateNotNull().call(declaration, args);
    }

    @Override
    public <R> XFuture<R> call(String declaration, Class<R> clazz, Object... args) {
        return assertIsolateNotNull().call(declaration, clazz, args);
    }

    @Override
    public <R> XFuture<R> call(String declaration, JavaType type, Object... args) {
        return assertIsolateNotNull().call(declaration, type, args);
    }

    @Override
    public XFuture<Element> querySelector(String selector) {
        return assertIsolateNotNull().call("function (selector){return document.querySelector(selector);}", (Object) selector)
                .sync(o -> o != null ? new ChromeElement(this, o) : null);
    }

    @Override
    public XFuture<Element[]> querySelectorAll(String selector) {
        return assertIsolateNotNull().call("function (selector){return document.querySelectorAll(selector);}", (Object) selector)
                .async(BrowserObject::getProperties)
                .sync(browserObjects -> {
                    Element[] elements = new Element[browserObjects.length];
                    for(int i=0; i<browserObjects.length; i++) {
                        elements[i] = new ChromeElement(ChromeFrame.this, browserObjects[i]);
                    }
                    return elements;
                });
    }

    @Override
    public XFuture<Element> waitSelector(String selector, long timeout, TimeUnit unit) {
        XPromise<Element> promise = new XPromise<>(eventLoop());
        WatchFunction watchFunction = (id, action, element) -> {
            if (action == WatchAction.SHOW) {
                unwatch(id).addListener(f -> {
                    if (!f.isSuccess()) {
                        logger.warn("unwatch failed, id={}", id, f.cause());
                    }
                });
                promise.trySuccess(element);
            }
        };
        watch(selector, watchFunction, timeout, unit).addListener(f -> {
            if (!f.isSuccess()) {
                promise.tryFailure(f.cause());
            }
        });
        return promise;
    }

    @Override
    public XFuture<String> watch(String selector, WatchFunction watchFunction, long timeout, TimeUnit unit) {
        String id = UUID.randomUUID().toString().replace("-", "");
        String watchFunctionName = WATCH_PREFIX + id;
        String unwatchFunctionName = UNWATCH_PREFIX + id;
        long timeoutMs = unit.toMillis(timeout);
        return addBinding(watchFunctionName, (isolate, jsonStr) -> {
                    try {
                        JsonNode json = JacksonUtil.INSTANCE.readTree(jsonStr);
                        String actionStr = json.get("action").asText();
                        WatchAction action = WatchAction.findByValue(actionStr);
                        String nodeId = json.get("nodeId").asText();
                        isolate.eval("window['" + nodeId + "']")
                                .addListener(f -> {
                                    if (f.cause() != null) {
                                        logger.error("query watch object failed, error={}", f.cause().getMessage(), f.cause());
                                    } else if (action == null) {
                                        logger.warn("unknown watch action:{}", actionStr);
                                    } else {
                                        watchFunction.onVisibilityChanged(id, action, new ChromeElement(this, (BrowserObject) f.getNow()));
                                    }
                                });
                    } catch (Exception e) {
                        logger.error("process watch binding call failed, error={}", e.getMessage(), e);
                    }
                })
                .async(o -> call(SCRIPT_WATCH, (Object)selector, watchFunctionName, unwatchFunctionName, timeoutMs))
                .sync(o -> id);
    }

    @Override
    public XFuture<?> unwatch(String id) {
        String watchFunctionName = WATCH_PREFIX + id;
        String unwatchFunctionName = UNWATCH_PREFIX + id;
        return assertIsolateNotNull().call(unwatchFunctionName)
                .async(o -> removeBinding(watchFunctionName));
    }

    @Override
    public XFuture<?> addBinding(String bindingName, BindingFunction function) {
        return page().addBinding0(null, bindingName, function);
    }

    @Override
    public XFuture<?> removeBinding(String bindingName) {
        return page().removeBinding0(bindingName);
    }

    @Override
    public XFuture<String> html() {
        return assertIsolateNotNull().eval("document.documentElement.outerHTML;", null, String.class);
    }

    @Override
    public XFuture<?> html(String html) {
        return assertIsolateNotNull().call("function (html){document.documentElement.outerHTML=html;}", (Object) html);
    }
}
