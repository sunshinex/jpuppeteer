package jpuppeteer.chrome;

import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.*;
import jpuppeteer.api.event.AbstractEventEmitter;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.page.PageEvent;
import jpuppeteer.cdp.client.entity.page.CreateIsolatedWorldRequest;
import jpuppeteer.cdp.client.entity.page.NavigateRequest;
import jpuppeteer.cdp.client.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.client.entity.runtime.EvaluateRequest;
import jpuppeteer.util.ScriptUtil;
import jpuppeteer.util.SeriesPromise;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ChromeFrame extends AbstractEventEmitter<PageEvent> implements Frame {

    private static final Logger logger = LoggerFactory.getLogger(ChromeFrame.class);

    private static final String SCRIPT_WAIT_SELECTOR = ScriptUtil.load("script/waitselector.js");

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
        return frameInfo != null && frameInfo.parentId != null ? page().getFrame(frameInfo.parentId) : null;
    }

    @Override
    public String frameId() {
        return frameInfo != null ? frameInfo.id : null;
    }

    @Override
    public String loaderId() {
        return frameInfo != null ? frameInfo.loaderId : null;
    }

    @Override
    public String url() {
        if (frameInfo == null) {
            return null;
        }
        String url = frameInfo.url;
        if (frameInfo.urlFragment != null) {
            url += frameInfo.urlFragment;
        }
        return url;
    }

    @Override
    public Future<String> navigate(String url, String referer) {
        return SeriesPromise
                .wrap(page().connection().page.navigate(new NavigateRequest(url, referer, null, frameId(), null)))
                .sync(o -> {
                    if (StringUtils.isNoneEmpty(o.errorText)) {
                        throw new RuntimeException(o.errorText);
                    } else {
                        return o.loaderId;
                    }
                });
    }

    @Override
    public Future<Isolate> createIsolate(String isolateName) {
        return SeriesPromise
                .wrap(page().connection().page.createIsolatedWorld(new CreateIsolatedWorldRequest(frameId(), isolateName, true)))
                .sync(o -> new ChromeIsolate(this, o.executionContextId, isolateName));
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
    public Future<BrowserObject> eval(EvaluateRequest request) {
        return assertIsolateNotNull().eval(request);
    }

    @Override
    public <R> Future<R> eval(EvaluateRequest request, Class<R> clazz) {
        return assertIsolateNotNull().eval(request, clazz);
    }

    @Override
    public Future<BrowserObject> eval(String expression, Integer timeout) {
        return assertIsolateNotNull().eval(expression, timeout);
    }

    @Override
    public <R> Future<R> eval(String expression, Integer timeout, Class<R> clazz) {
        return assertIsolateNotNull().eval(expression, timeout, clazz);
    }

    @Override
    public Future<BrowserObject> call(CallFunctionOnRequest request) {
        return assertIsolateNotNull().call(request);
    }

    @Override
    public <R> Future<R> call(CallFunctionOnRequest request, Class<R> clazz) {
        return assertIsolateNotNull().call(request, clazz);
    }

    @Override
    public Future<BrowserObject> call(String declaration, String objectId, Object... args) {
        return assertIsolateNotNull().call(declaration, objectId, args);
    }

    @Override
    public <R> Future<R> call(String declaration, String objectId, Class<R> clazz, Object... args) {
        return assertIsolateNotNull().call(declaration, objectId, clazz, args);
    }

    @Override
    public Future<BrowserObject> call(String declaration, Object... args) {
        return assertIsolateNotNull().call(declaration, args);
    }

    @Override
    public <R> Future<R> call(String declaration, Class<R> clazz, Object... args) {
        return assertIsolateNotNull().call(declaration, clazz, args);
    }

    @Override
    public Future<Element> querySelector(String selector) {
        return SeriesPromise
                .wrap(assertIsolateNotNull().call("function (selector){return document.querySelector(selector);}", (Object) selector))
                .sync(o -> o != null ? new ChromeElement(this, o) : null);
    }

    @Override
    public Future<Element[]> querySelectorAll(String selector) {
        return SeriesPromise
                .wrap(assertIsolateNotNull().call("function (selector){return document.querySelectorAll(selector);}", (Object) selector))
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
    public Future<Element> waitSelector(String selector, long timeout, TimeUnit unit) {
        timeout = unit.toMillis(timeout);
        return SeriesPromise
                .wrap(assertIsolateNotNull().call(SCRIPT_WAIT_SELECTOR, (Object) selector, timeout))
                .sync(o -> new ChromeElement(this, o));
    }

    @Override
    public Future watch(String selector, Consumer<Element> watchFunction, boolean once) {
        String functionName = "watch_" + UUID.randomUUID().toString().replace("-", "");
        return SeriesPromise.wrap(
                addBinding(functionName, (isolate, hash) -> {
                    isolate.eval("window['" + hash + "']")
                            .addListener(f -> {
                                if (f.cause() != null) {
                                    logger.error("query watch object failed, error={}", f.cause().getMessage(), f.cause());
                                } else {
                                    Element node = new ChromeElement(this, (BrowserObject) f.getNow());
                                    watchFunction.accept(node);
                                }
                            });
                }))
                .async(o -> call(SCRIPT_WATCH, (Object) selector, functionName, once));
    }

    @Override
    public Future addBinding(String bindingName, BindingFunction function) {
        return page().addBinding0(null, bindingName, function);
    }

    @Override
    public Future removeBinding(String bindingName) {
        return page().removeBinding0(bindingName);
    }

    @Override
    public Future<String> html() {
        return assertIsolateNotNull().eval("document.documentElement.outerHTML;", null, String.class);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Future html(String html) {
        return assertIsolateNotNull().call("function (html){document.documentElement.outerHTML=html;}", (Object) html);
    }
}
