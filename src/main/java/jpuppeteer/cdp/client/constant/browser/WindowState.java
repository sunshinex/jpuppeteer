package jpuppeteer.cdp.client.constant.browser;

/**
* The state of the browser window.
*/
public enum WindowState implements jpuppeteer.cdp.client.CDPEnum {

    NORMAL("normal"),
    MINIMIZED("minimized"),
    MAXIMIZED("maximized"),
    FULLSCREEN("fullscreen"),
    ;

    private String value;

    WindowState(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static WindowState findByValue(String value) {
        for(WindowState val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}