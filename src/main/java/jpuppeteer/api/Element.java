package jpuppeteer.api;

import jpuppeteer.cdp.client.entity.dom.BoxModel;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.util.XFuture;

import java.io.File;
import java.util.concurrent.TimeUnit;

public interface Element extends BrowserObject {

    Frame frame();

    XFuture<Element> querySelector(String selector);

    XFuture<Element[]> querySelectorAll(String selector);

    XFuture<Element> waitSelector(String selector, long timeout, TimeUnit unit);

    XFuture<String> watch(String selector, WatchFunction watchFunction, long timeout, TimeUnit unit);

    XFuture<?> unwatch(String id);

    XFuture<String> getAttribute(String name);

    XFuture<?> setAttribute(String name, String value);

    XFuture<?> removeAttribute(String name);

    XFuture<BoxModel> boxModel();

    XFuture<?> uploadFile(File... files);

    XFuture<?> focus();

    XFuture<?> remove();

    XFuture<?> scrollIntoView();

    XFuture<?> input(String text, int delay);

    default XFuture<?> input(String text) {
        return input(text, 30);
    }

    XFuture<?> select(String... values);

    //click
    XFuture<?> click(MouseDefinition buttonType, int delay);

    default XFuture<?> click() {
        return click(MouseDefinition.LEFT, 0);
    }

    //tap
    XFuture<?> tap(int delay);

    default XFuture<?> tap() {
        return tap(0);
    }

}
