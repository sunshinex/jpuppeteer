package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum HeavyAdResolutionStatus implements jpuppeteer.cdp.client.CDPEnum {

    HEAVYADBLOCKED("HeavyAdBlocked"),
    HEAVYADWARNING("HeavyAdWarning"),
    ;

    private String value;

    HeavyAdResolutionStatus(String value) {
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

    public static HeavyAdResolutionStatus findByValue(String value) {
        for(HeavyAdResolutionStatus val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}