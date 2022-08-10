package jpuppeteer.cdp.client.constant.page;

/**
* Indicates whether a frame has been identified as an ad.
*/
public enum AdFrameType implements jpuppeteer.cdp.client.CDPEnum {

    NONE("none"),
    CHILD("child"),
    ROOT("root"),
    ;

    private String value;

    AdFrameType(String value) {
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

    public static AdFrameType findByValue(String value) {
        for(AdFrameType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}