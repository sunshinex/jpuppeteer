package jpuppeteer.cdp.client.entity.audits;

/**
* This struct holds a list of optional fields with additional information specific to the kind of issue. When adding a new issue code, please also add a new optional field to this type.
* experimental
*/
public class InspectorIssueDetails {

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.SameSiteCookieIssueDetails sameSiteCookieIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.MixedContentIssueDetails mixedContentIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.BlockedByResponseIssueDetails blockedByResponseIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.HeavyAdIssueDetails heavyAdIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.ContentSecurityPolicyIssueDetails contentSecurityPolicyIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.SharedArrayBufferIssueDetails sharedArrayBufferIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.TrustedWebActivityIssueDetails twaQualityEnforcementDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.LowTextContrastIssueDetails lowTextContrastIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.CorsIssueDetails corsIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.AttributionReportingIssueDetails attributionReportingIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.QuirksModeIssueDetails quirksModeIssueDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.NavigatorUserAgentIssueDetails navigatorUserAgentIssueDetails;

    public void setSameSiteCookieIssueDetails (jpuppeteer.cdp.client.entity.audits.SameSiteCookieIssueDetails sameSiteCookieIssueDetails) {
        this.sameSiteCookieIssueDetails = sameSiteCookieIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.SameSiteCookieIssueDetails getSameSiteCookieIssueDetails() {
        return this.sameSiteCookieIssueDetails;
    }

    public void setMixedContentIssueDetails (jpuppeteer.cdp.client.entity.audits.MixedContentIssueDetails mixedContentIssueDetails) {
        this.mixedContentIssueDetails = mixedContentIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.MixedContentIssueDetails getMixedContentIssueDetails() {
        return this.mixedContentIssueDetails;
    }

    public void setBlockedByResponseIssueDetails (jpuppeteer.cdp.client.entity.audits.BlockedByResponseIssueDetails blockedByResponseIssueDetails) {
        this.blockedByResponseIssueDetails = blockedByResponseIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.BlockedByResponseIssueDetails getBlockedByResponseIssueDetails() {
        return this.blockedByResponseIssueDetails;
    }

    public void setHeavyAdIssueDetails (jpuppeteer.cdp.client.entity.audits.HeavyAdIssueDetails heavyAdIssueDetails) {
        this.heavyAdIssueDetails = heavyAdIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.HeavyAdIssueDetails getHeavyAdIssueDetails() {
        return this.heavyAdIssueDetails;
    }

    public void setContentSecurityPolicyIssueDetails (jpuppeteer.cdp.client.entity.audits.ContentSecurityPolicyIssueDetails contentSecurityPolicyIssueDetails) {
        this.contentSecurityPolicyIssueDetails = contentSecurityPolicyIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.ContentSecurityPolicyIssueDetails getContentSecurityPolicyIssueDetails() {
        return this.contentSecurityPolicyIssueDetails;
    }

    public void setSharedArrayBufferIssueDetails (jpuppeteer.cdp.client.entity.audits.SharedArrayBufferIssueDetails sharedArrayBufferIssueDetails) {
        this.sharedArrayBufferIssueDetails = sharedArrayBufferIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.SharedArrayBufferIssueDetails getSharedArrayBufferIssueDetails() {
        return this.sharedArrayBufferIssueDetails;
    }

    public void setTwaQualityEnforcementDetails (jpuppeteer.cdp.client.entity.audits.TrustedWebActivityIssueDetails twaQualityEnforcementDetails) {
        this.twaQualityEnforcementDetails = twaQualityEnforcementDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.TrustedWebActivityIssueDetails getTwaQualityEnforcementDetails() {
        return this.twaQualityEnforcementDetails;
    }

    public void setLowTextContrastIssueDetails (jpuppeteer.cdp.client.entity.audits.LowTextContrastIssueDetails lowTextContrastIssueDetails) {
        this.lowTextContrastIssueDetails = lowTextContrastIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.LowTextContrastIssueDetails getLowTextContrastIssueDetails() {
        return this.lowTextContrastIssueDetails;
    }

    public void setCorsIssueDetails (jpuppeteer.cdp.client.entity.audits.CorsIssueDetails corsIssueDetails) {
        this.corsIssueDetails = corsIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.CorsIssueDetails getCorsIssueDetails() {
        return this.corsIssueDetails;
    }

    public void setAttributionReportingIssueDetails (jpuppeteer.cdp.client.entity.audits.AttributionReportingIssueDetails attributionReportingIssueDetails) {
        this.attributionReportingIssueDetails = attributionReportingIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.AttributionReportingIssueDetails getAttributionReportingIssueDetails() {
        return this.attributionReportingIssueDetails;
    }

    public void setQuirksModeIssueDetails (jpuppeteer.cdp.client.entity.audits.QuirksModeIssueDetails quirksModeIssueDetails) {
        this.quirksModeIssueDetails = quirksModeIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.QuirksModeIssueDetails getQuirksModeIssueDetails() {
        return this.quirksModeIssueDetails;
    }

    public void setNavigatorUserAgentIssueDetails (jpuppeteer.cdp.client.entity.audits.NavigatorUserAgentIssueDetails navigatorUserAgentIssueDetails) {
        this.navigatorUserAgentIssueDetails = navigatorUserAgentIssueDetails;
    }

    public jpuppeteer.cdp.client.entity.audits.NavigatorUserAgentIssueDetails getNavigatorUserAgentIssueDetails() {
        return this.navigatorUserAgentIssueDetails;
    }

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