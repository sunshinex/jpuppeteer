package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class IssueAddedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.InspectorIssue issue;

    public void setIssue (jpuppeteer.cdp.client.entity.audits.InspectorIssue issue) {
        this.issue = issue;
    }

    public jpuppeteer.cdp.client.entity.audits.InspectorIssue getIssue() {
        return this.issue;
    }

    public IssueAddedEvent(jpuppeteer.cdp.client.entity.audits.InspectorIssue issue) {
        this.issue = issue;
    }

    public IssueAddedEvent() {
    }

}