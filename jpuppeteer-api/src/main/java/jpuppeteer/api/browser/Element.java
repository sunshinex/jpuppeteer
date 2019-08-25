package jpuppeteer.api.browser;

import jpuppeteer.api.constant.MouseDefinition;

import java.io.File;
import java.util.List;

public interface Element extends BrowserObject {

    Frame frame();

    Element querySelector(String selector) throws Exception;

    List<? extends Element> querySelectorAll(String selector) throws Exception;

    BoundingBox boundingBox() throws Exception;

    boolean isIntersectingViewport() throws Exception;

    BoxModel boxModel() throws Exception;

    void uploadFile(File... files) throws Exception;

    //dom event
    void focus() throws Exception;

    void hover() throws Exception;

    //mouse event
    void click(MouseDefinition buttonType, int delay) throws Exception;

    default void click() throws Exception {
        click(MouseDefinition.LEFT, 0);
    }

    //touchscreen event
    void tap(int delay) throws Exception;

    default void tap() throws Exception {
        tap(0);
    }

    //keyboard event
    void input(String text, int delay) throws Exception;

    //select event
    void select(String... values) throws Exception;
}
