package jpuppeteer.cdp.client.constant.input;

/**
*/
public enum DispatchKeyEventRequestType implements jpuppeteer.cdp.client.CDPEnum {

    KEYDOWN("keyDown"),
    KEYUP("keyUp"),
    RAWKEYDOWN("rawKeyDown"),
    CHAR("char"),
    ;

    private String value;

    DispatchKeyEventRequestType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static DispatchKeyEventRequestType findByValue(String value) {
        for(DispatchKeyEventRequestType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}