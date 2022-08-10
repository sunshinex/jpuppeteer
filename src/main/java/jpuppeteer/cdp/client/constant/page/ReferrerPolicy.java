package jpuppeteer.cdp.client.constant.page;

/**
* The referring-policy used for the navigation.
*/
public enum ReferrerPolicy implements jpuppeteer.cdp.client.CDPEnum {

    NOREFERRER("noReferrer"),
    NOREFERRERWHENDOWNGRADE("noReferrerWhenDowngrade"),
    ORIGIN("origin"),
    ORIGINWHENCROSSORIGIN("originWhenCrossOrigin"),
    SAMEORIGIN("sameOrigin"),
    STRICTORIGIN("strictOrigin"),
    STRICTORIGINWHENCROSSORIGIN("strictOriginWhenCrossOrigin"),
    UNSAFEURL("unsafeUrl"),
    ;

    private String value;

    ReferrerPolicy(String value) {
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

    public static ReferrerPolicy findByValue(String value) {
        for(ReferrerPolicy val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}