package jpuppeteer.cdp.client.constant.dom;

/**
* Document compatibility mode.
*/
public enum CompatibilityMode implements jpuppeteer.cdp.client.CDPEnum {

    QUIRKSMODE("QuirksMode"),
    LIMITEDQUIRKSMODE("LimitedQuirksMode"),
    NOQUIRKSMODE("NoQuirksMode"),
    ;

    private String value;

    CompatibilityMode(String value) {
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

    public static CompatibilityMode findByValue(String value) {
        for(CompatibilityMode val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}