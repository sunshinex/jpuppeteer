package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum SameSiteCookieExclusionReason implements jpuppeteer.cdp.client.CDPEnum {

    EXCLUDESAMESITEUNSPECIFIEDTREATEDASLAX("ExcludeSameSiteUnspecifiedTreatedAsLax"),
    EXCLUDESAMESITENONEINSECURE("ExcludeSameSiteNoneInsecure"),
    EXCLUDESAMESITELAX("ExcludeSameSiteLax"),
    EXCLUDESAMESITESTRICT("ExcludeSameSiteStrict"),
    EXCLUDEINVALIDSAMEPARTY("ExcludeInvalidSameParty"),
    ;

    private String value;

    SameSiteCookieExclusionReason(String value) {
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

    public static SameSiteCookieExclusionReason findByValue(String value) {
        for(SameSiteCookieExclusionReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}