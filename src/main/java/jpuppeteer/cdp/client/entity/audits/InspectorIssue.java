package jpuppeteer.cdp.client.entity.audits;

/**
* An inspector issue reported from the back-end.
* experimental
*/
public class InspectorIssue {

    /**
    */
    public final jpuppeteer.cdp.client.constant.audits.InspectorIssueCode code;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.InspectorIssueDetails details;

    public InspectorIssue(jpuppeteer.cdp.client.constant.audits.InspectorIssueCode code, jpuppeteer.cdp.client.entity.audits.InspectorIssueDetails details) {
        this.code = code;
        this.details = details;
    }

}