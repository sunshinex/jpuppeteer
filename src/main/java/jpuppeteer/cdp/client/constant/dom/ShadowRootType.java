package jpuppeteer.cdp.client.constant.dom;

/**
* Shadow root type.
*/
public enum ShadowRootType implements jpuppeteer.cdp.client.CDPEnum {

    USER_AGENT("user-agent"),
    OPEN("open"),
    CLOSED("closed"),
    ;

    private String value;

    ShadowRootType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ShadowRootType findByValue(String value) {
        for(ShadowRootType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}