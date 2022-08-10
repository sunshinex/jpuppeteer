package jpuppeteer.cdp.client.entity.network;

/**
*/
public class ReplayXHRRequest {

    /**
    * Identifier of XHR to replay.
    */
    private String requestId;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public ReplayXHRRequest(String requestId) {
        this.requestId = requestId;
    }

    public ReplayXHRRequest() {
    }

}