package jpuppeteer.cdp.client.constant.network;

/**
* Represents the source scheme of the origin that originally set the cookie. A value of "Unset" allows protocol clients to emulate legacy cookie scope for the scheme. This is a temporary ability and it will be removed in the future.
*/
public enum CookieSourceScheme implements jpuppeteer.cdp.client.CDPEnum {

    UNSET("Unset"),
    NONSECURE("NonSecure"),
    SECURE("Secure"),
    ;

    private String value;

    CookieSourceScheme(String value) {
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

    public static CookieSourceScheme findByValue(String value) {
        for(CookieSourceScheme val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}