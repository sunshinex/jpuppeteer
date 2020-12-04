package jpuppeteer.chrome;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import jpuppeteer.api.BrowserObject;
import jpuppeteer.api.Element;
import jpuppeteer.api.Frame;
import jpuppeteer.api.Isolate;
import jpuppeteer.cdp.client.domain.DOM;
import jpuppeteer.cdp.client.domain.Page;
import jpuppeteer.cdp.client.domain.Runtime;
import jpuppeteer.cdp.client.entity.page.CreateIsolatedWorldRequest;
import jpuppeteer.cdp.client.entity.page.NavigateRequest;
import jpuppeteer.cdp.client.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.client.entity.runtime.EvaluateRequest;
import jpuppeteer.util.Input;
import jpuppeteer.util.SeriesFuture;
import org.apache.commons.lang3.StringUtils;

public class ChromeFrame implements Frame {

    private final ChromeFrame parent;

    private final String frameId;

    private final Page page;

    private final DOM dom;

    private final Runtime runtime;

    private final Input input;

    private final EventExecutor executor;

    private volatile Promise<ChromeIsolate> isolatePromise;

    public ChromeFrame(ChromeFrame parent, String frameId, Page page, DOM dom, Runtime runtime, Input input, EventExecutor executor) {
        this.parent = parent;
        this.frameId = frameId;
        this.page = page;
        this.dom = dom;
        this.runtime = runtime;
        this.input = input;
        this.executor = executor;
        this.isolatePromise = executor.newPromise();
    }

    public Page page() {
        return page;
    }

    public DOM dom() {
        return dom;
    }

    public Runtime runtime() {
        return runtime;
    }

    public Input input() {
        return input;
    }

    public EventExecutor executor() {
        return executor;
    }

    public void createIsolate(Integer isolateId, String isolateName) {
        ChromeIsolate isolate = new ChromeIsolate(runtime, isolateId, isolateName, this, executor);
        isolatePromise.trySuccess(isolate);
    }

    public void destroyIsolate() {
        Promise<ChromeIsolate> promise = this.isolatePromise;
        if (promise != null) {
            promise.tryFailure(new IllegalStateException("isolate destroyed"));
        }
        this.isolatePromise = executor.newPromise();
    }

    public ChromeFrame appendChild(String frameId) {
        return new ChromeFrame(this, frameId, page, dom, runtime, input, executor);
    }

    @Override
    public String frameId() {
        return frameId;
    }

    @Override
    public ChromeFrame parent() {
        return parent;
    }

    @Override
    public Future<String> title() {
        return eval("document.title", null, String.class);
    }

    @Override
    public Future<String> url() {
        return eval("location.href", null, String.class);
    }

    @Override
    public Future<String> navigate(String url, String referer) {
        return SeriesFuture
                .wrap(page.navigate(new NavigateRequest(url, referer, null, frameId)))
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
        return SeriesFuture
                .wrap(page.createIsolatedWorld(new CreateIsolatedWorldRequest(frameId, isolateName, true)))
                .sync(o -> new ChromeIsolate(runtime, o.executionContextId, isolateName, this, executor));
    }

    @Override
    public Frame frame() {
        return this;
    }

    @Override
    public Future<BrowserObject> eval(EvaluateRequest request) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.eval(request));
    }

    @Override
    public <R> Future<R> eval(EvaluateRequest request, Class<R> clazz) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.eval(request, clazz));
    }

    @Override
    public Future<BrowserObject> eval(String expression, Integer timeout) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.eval(expression, timeout));
    }

    @Override
    public <R> Future<R> eval(String expression, Integer timeout, Class<R> clazz) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.eval(expression, timeout, clazz));
    }

    @Override
    public Future<BrowserObject> call(CallFunctionOnRequest request) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.call(request));
    }

    @Override
    public <R> Future<R> call(CallFunctionOnRequest request, Class<R> clazz) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.call(request, clazz));
    }

    @Override
    public Future<BrowserObject> call(String declaration, String objectId, Object... args) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.call(declaration, objectId, args));
    }

    @Override
    public <R> Future<R> call(String declaration, String objectId, Class<R> clazz, Object... args) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.call(declaration, objectId, clazz, args));
    }

    @Override
    public Future<Element> querySelector(String selector) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.call("function (selector){return document.querySelector(selector);}", null, selector))
                .sync(o -> new ChromeElement(dom, isolatePromise.getNow(), runtime, input, o, executor));
    }

    @Override
    public Future<Element[]> querySelectorAll(String selector) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.call("function (selector){return document.querySelectorAll(selector);}", null, selector))
                .async(BrowserObject::getProperties)
                .sync(o -> {
                    Isolate isolate = isolatePromise.getNow();
                    Element[] elements = new Element[o.length];
                    for(int i=0; i<o.length; i++) {
                        elements[i] = new ChromeElement(dom, isolate, runtime, input, o[i], executor);
                    }
                    return elements;
                });
    }

    @Override
    public Future<String> html() {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.eval("document.documentElement.outerHTML;", null, String.class));
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Future html(String html) {
        return SeriesFuture
                .wrap(isolatePromise)
                .async(o -> o.call("function (html){document.documentElement.outerHTML=html;}", null, html));
    }

}
