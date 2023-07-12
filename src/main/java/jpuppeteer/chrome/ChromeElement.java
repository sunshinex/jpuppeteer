package jpuppeteer.chrome;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import jpuppeteer.api.*;
import jpuppeteer.cdp.client.domain.DOM;
import jpuppeteer.cdp.client.entity.dom.*;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.constant.WatchAction;
import jpuppeteer.entity.Point;
import jpuppeteer.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static jpuppeteer.constant.WatchConsts.UNWATCH_PREFIX;
import static jpuppeteer.constant.WatchConsts.WATCH_PREFIX;

public class ChromeElement implements Element {

    private static final Logger logger = LoggerFactory.getLogger(ChromeElement.class);

    private static final String SCRIPT_SELECT = ScriptUtil.load("script/select.js");

    private static final String SCRIPT_WATCH = ScriptUtil.load("script/watch.js");

    private final ChromeFrame frame;

    private final BrowserObject object;

    public ChromeElement(ChromeFrame frame, BrowserObject object) {
        this.frame = frame;
        this.object = object;
    }

    protected DOM dom() {
        return this.frame.page().connection().dom;
    }

    protected Input input() {
        return this.frame.page().connection().inputWrapper;
    }

    @Override
    public Frame frame() {
        return frame;
    }

    @Override
    public XFuture<Element> querySelector(String selector) {
        return call("function (selector){return this.querySelector(selector);}", selector)
                .sync(o -> o != null ? new ChromeElement(frame, o) : null);
    }

    @Override
    public XFuture<Element[]> querySelectorAll(String selector) {
        return call("function (selector){return this.querySelectorAll(selector);}", selector)
                .async(BrowserObject::getProperties)
                .sync(browserObjects -> {
                    Element[] elements = new Element[browserObjects.length];
                    for(int i=0; i<browserObjects.length; i++) {
                        elements[i] = new ChromeElement(frame, browserObjects[i]);
                    }
                    return elements;
                });
    }

    @Override
    public XFuture<Element> waitSelector(String selector, long timeout, TimeUnit unit) {
        XPromise<Element> promise = new XPromise<>(frame.eventLoop());
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
        return frame().addBinding(watchFunctionName, (isolate, jsonStr) -> {
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
                                        watchFunction.onVisibilityChanged(id, action, new ChromeElement((ChromeFrame) frame(), (BrowserObject) f.getNow()));
                                    }
                                });
                    } catch (Exception e) {
                        logger.error("process watch binding call failed, error={}", e.getMessage(), e);
                    }
                })
                .async(o -> call(SCRIPT_WATCH, selector, watchFunctionName, unwatchFunctionName, timeoutMs))
                .sync(o -> id);
    }

    @Override
    public XFuture<?> unwatch(String id) {
        String watchFunctionName = WATCH_PREFIX + id;
        String unwatchFunctionName = UNWATCH_PREFIX + id;
        return call(unwatchFunctionName)
                .async(o -> frame().removeBinding(watchFunctionName));
    }

    @Override
    public XFuture<String> getAttribute(String name) {
        return call("function (name){return this.getAttribute(name);}", String.class, name);
    }

    @Override
    public XFuture<?> setAttribute(String name, String value) {
        return call("function (name, value){this.setAttribute(name, value);}", name, value);
    }

    @Override
    public XFuture<?> removeAttribute(String name) {
        return call("function (name){this.removeAttribute(name);}", name);
    }

    @Override
    public XFuture<BoxModel> boxModel() {
        return dom().getBoxModel(new GetBoxModelRequest(null, null, objectId()))
                .sync(GetBoxModelResponse::getModel);
    }

    @Override
    public XFuture<?> uploadFile(File... files) {
        List<String> paths = Arrays.stream(files)
                .map(File::getAbsolutePath)
                .collect(Collectors.toList());
        SetFileInputFilesRequest request = new SetFileInputFilesRequest(paths, null, null, objectId());
        return dom().setFileInputFiles(request);
    }

    @Override
    public XFuture<?> focus() {
        return dom().focus(new FocusRequest(null, null, objectId()));
    }

    @Override
    public XFuture<?> remove() {
        return call("function (){this.parentNode.removeChild(this);}");
    }

    @Override
    public XFuture<?> scrollIntoView() {
        return call("function (){this.scrollIntoViewIfNeeded();}");
    }

    @Override
    public XFuture<?> input(String text, int delay) {
        XFuture<?> next = focus();
        for(char chr : text.toCharArray()) {
            String chrStr = String.valueOf(chr);
            USKeyboardDefinition def = USKeyboardDefinition.find(chrStr);
            if (def != null) {
                next = next.async(o -> input().press(def, delay));
            } else {
                next = next.async(o -> input().input(chrStr));
            }
        }
        return next;
    }

    @Override
    public XFuture<?> select(String... values) {
        return call(SCRIPT_SELECT, Lists.newArrayList(values));
    }

    private XFuture<Point> center() {
        return scrollIntoView() //滚动到可见区域
                .async(o -> boxModel())
                .sync(o -> {
                    int left = o.getContent().get(0).intValue();
                    int top = o.getContent().get(1).intValue();
                    int x = left + (o.getWidth() / 2);
                    int y = top + (o.getHeight() / 2);
                    return new Point(x, y);
                });
    }

    @Override
    public XFuture<?> click(MouseDefinition buttonType, int delay) {
        return center()
                .async(o -> input().mouseMove(o.x, o.y))
                .async(o -> input().mouseDown(buttonType))
                //此处单纯为了延迟，没啥鸟用
                .async(o -> frame.eventLoop().schedule(() -> o, delay, TimeUnit.MILLISECONDS))
                .async(o -> input().mouseUp(buttonType));
    }

    @Override
    public XFuture<?> tap(int delay) {
        return center()
                .async(o -> input().touchStart(Double.valueOf(o.x).intValue(), Double.valueOf(o.y).intValue()))
                //此处单纯为了延迟，没啥鸟用
                .async(o -> frame.eventLoop().schedule(() -> o, delay, TimeUnit.MILLISECONDS))
                .async(o -> input().touchEnd());
    }

    @Override
    public String objectId() {
        return object.objectId();
    }

    @Override
    public Isolate isolate() {
        return frame;
    }

    @Override
    public XFuture<BrowserObject[]> getProperties() {
        return object.getProperties();
    }

    @Override
    public XFuture<?> setProperty(String name, Object value) {
        return object.setProperty(name, value);
    }

    @Override
    public XFuture<BrowserObject> getProperty(String name) {
        return object.getProperty(name);
    }

    @Override
    public <R> XFuture<R> getProperty(String name, Class<R> clazz) {
        return object.getProperty(name, clazz);
    }

    @Override
    public XFuture<?> release() {
        return object.release();
    }
}
