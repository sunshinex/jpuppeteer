package jpuppeteer.cdp.client.constant.network;

/**
* Represents the cookie's 'SameSite' status: https://tools.ietf.org/html/draft-west-first-party-cookies
*/
public enum CookieSameSite implements jpuppeteer.cdp.client.CDPEnum {

    STRICT("Strict"),
    LAX("Lax"),
    NONE("None"),
    ;

    private String value;

    CookieSameSite(String value) {
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

    public static CookieSameSite findByValue(String value) {
        for(CookieSameSite val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}