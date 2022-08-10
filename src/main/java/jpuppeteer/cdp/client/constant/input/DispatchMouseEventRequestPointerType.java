package jpuppeteer.cdp.client.constant.input;

/**
*/
public enum DispatchMouseEventRequestPointerType implements jpuppeteer.cdp.client.CDPEnum {

    MOUSE("mouse"),
    PEN("pen"),
    ;

    private String value;

    DispatchMouseEventRequestPointerType(String value) {
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

    public static DispatchMouseEventRequestPointerType findByValue(String value) {
        for(DispatchMouseEventRequestPointerType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}