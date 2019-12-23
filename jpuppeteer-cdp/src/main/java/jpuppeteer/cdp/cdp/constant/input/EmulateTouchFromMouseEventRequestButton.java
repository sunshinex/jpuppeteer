package jpuppeteer.cdp.cdp.constant.input;

/**
*/
public enum EmulateTouchFromMouseEventRequestButton {

    NONE("none"),
    LEFT("left"),
    MIDDLE("middle"),
    RIGHT("right"),
    ;

    private String value;

    EmulateTouchFromMouseEventRequestButton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
}

    public static EmulateTouchFromMouseEventRequestButton findByValue(String value) {
        for(EmulateTouchFromMouseEventRequestButton val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}