package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum AttributionReportingIssueType implements jpuppeteer.cdp.client.CDPEnum {

    PERMISSIONPOLICYDISABLED("PermissionPolicyDisabled"),
    INVALIDATTRIBUTIONSOURCEEVENTID("InvalidAttributionSourceEventId"),
    INVALIDATTRIBUTIONDATA("InvalidAttributionData"),
    ATTRIBUTIONSOURCEUNTRUSTWORTHYORIGIN("AttributionSourceUntrustworthyOrigin"),
    ATTRIBUTIONUNTRUSTWORTHYORIGIN("AttributionUntrustworthyOrigin"),
    ;

    private String value;

    AttributionReportingIssueType(String value) {
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

    public static AttributionReportingIssueType findByValue(String value) {
        for(AttributionReportingIssueType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}