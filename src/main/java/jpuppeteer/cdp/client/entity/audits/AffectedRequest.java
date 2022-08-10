package jpuppeteer.cdp.client.entity.audits;

/**
* Information about a request that is affected by an inspector issue.
* experimental
*/
public class AffectedRequest {

    /**
    * The unique request id.
    */
    private String requestId;

    /**
    */
    private String url;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public AffectedRequest(String requestId, String url) {
        this.requestId = requestId;
        this.url = url;
    }

    public AffectedRequest(String requestId) {
        this.requestId = requestId;
        this.url = null;
    }

    public AffectedRequest() {
    }

}