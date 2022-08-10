package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetRequestPostDataRequest {

    /**
    * Identifier of the network request to get content for.
    */
    private String requestId;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetRequestPostDataRequest(String requestId) {
        this.requestId = requestId;
    }

    public GetRequestPostDataRequest() {
    }

}