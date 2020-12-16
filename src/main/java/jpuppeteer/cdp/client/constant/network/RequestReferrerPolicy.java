package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum RequestReferrerPolicy implements jpuppeteer.cdp.client.CDPEnum {

    UNSAFE_URL("unsafe-url"),
    NO_REFERRER_WHEN_DOWNGRADE("no-referrer-when-downgrade"),
    NO_REFERRER("no-referrer"),
    ORIGIN("origin"),
    ORIGIN_WHEN_CROSS_ORIGIN("origin-when-cross-origin"),
    SAME_ORIGIN("same-origin"),
    STRICT_ORIGIN("strict-origin"),
    STRICT_ORIGIN_WHEN_CROSS_ORIGIN("strict-origin-when-cross-origin"),
    ;

    private String value;

    RequestReferrerPolicy(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static RequestReferrerPolicy findByValue(String value) {
        for(RequestReferrerPolicy val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}