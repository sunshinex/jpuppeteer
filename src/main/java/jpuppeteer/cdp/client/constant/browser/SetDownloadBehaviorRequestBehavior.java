package jpuppeteer.cdp.client.constant.browser;

/**
*/
public enum SetDownloadBehaviorRequestBehavior implements jpuppeteer.cdp.client.CDPEnum {

    DENY("deny"),
    ALLOW("allow"),
    ALLOWANDNAME("allowAndName"),
    DEFAULT("default"),
    ;

    private String value;

    SetDownloadBehaviorRequestBehavior(String value) {
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

    public static SetDownloadBehaviorRequestBehavior findByValue(String value) {
        for(SetDownloadBehaviorRequestBehavior val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}