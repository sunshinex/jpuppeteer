package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum FrameDetachedEventReason implements jpuppeteer.cdp.client.CDPEnum {

    REMOVE("remove"),
    SWAP("swap"),
    ;

    private String value;

    FrameDetachedEventReason(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static FrameDetachedEventReason findByValue(String value) {
        for(FrameDetachedEventReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}