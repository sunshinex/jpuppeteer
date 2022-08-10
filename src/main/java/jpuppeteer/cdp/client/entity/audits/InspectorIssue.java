package jpuppeteer.cdp.client.entity.audits;

/**
* An inspector issue reported from the back-end.
* experimental
*/
public class InspectorIssue {

    /**
    */
    private jpuppeteer.cdp.client.constant.audits.InspectorIssueCode code;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.InspectorIssueDetails details;

    public void setCode (jpuppeteer.cdp.client.constant.audits.InspectorIssueCode code) {
        this.code = code;
    }

    public jpuppeteer.cdp.client.constant.audits.InspectorIssueCode getCode() {
        return this.code;
    }

    public void setDetails (jpuppeteer.cdp.client.entity.audits.InspectorIssueDetails details) {
        this.details = details;
    }

    public jpuppeteer.cdp.client.entity.audits.InspectorIssueDetails getDetails() {
        return this.details;
    }

    public InspectorIssue(jpuppeteer.cdp.client.constant.audits.InspectorIssueCode code, jpuppeteer.cdp.client.entity.audits.InspectorIssueDetails details) {
        this.code = code;
        this.details = details;
    }

    public InspectorIssue() {
    }

}