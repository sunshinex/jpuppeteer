package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import jpuppeteer.api.BrowserObject;
import jpuppeteer.api.Element;
import jpuppeteer.api.Frame;
import jpuppeteer.api.Isolate;
import jpuppeteer.cdp.client.domain.DOM;
import jpuppeteer.cdp.client.entity.dom.*;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.entity.Point;
import jpuppeteer.util.Input;
import jpuppeteer.util.ScriptUtil;
import jpuppeteer.util.XFuture;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ChromeElement implements Element {

    private static final Logger logger = LoggerFactory.getLogger(ChromeElement.class);

    private static final String SCRIPT_SELECT = ScriptUtil.load("script/select.js");

    private static final String SCRIPT_WAIT_SELECTOR = ScriptUtil.load("script/waitselector.js");

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
        return frame.call("function (selector){return this.querySelector(selector);}", objectId(), selector)
                .sync(o -> o != null ? new ChromeElement(frame, o) : null);
    }

    @Override
    public XFuture<Element[]> querySelectorAll(String selector) {
        return frame.call("function (selector){return this.querySelectorAll(selector);}", (Object) selector)
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
        timeout = unit.toMillis(timeout);
        return frame.call(SCRIPT_WAIT_SELECTOR, objectId(), selector, timeout)
                .sync(o -> new ChromeElement(frame, o));
    }

    @Override
    public XFuture<?> watch(String selector, Consumer<Element> watchFunction, boolean once) {
        String functionName = "watch_" + UUID.randomUUID().toString().replace("-", "");
        return frame.addBinding(functionName, (i, hash) -> {
                    i.eval("window['" + hash + "']")
                            .addListener(f -> {
                                if (f.cause() != null) {
                                    logger.error("query watch object failed, error={}", f.cause().getMessage(), f.cause());
                                } else {
                                    Element node = new ChromeElement(frame, (BrowserObject) f.getNow());
                                    watchFunction.accept(node);
                                }
                            });
                })
                .async(o -> frame.call(SCRIPT_WATCH, objectId(), selector, functionName, once));
    }

    @Override
    public XFuture<String> getAttribute(String name) {
        return frame.call("function (name){return this.getAttribute(name);}", objectId(), String.class, name);
    }

    @Override
    public XFuture<?> setAttribute(String name, String value) {
        return frame.call("function (name, value){this.setAttribute(name, value);}", objectId(), name, value);
    }

    @Override
    public XFuture<?> removeAttribute(String name) {
        return frame.call("function (name){this.removeAttribute(name);}", objectId(), name);
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
        return frame.call("function (){this.parentNode.removeChild(this);}", objectId());
    }

    @Override
    public XFuture<String> value() {
        return frame.call("function (){return this.value;}", objectId(), String.class);
    }

    @Override
    public XFuture<?> value(String value) {
        return frame.call("function (value){this.value=value;}", objectId(), value);
    }

    @Override
    public XFuture<String> html() {
        return dom().getOuterHTML(new GetOuterHTMLRequest(null, null, objectId()))
                .sync(GetOuterHTMLResponse::getOuterHTML);
    }

    @Override
    public XFuture<?> html(String html) {
        return frame.call("function (html){this.outerHTML=html;}", objectId(), html);
    }

    @Override
    public XFuture<?> scrollIntoView() {
        return frame.call("function (){this.scrollIntoViewIfNeeded();}", objectId());
    }

    @Override
    public XFuture<?> clear() {
        return value(StringUtils.EMPTY);
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
        return frame.call(SCRIPT_SELECT, objectId(), Lists.newArrayList(values));
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
    public XFuture<BrowserObject> getProperty(String name) {
        return object.getProperty(name);
    }

    @Override
    public XFuture<?> release() {
        return object.release();
    }
}
