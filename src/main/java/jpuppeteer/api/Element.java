package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.cdp.client.entity.dom.BoxModel;
import jpuppeteer.constant.MouseDefinition;

import java.io.File;

public interface Element extends BrowserObject {

    Future<Element> querySelector(String selector);

    Future<Element[]> querySelectorAll(String selector);

    Future<Element> waitSelector(String selector, long timeout);

    Future setAttribute(String name, String value);

    Future removeAttribute(String name);

    Future<BoxModel> boxModel();

    Future uploadFile(File... files);

    Future focus();

    Future remove();

    Future<String> value();

    Future value(String value);

    Future<String> html();

    Future html(String html);

    Future scrollIntoView();

    Future clear();

    Future input(String text, int delay);

    default Future input(String text) {
        return input(text, 30);
    }

    Future select(String... values);

    //click
    Future click(MouseDefinition buttonType, int delay);

    default Future click() {
        return click(MouseDefinition.LEFT, 0);
    }

    //tap
    Future tap(int delay);

    default Future tap() {
        return tap(0);
    }

}
