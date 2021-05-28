package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum SameSiteCookieOperation implements jpuppeteer.cdp.client.CDPEnum {

    SETCOOKIE("SetCookie"),
    READCOOKIE("ReadCookie"),
    ;

    private String value;

    SameSiteCookieOperation(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SameSiteCookieOperation findByValue(String value) {
        for(SameSiteCookieOperation val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}