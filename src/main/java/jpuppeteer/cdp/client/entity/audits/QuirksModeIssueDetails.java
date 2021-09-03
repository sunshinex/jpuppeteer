package jpuppeteer.cdp.client.entity.audits;

/**
* Details for issues about documents in Quirks Mode or Limited Quirks Mode that affects page layouting.
* experimental
*/
public class QuirksModeIssueDetails {

    /**
    * If false, it means the document's mode is "quirks" instead of "limited-quirks".
    */
    public final Boolean isLimitedQuirksMode;

    /**
    */
    public final Integer documentNodeId;

    /**
    */
    public final String url;

    /**
    */
    public final String frameId;

    /**
    */
    public final String loaderId;

    public QuirksModeIssueDetails(Boolean isLimitedQuirksMode, Integer documentNodeId, String url, String frameId, String loaderId) {
        this.isLimitedQuirksMode = isLimitedQuirksMode;
        this.documentNodeId = documentNodeId;
        this.url = url;
        this.frameId = frameId;
        this.loaderId = loaderId;
    }

}