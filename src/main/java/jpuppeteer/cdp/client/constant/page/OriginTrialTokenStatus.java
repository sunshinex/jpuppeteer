package jpuppeteer.cdp.client.constant.page;

/**
* Origin Trial(https://www.chromium.org/blink/origin-trials) support. Status for an Origin Trial token.
*/
public enum OriginTrialTokenStatus implements jpuppeteer.cdp.client.CDPEnum {

    SUCCESS("Success"),
    NOTSUPPORTED("NotSupported"),
    INSECURE("Insecure"),
    EXPIRED("Expired"),
    WRONGORIGIN("WrongOrigin"),
    INVALIDSIGNATURE("InvalidSignature"),
    MALFORMED("Malformed"),
    WRONGVERSION("WrongVersion"),
    FEATUREDISABLED("FeatureDisabled"),
    TOKENDISABLED("TokenDisabled"),
    FEATUREDISABLEDFORUSER("FeatureDisabledForUser"),
    ;

    private String value;

    OriginTrialTokenStatus(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static OriginTrialTokenStatus findByValue(String value) {
        for(OriginTrialTokenStatus val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}