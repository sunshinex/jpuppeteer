package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum MixedContentResolutionStatus implements jpuppeteer.cdp.client.CDPEnum {

    MIXEDCONTENTBLOCKED("MixedContentBlocked"),
    MIXEDCONTENTAUTOMATICALLYUPGRADED("MixedContentAutomaticallyUpgraded"),
    MIXEDCONTENTWARNING("MixedContentWarning"),
    ;

    private String value;

    MixedContentResolutionStatus(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static MixedContentResolutionStatus findByValue(String value) {
        for(MixedContentResolutionStatus val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}