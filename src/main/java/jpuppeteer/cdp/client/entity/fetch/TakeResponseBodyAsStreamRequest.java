package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class TakeResponseBodyAsStreamRequest {

    /**
    */
    private String requestId;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public TakeResponseBodyAsStreamRequest(String requestId) {
        this.requestId = requestId;
    }

    public TakeResponseBodyAsStreamRequest() {
    }

}