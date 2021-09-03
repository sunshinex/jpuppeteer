package jpuppeteer.cdp.client.constant.emulation;

/**
* Enum of image types that can be disabled.
*/
public enum DisabledImageType implements jpuppeteer.cdp.client.CDPEnum {

    AVIF("avif"),
    JXL("jxl"),
    WEBP("webp"),
    ;

    private String value;

    DisabledImageType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static DisabledImageType findByValue(String value) {
        for(DisabledImageType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}