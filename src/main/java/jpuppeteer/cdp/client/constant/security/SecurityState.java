package jpuppeteer.cdp.client.constant.security;

/**
* The security level of a page or resource.
*/
public enum SecurityState implements jpuppeteer.cdp.client.CDPEnum {

    UNKNOWN("unknown"),
    NEUTRAL("neutral"),
    INSECURE("insecure"),
    SECURE("secure"),
    INFO("info"),
    INSECURE_BROKEN("insecure-broken"),
    ;

    private String value;

    SecurityState(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SecurityState findByValue(String value) {
        for(SecurityState val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}