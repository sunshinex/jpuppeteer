package jpuppeteer.cdp.client.constant.network;

/**
* Types of reasons why a cookie may not be sent with a request.
*/
public enum CookieBlockedReason implements jpuppeteer.cdp.client.CDPEnum {

    SECUREONLY("SecureOnly"),
    NOTONPATH("NotOnPath"),
    DOMAINMISMATCH("DomainMismatch"),
    SAMESITESTRICT("SameSiteStrict"),
    SAMESITELAX("SameSiteLax"),
    SAMESITEUNSPECIFIEDTREATEDASLAX("SameSiteUnspecifiedTreatedAsLax"),
    SAMESITENONEINSECURE("SameSiteNoneInsecure"),
    USERPREFERENCES("UserPreferences"),
    UNKNOWNERROR("UnknownError"),
    SCHEMEFULSAMESITESTRICT("SchemefulSameSiteStrict"),
    SCHEMEFULSAMESITELAX("SchemefulSameSiteLax"),
    SCHEMEFULSAMESITEUNSPECIFIEDTREATEDASLAX("SchemefulSameSiteUnspecifiedTreatedAsLax"),
    SAMEPARTYFROMCROSSPARTYCONTEXT("SamePartyFromCrossPartyContext"),
    ;

    private String value;

    CookieBlockedReason(String value) {
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

    public static CookieBlockedReason findByValue(String value) {
        for(CookieBlockedReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}