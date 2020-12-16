package jpuppeteer.cdp.client.constant.input;

/**
*/
public enum DispatchMouseEventRequestType implements jpuppeteer.cdp.client.CDPEnum {

    MOUSEPRESSED("mousePressed"),
    MOUSERELEASED("mouseReleased"),
    MOUSEMOVED("mouseMoved"),
    MOUSEWHEEL("mouseWheel"),
    ;

    private String value;

    DispatchMouseEventRequestType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static DispatchMouseEventRequestType findByValue(String value) {
        for(DispatchMouseEventRequestType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}