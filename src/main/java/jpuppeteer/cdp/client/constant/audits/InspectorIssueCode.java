package jpuppeteer.cdp.client.constant.audits;

/**
* A unique identifier for the type of issue. Each type may use one of the optional fields in InspectorIssueDetails to convey more specific information about the kind of issue.
* experimental
*/
public enum InspectorIssueCode implements jpuppeteer.cdp.client.CDPEnum {

    SAMESITECOOKIEISSUE("SameSiteCookieIssue"),
    MIXEDCONTENTISSUE("MixedContentIssue"),
    BLOCKEDBYRESPONSEISSUE("BlockedByResponseIssue"),
    HEAVYADISSUE("HeavyAdIssue"),
    CONTENTSECURITYPOLICYISSUE("ContentSecurityPolicyIssue"),
    SHAREDARRAYBUFFERISSUE("SharedArrayBufferIssue"),
    TRUSTEDWEBACTIVITYISSUE("TrustedWebActivityIssue"),
    LOWTEXTCONTRASTISSUE("LowTextContrastIssue"),
    CORSISSUE("CorsIssue"),
    ATTRIBUTIONREPORTINGISSUE("AttributionReportingIssue"),
    QUIRKSMODEISSUE("QuirksModeIssue"),
    NAVIGATORUSERAGENTISSUE("NavigatorUserAgentIssue"),
    ;

    private String value;

    InspectorIssueCode(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static InspectorIssueCode findByValue(String value) {
        for(InspectorIssueCode val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}