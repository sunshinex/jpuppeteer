package jpuppeteer.cdp.client.entity.audits;

/**
* Details for issues around "Attribution Reporting API" usage. Explainer: https://github.com/WICG/conversion-measurement-api
* experimental
*/
public class AttributionReportingIssueDetails {

    /**
    */
    private jpuppeteer.cdp.client.constant.audits.AttributionReportingIssueType violationType;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedFrame frame;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    /**
    */
    private Integer violatingNodeId;

    /**
    */
    private String invalidParameter;

    public void setViolationType (jpuppeteer.cdp.client.constant.audits.AttributionReportingIssueType violationType) {
        this.violationType = violationType;
    }

    public jpuppeteer.cdp.client.constant.audits.AttributionReportingIssueType getViolationType() {
        return this.violationType;
    }

    public void setFrame (jpuppeteer.cdp.client.entity.audits.AffectedFrame frame) {
        this.frame = frame;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedFrame getFrame() {
        return this.frame;
    }

    public void setRequest (jpuppeteer.cdp.client.entity.audits.AffectedRequest request) {
        this.request = request;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedRequest getRequest() {
        return this.request;
    }

    public void setViolatingNodeId (Integer violatingNodeId) {
        this.violatingNodeId = violatingNodeId;
    }

    public Integer getViolatingNodeId() {
        return this.violatingNodeId;
    }

    public void setInvalidParameter (String invalidParameter) {
        this.invalidParameter = invalidParameter;
    }

    public String getInvalidParameter() {
        return this.invalidParameter;
    }

    public AttributionReportingIssueDetails(jpuppeteer.cdp.client.constant.audits.AttributionReportingIssueType violationType, jpuppeteer.cdp.client.entity.audits.AffectedFrame frame, jpuppeteer.cdp.client.entity.audits.AffectedRequest request, Integer violatingNodeId, String invalidParameter) {
        this.violationType = violationType;
        this.frame = frame;
        this.request = request;
        this.violatingNodeId = violatingNodeId;
        this.invalidParameter = invalidParameter;
    }

    public AttributionReportingIssueDetails(jpuppeteer.cdp.client.constant.audits.AttributionReportingIssueType violationType) {
        this.violationType = violationType;
        this.frame = null;
        this.request = null;
        this.violatingNodeId = null;
        this.invalidParameter = null;
    }

    public AttributionReportingIssueDetails() {
    }

}