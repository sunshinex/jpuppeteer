package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class ContentSecurityPolicyIssueDetails {

    /**
    * The url not included in allowed sources.
    */
    private String blockedURL;

    /**
    * Specific directive that is violated, causing the CSP issue.
    */
    private String violatedDirective;

    /**
    */
    private Boolean isReportOnly;

    /**
    */
    private jpuppeteer.cdp.client.constant.audits.ContentSecurityPolicyViolationType contentSecurityPolicyViolationType;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedFrame frameAncestor;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.SourceCodeLocation sourceCodeLocation;

    /**
    */
    private Integer violatingNodeId;

    public void setBlockedURL (String blockedURL) {
        this.blockedURL = blockedURL;
    }

    public String getBlockedURL() {
        return this.blockedURL;
    }

    public void setViolatedDirective (String violatedDirective) {
        this.violatedDirective = violatedDirective;
    }

    public String getViolatedDirective() {
        return this.violatedDirective;
    }

    public void setIsReportOnly (Boolean isReportOnly) {
        this.isReportOnly = isReportOnly;
    }

    public Boolean getIsReportOnly() {
        return this.isReportOnly;
    }

    public void setContentSecurityPolicyViolationType (jpuppeteer.cdp.client.constant.audits.ContentSecurityPolicyViolationType contentSecurityPolicyViolationType) {
        this.contentSecurityPolicyViolationType = contentSecurityPolicyViolationType;
    }

    public jpuppeteer.cdp.client.constant.audits.ContentSecurityPolicyViolationType getContentSecurityPolicyViolationType() {
        return this.contentSecurityPolicyViolationType;
    }

    public void setFrameAncestor (jpuppeteer.cdp.client.entity.audits.AffectedFrame frameAncestor) {
        this.frameAncestor = frameAncestor;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedFrame getFrameAncestor() {
        return this.frameAncestor;
    }

    public void setSourceCodeLocation (jpuppeteer.cdp.client.entity.audits.SourceCodeLocation sourceCodeLocation) {
        this.sourceCodeLocation = sourceCodeLocation;
    }

    public jpuppeteer.cdp.client.entity.audits.SourceCodeLocation getSourceCodeLocation() {
        return this.sourceCodeLocation;
    }

    public void setViolatingNodeId (Integer violatingNodeId) {
        this.violatingNodeId = violatingNodeId;
    }

    public Integer getViolatingNodeId() {
        return this.violatingNodeId;
    }

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

    public ContentSecurityPolicyIssueDetails() {
    }

}