package jpuppeteer.api.browser;

import jpuppeteer.api.constant.MediaType;
import jpuppeteer.api.constant.MouseDefinition;
import jpuppeteer.api.constant.USKeyboardDefinition;

import java.util.List;

public interface Page<T> extends Frame<T> {

    Page<T> opener();

    void setCookie(Cookie... cookies) throws Exception;

    void clearCookie() throws Exception;

    List<Cookie> cookies() throws Exception;

    //@TODO 暂不支持
    //void authenticate(String username, String password);

    void bringToFront() throws Exception;

    BrowserContext browserContext();

    void close();

    void emulateMedia(MediaType mediaType) throws Exception;

    String evaluateOnNewDocument(String script) throws Exception;

    void goBack() throws Exception;

    void goForward() throws Exception;

    boolean isClosed();

    void reload() throws Exception;

    void setByPassCSP(boolean enable) throws Exception;

    void setCacheEnable(boolean enable) throws Exception;

    void setExtraHTTPHeaders(Header... headers) throws Exception;

    void setGeolocation(double latitude, double longitude, int accuracy) throws Exception;

    //暂不支持, 后续支持
//    void setRequestInterceptionEnable(boolean enable);

    void setUserAgent(UserAgent userAgent) throws Exception;

    void setDevice(Device device) throws Exception;

    UserAgent userAgent();

    Device device();


    //mouse event
    void mouseDown(MouseDefinition mouseDefinition) throws Exception;

    default void mouseDown() throws Exception {
        mouseDown(MouseDefinition.LEFT);
    }

    void mouseUp(MouseDefinition mouseDefinition) throws Exception;

    default void mouseUp() throws Exception {
        mouseUp(MouseDefinition.LEFT);
    }

    void mouseMove(double x, double y, int steps) throws Exception;

    default void mouseMove(double x, double y) throws Exception {
        mouseMove(x, y, 1);
    }

    //keyboard event;
    void keyDown(USKeyboardDefinition key) throws Exception;

    void keyUp(USKeyboardDefinition key) throws Exception;

    void press(USKeyboardDefinition key, int delay) throws Exception;

    default void press(USKeyboardDefinition key) throws Exception {
        press(key, 0);
    }

    //touch event
    void touchStart(double x, double y) throws Exception;

    void touchEnd() throws Exception;

    void touchMove(double x, double y) throws Exception;

    void touchCancel() throws Exception;

}
