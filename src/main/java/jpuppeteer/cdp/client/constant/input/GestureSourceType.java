package jpuppeteer.cdp.client.constant.input;

/**
*/
public enum GestureSourceType implements jpuppeteer.cdp.client.CDPEnum {

    DEFAULT("default"),
    TOUCH("touch"),
    MOUSE("mouse"),
    ;

    private String value;

    GestureSourceType(String value) {
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

    public static GestureSourceType findByValue(String value) {
        for(GestureSourceType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}