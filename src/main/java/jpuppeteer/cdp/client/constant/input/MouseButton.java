package jpuppeteer.cdp.client.constant.input;

/**
*/
public enum MouseButton implements jpuppeteer.cdp.client.CDPEnum {

    NONE("none"),
    LEFT("left"),
    MIDDLE("middle"),
    RIGHT("right"),
    BACK("back"),
    FORWARD("forward"),
    ;

    private String value;

    MouseButton(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static MouseButton findByValue(String value) {
        for(MouseButton val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}