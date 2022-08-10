package jpuppeteer.cdp.client.constant.page;

/**
* Status for an Origin Trial.
*/
public enum OriginTrialStatus implements jpuppeteer.cdp.client.CDPEnum {

    ENABLED("Enabled"),
    VALIDTOKENNOTPROVIDED("ValidTokenNotProvided"),
    OSNOTSUPPORTED("OSNotSupported"),
    TRIALNOTALLOWED("TrialNotAllowed"),
    ;

    private String value;

    OriginTrialStatus(String value) {
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

    public static OriginTrialStatus findByValue(String value) {
        for(OriginTrialStatus val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}