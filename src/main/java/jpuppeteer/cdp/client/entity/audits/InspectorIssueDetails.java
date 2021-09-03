package jpuppeteer.cdp.client.entity.audits;

/**
* This struct holds a list of optional fields with additional information specific to the kind of issue. When adding a new issue code, please also add a new optional field to this type.
* experimental
*/
public class InspectorIssueDetails {

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.SameSiteCookieIssueDetails sameSiteCookieIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.MixedContentIssueDetails mixedContentIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.BlockedByResponseIssueDetails blockedByResponseIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.HeavyAdIssueDetails heavyAdIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.ContentSecurityPolicyIssueDetails contentSecurityPolicyIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.SharedArrayBufferIssueDetails sharedArrayBufferIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.TrustedWebActivityIssueDetails twaQualityEnforcementDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.LowTextContrastIssueDetails lowTextContrastIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.CorsIssueDetails corsIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.AttributionReportingIssueDetails attributionReportingIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.QuirksModeIssueDetails quirksModeIssueDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.NavigatorUserAgentIssueDetails navigatorUserAgentIssueDetails;

    public InspectorIssueDetails(jpuppeteer.cdp.client.entity.audits.SameSiteCookieIssueDetails sameSiteCookieIssueDetails, jpuppeteer.cdp.client.entity.audits.MixedContentIssueDetails mixedContentIssueDetails, jpuppeteer.cdp.client.entity.audits.BlockedByResponseIssueDetails blockedByResponseIssueDetails, jpuppeteer.cdp.client.entity.audits.HeavyAdIssueDetails heavyAdIssueDetails, jpuppeteer.cdp.client.entity.audits.ContentSecurityPolicyIssueDetails contentSecurityPolicyIssueDetails, jpuppeteer.cdp.client.entity.audits.SharedArrayBufferIssueDetails sharedArrayBufferIssueDetails, jpuppeteer.cdp.client.entity.audits.TrustedWebActivityIssueDetails twaQualityEnforcementDetails, jpuppeteer.cdp.client.entity.audits.LowTextContrastIssueDetails lowTextContrastIssueDetails, jpuppeteer.cdp.client.entity.audits.CorsIssueDetails corsIssueDetails, jpuppeteer.cdp.client.entity.audits.AttributionReportingIssueDetails attributionReportingIssueDetails, jpuppeteer.cdp.client.entity.audits.QuirksModeIssueDetails quirksModeIssueDetails, jpuppeteer.cdp.client.entity.audits.NavigatorUserAgentIssueDetails navigatorUserAgentIssueDetails) {
        this.sameSiteCookieIssueDetails = sameSiteCookieIssueDetails;
        this.mixedContentIssueDetails = mixedContentIssueDetails;
        this.blockedByResponseIssueDetails = blockedByResponseIssueDetails;
        this.heavyAdIssueDetails = heavyAdIssueDetails;
        this.contentSecurityPolicyIssueDetails = contentSecurityPolicyIssueDetails;
        this.sharedArrayBufferIssueDetails = sharedArrayBufferIssueDetails;
        this.twaQualityEnforcementDetails = twaQualityEnforcementDetails;
        this.lowTextContrastIssueDetails = lowTextContrastIssueDetails;
        this.corsIssueDetails = corsIssueDetails;
        this.attributionReportingIssueDetails = attributionReportingIssueDetails;
        this.quirksModeIssueDetails = quirksModeIssueDetails;
        this.navigatorUserAgentIssueDetails = navigatorUserAgentIssueDetails;
    }

    public InspectorIssueDetails() {
        this.sameSiteCookieIssueDetails = null;
        this.mixedContentIssueDetails = null;
        this.blockedByResponseIssueDetails = null;
        this.heavyAdIssueDetails = null;
        this.contentSecurityPolicyIssueDetails = null;
        this.sharedArrayBufferIssueDetails = null;
        this.twaQualityEnforcementDetails = null;
        this.lowTextContrastIssueDetails = null;
        this.corsIssueDetails = null;
        this.attributionReportingIssueDetails = null;
        this.quirksModeIssueDetails = null;
        this.navigatorUserAgentIssueDetails = null;
    }

}