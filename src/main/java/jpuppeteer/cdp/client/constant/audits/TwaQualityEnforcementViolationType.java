package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum TwaQualityEnforcementViolationType implements jpuppeteer.cdp.client.CDPEnum {

    KHTTPERROR("kHttpError"),
    KUNAVAILABLEOFFLINE("kUnavailableOffline"),
    KDIGITALASSETLINKS("kDigitalAssetLinks"),
    ;

    private String value;

    TwaQualityEnforcementViolationType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static TwaQualityEnforcementViolationType findByValue(String value) {
        for(TwaQualityEnforcementViolationType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}