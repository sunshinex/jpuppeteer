package jpuppeteer.cdp.client.entity.audits;

/**
* Information about a request that is affected by an inspector issue.
* experimental
*/
public class AffectedRequest {

    /**
    * The unique request id.
    */
    public final String requestId;

    /**
    */
    public final String url;

    public AffectedRequest(String requestId, String url) {
        this.requestId = requestId;
        this.url = url;
    }

    public AffectedRequest(String requestId) {
        this.requestId = requestId;
        this.url = null;
    }

}