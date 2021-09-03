package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class IssueAddedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.InspectorIssue issue;

    public IssueAddedEvent(jpuppeteer.cdp.client.entity.audits.InspectorIssue issue) {
        this.issue = issue;
    }

}