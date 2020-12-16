package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.BrowserObject;
import jpuppeteer.api.Element;
import jpuppeteer.api.Isolate;
import jpuppeteer.api.Page;
import jpuppeteer.cdp.client.domain.DOM;
import jpuppeteer.cdp.client.domain.Runtime;
import jpuppeteer.cdp.client.entity.dom.*;
import jpuppeteer.cdp.client.entity.input.TouchPoint;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.entity.Coordinate;
import jpuppeteer.util.Input;
import jpuppeteer.util.ScriptUtil;
import jpuppeteer.util.SeriesFuture;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ChromeElement implements Element {

    private static final String SCRIPT_SELECT = ScriptUtil.load("script/select.js");

    private static final String SCRIPT_WAIT_SELECTOR = ScriptUtil.load("script/waitselector.js");

    private final Page page;

    private final DOM dom;

    private final Isolate isolate;

    private final Runtime runtime;

    private final Input input;

    private final BrowserObject object;

    private final EventExecutor executor;

    public ChromeElement(Page page, DOM dom, Isolate isolate, Runtime runtime, Input input, BrowserObject object, EventExecutor executor) {
        this.page = page;
        this.dom = dom;
        this.isolate = isolate;
        this.runtime = runtime;
        this.input = input;
        this.object = object;
        this.executor = executor;
    }

    @Override
    public Page page() {
        return page;
    }

    @Override
    public Future<Element> querySelector(String selector) {
        return SeriesFuture
                .wrap(isolate.call("function (selector){return this.querySelector(selector);}", objectId(), selector))
                .sync(o -> new ChromeElement(page, dom, isolate, runtime, input, o, executor));
    }

    @Override
    public Future<Element[]> querySelectorAll(String selector) {
        return SeriesFuture
                .wrap(isolate.call("function (selector){return this.querySelectorAll(selector);}", objectId(), selector))
                .async(BrowserObject::getProperties)
                .sync(o -> {
                    Element[] elements = new Element[o.length];
                    for(int i=0; i<o.length; i++) {
                        elements[i] = new ChromeElement(page, dom, isolate, runtime, input, o[i], executor);
                    }
                    return elements;
                });
    }

    @Override
    public Future<Element> waitSelector(String selector, long timeout, TimeUnit unit) {
        timeout = unit.toMillis(timeout);
        return SeriesFuture
                .wrap(isolate.call(SCRIPT_WAIT_SELECTOR, objectId(), (Object) selector, timeout))
                .sync(o -> new ChromeElement(page, dom, isolate, runtime, input, o, executor));
    }

    @Override
    public Future<String> getAttribute(String name) {
        return isolate.call("function (name){return this.getAttribute(name);}", objectId(), String.class, name);
    }

    @Override
    public Future setAttribute(String name, String value) {
        return isolate.call("function (name, value){this.setAttribute(name, value);}", objectId(), name, value);
    }

    @Override
    public Future removeAttribute(String name) {
        return isolate.call("function (name){this.removeAttribute(name);}", objectId(), name);
    }

    @Override
    public Future<BoxModel> boxModel() {
        return SeriesFuture
                .wrap(dom.getBoxModel(new GetBoxModelRequest(null, null, objectId())))
                .sync(o -> o.model);
    }

    @Override
    public Future uploadFile(File... files) {
        List<String> paths = Arrays.stream(files)
                .map(File::getAbsolutePath)
                .collect(Collectors.toList());
        SetFileInputFilesRequest request = new SetFileInputFilesRequest(paths, null, null, objectId());
        return dom.setFileInputFiles(request);
    }

    @Override
    public Future focus() {
        return dom.focus(new FocusRequest(null, null, objectId()));
    }

    @Override
    public Future remove() {
        return isolate.call("function (){this.parentNode.removeChild(this);}", objectId());
    }

    @Override
    public Future<String> value() {
        return isolate.call("function (){return this.value;}", objectId(), String.class);
    }

    @Override
    public Future value(String value) {
        return isolate.call("function (value){this.value=value;}", objectId(), value);
    }

    @Override
    public Future<String> html() {
        return SeriesFuture
                .wrap(dom.getOuterHTML(new GetOuterHTMLRequest(null, null, objectId())))
                .sync(o -> o.outerHTML);
    }

    @Override
    public Future html(String html) {
        return isolate.call("function (html){this.outerHTML=html;}", objectId(), html);
    }

    @Override
    public Future scrollIntoView() {
        return isolate.call("function (){this.scrollIntoViewIfNeeded();}", objectId());
    }

    @Override
    public Future clear() {
        return value(StringUtils.EMPTY);
    }

    @Override
    public Future input(String text, int delay) {
        SeriesFuture next = SeriesFuture.wrap(focus());
        for(char chr : text.toCharArray()) {
            String chrStr = String.valueOf(chr);
            USKeyboardDefinition def = USKeyboardDefinition.find(chrStr);
            if (def != null) {
                next = next.async(o -> input.press(def, 20));
            } else {
                next = next.async(o -> input.input(chrStr));
            }
        }
        return next;
    }

    @Override
    public Future select(String... values) {
        return isolate.call(SCRIPT_SELECT, objectId(), Lists.newArrayList(values));
    }

    private Future<Coordinate> center() {
        return SeriesFuture
                .wrap(scrollIntoView())//滚动到可见区域
                .async(o -> boxModel())
                .sync(o -> {
                    BoxModel boxModel = (BoxModel) o;
                    int left = boxModel.content.get(0).intValue();
                    int width = boxModel.content.get(2).intValue() - left;
                    int top = boxModel.content.get(1).intValue();
                    int height = boxModel.content.get(5).intValue() - top;
                    int x = left + (width / 2);
                    int y = top + (height / 2);
                    return new Coordinate(x, y);
                });
    }

    @Override
    public Future click(MouseDefinition buttonType, int delay) {
        return SeriesFuture
                .wrap(center())
                .async(o -> input.mouseMove(0, 0, o.x, o.y, Double.valueOf(Math.max(o.x / 20, o.y / 20)).intValue()))
                .async(o -> input.mouseDown(buttonType, o.x, o.y))
                .async(o -> executor.schedule(
                        () -> input.mouseUp(buttonType, o.x, o.y),
                        delay,
                        TimeUnit.MILLISECONDS
                ));
    }

    @Override
    public Future tap(int delay) {
        return SeriesFuture
                .wrap(center())
                .async(o -> input.touchStart(
                        new TouchPoint[]{
                                new TouchPoint(BigDecimal.valueOf(o.x), BigDecimal.valueOf(o.y))
                        }
                        )
                )
                .async(o -> executor.schedule(
                        () -> input.touchEnd(),
                        delay,
                        TimeUnit.MILLISECONDS
                ));
    }

    @Override
    public String objectId() {
        return object.objectId();
    }

    @Override
    public Isolate isolate() {
        return isolate;
    }

    @Override
    public Future<BrowserObject[]> getProperties() {
        return object.getProperties();
    }

    @Override
    public Future<BrowserObject> getProperty(String name) {
        return object.getProperty(name);
    }

    @Override
    public Future release() {
        return object.release();
    }
}
