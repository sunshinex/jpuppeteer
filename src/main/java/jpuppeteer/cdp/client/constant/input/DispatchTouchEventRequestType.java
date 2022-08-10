package jpuppeteer.cdp.client.constant.input;

/**
*/
public enum DispatchTouchEventRequestType implements jpuppeteer.cdp.client.CDPEnum {

    TOUCHSTART("touchStart"),
    TOUCHEND("touchEnd"),
    TOUCHMOVE("touchMove"),
    TOUCHCANCEL("touchCancel"),
    ;

    private String value;

    DispatchTouchEventRequestType(String value) {
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

    public static DispatchTouchEventRequestType findByValue(String value) {
        for(DispatchTouchEventRequestType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}