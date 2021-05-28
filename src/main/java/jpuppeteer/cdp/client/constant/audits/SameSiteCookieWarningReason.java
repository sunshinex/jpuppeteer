package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum SameSiteCookieWarningReason implements jpuppeteer.cdp.client.CDPEnum {

    WARNSAMESITEUNSPECIFIEDCROSSSITECONTEXT("WarnSameSiteUnspecifiedCrossSiteContext"),
    WARNSAMESITENONEINSECURE("WarnSameSiteNoneInsecure"),
    WARNSAMESITEUNSPECIFIEDLAXALLOWUNSAFE("WarnSameSiteUnspecifiedLaxAllowUnsafe"),
    WARNSAMESITESTRICTLAXDOWNGRADESTRICT("WarnSameSiteStrictLaxDowngradeStrict"),
    WARNSAMESITESTRICTCROSSDOWNGRADESTRICT("WarnSameSiteStrictCrossDowngradeStrict"),
    WARNSAMESITESTRICTCROSSDOWNGRADELAX("WarnSameSiteStrictCrossDowngradeLax"),
    WARNSAMESITELAXCROSSDOWNGRADESTRICT("WarnSameSiteLaxCrossDowngradeStrict"),
    WARNSAMESITELAXCROSSDOWNGRADELAX("WarnSameSiteLaxCrossDowngradeLax"),
    ;

    private String value;

    SameSiteCookieWarningReason(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SameSiteCookieWarningReason findByValue(String value) {
        for(SameSiteCookieWarningReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}