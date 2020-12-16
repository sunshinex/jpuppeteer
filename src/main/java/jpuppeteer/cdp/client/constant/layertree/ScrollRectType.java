package jpuppeteer.cdp.client.constant.layertree;

/**
* experimental
*/
public enum ScrollRectType implements jpuppeteer.cdp.client.CDPEnum {

    REPAINTSONSCROLL("RepaintsOnScroll"),
    TOUCHEVENTHANDLER("TouchEventHandler"),
    WHEELEVENTHANDLER("WheelEventHandler"),
    ;

    private String value;

    ScrollRectType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ScrollRectType findByValue(String value) {
        for(ScrollRectType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}