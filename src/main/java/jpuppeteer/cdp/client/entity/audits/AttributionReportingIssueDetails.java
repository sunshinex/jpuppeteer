package jpuppeteer.cdp.client.entity.audits;

/**
* Details for issues around "Attribution Reporting API" usage. Explainer: https://github.com/WICG/conversion-measurement-api
* experimental
*/
public class AttributionReportingIssueDetails {

    /**
    */
    public final jpuppeteer.cdp.client.constant.audits.AttributionReportingIssueType violationType;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedFrame frame;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    /**
    */
    public final Integer violatingNodeId;

    /**
    */
    public final String invalidParameter;

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

}