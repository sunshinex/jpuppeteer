package jpuppeteer.cdp.cdp.constant.input;

/**
*/
public enum DispatchMouseEventRequestButton {

    NONE("none"),
    LEFT("left"),
    MIDDLE("middle"),
    RIGHT("right"),
    BACK("back"),
    FORWARD("forward"),
    ;

    private String value;

    DispatchMouseEventRequestButton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
}

    public static DispatchMouseEventRequestButton findByValue(String value) {
        for(DispatchMouseEventRequestButton val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}