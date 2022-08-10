package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class GetResponseBodyRequest {

    /**
    * Identifier for the intercepted request to get body for.
    */
    private String requestId;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetResponseBodyRequest(String requestId) {
        this.requestId = requestId;
    }

    public GetResponseBodyRequest() {
    }

}