package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class ContentSecurityPolicyIssueDetails {

    /**
    * The url not included in allowed sources.
    */
    public final String blockedURL;

    /**
    * Specific directive that is violated, causing the CSP issue.
    */
    public final String violatedDirective;

    /**
    */
    public final Boolean isReportOnly;

    /**
    */
    public final jpuppeteer.cdp.client.constant.audits.ContentSecurityPolicyViolationType contentSecurityPolicyViolationType;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedFrame frameAncestor;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.SourceCodeLocation sourceCodeLocation;

    /**
    */
    public final Integer violatingNodeId;

    public ContentSecurityPolicyIssueDetails(String blockedURL, String violatedDirective, Boolean isReportOnly, jpuppeteer.cdp.client.constant.audits.ContentSecurityPolicyViolationType contentSecurityPolicyViolationType, jpuppeteer.cdp.client.entity.audits.AffectedFrame frameAncestor, jpuppeteer.cdp.client.entity.audits.SourceCodeLocation sourceCodeLocation, Integer violatingNodeId) {
        this.blockedURL = blockedURL;
        this.violatedDirective = violatedDirective;
        this.isReportOnly = isReportOnly;
        this.contentSecurityPolicyViolationType = contentSecurityPolicyViolationType;
        this.frameAncestor = frameAncestor;
        this.sourceCodeLocation = sourceCodeLocation;
        this.violatingNodeId = violatingNodeId;
    }

    public ContentSecurityPolicyIssueDetails(String violatedDirective, Boolean isReportOnly, jpuppeteer.cdp.client.constant.audits.ContentSecurityPolicyViolationType contentSecurityPolicyViolationType) {
        this.blockedURL = null;
        this.violatedDirective = violatedDirective;
        this.isReportOnly = isReportOnly;
        this.contentSecurityPolicyViolationType = contentSecurityPolicyViolationType;
        this.frameAncestor = null;
        this.sourceCodeLocation = null;
        this.violatingNodeId = null;
    }

}