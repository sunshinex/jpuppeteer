package jpuppeteer.api;

import jpuppeteer.cdp.client.entity.dom.BoxModel;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.util.XFuture;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public interface Element extends BrowserObject {

    Frame frame();

    XFuture<Element> querySelector(String selector);

    XFuture<Element[]> querySelectorAll(String selector);

    XFuture<Element> waitSelector(String selector, long timeout, TimeUnit unit);

    XFuture<?> watch(String selector, Consumer<Element> watchFunction, boolean once);

    default XFuture<?> watch(String selector, Consumer<Element> watchFunction) {
        return watch(selector, watchFunction, false);
    }

    XFuture<String> getAttribute(String name);

    XFuture<?> setAttribute(String name, String value);

    XFuture<?> removeAttribute(String name);

    XFuture<BoxModel> boxModel();

    XFuture<?> uploadFile(File... files);

    XFuture<?> focus();

    XFuture<?> remove();

    XFuture<String> value();

    XFuture<?> value(String value);

    XFuture<String> html();

    XFuture<?> html(String html);

    XFuture<?> scrollIntoView();

    XFuture<?> clear();

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
