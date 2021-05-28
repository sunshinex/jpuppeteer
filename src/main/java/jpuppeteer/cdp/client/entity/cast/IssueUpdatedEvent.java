package jpuppeteer.cdp.client.entity.cast;

/**
* This is fired whenever the outstanding issue/error message changes. |issueMessage| is empty if there is no issue.
* experimental
*/
public class IssueUpdatedEvent {

    /**
    */
    public final String issueMessage;

    public IssueUpdatedEvent(String issueMessage) {
        this.issueMessage = issueMessage;
    }

}