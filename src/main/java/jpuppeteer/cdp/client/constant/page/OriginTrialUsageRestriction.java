package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum OriginTrialUsageRestriction implements jpuppeteer.cdp.client.CDPEnum {

    NONE("None"),
    SUBSET("Subset"),
    ;

    private String value;

    OriginTrialUsageRestriction(String value) {
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

    public static OriginTrialUsageRestriction findByValue(String value) {
        for(OriginTrialUsageRestriction val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}