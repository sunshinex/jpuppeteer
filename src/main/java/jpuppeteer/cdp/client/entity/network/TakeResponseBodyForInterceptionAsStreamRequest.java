package jpuppeteer.cdp.client.entity.network;

/**
*/
public class TakeResponseBodyForInterceptionAsStreamRequest {

    /**
    */
    private String interceptionId;

    public void setInterceptionId (String interceptionId) {
        this.interceptionId = interceptionId;
    }

    public String getInterceptionId() {
        return this.interceptionId;
    }

    public TakeResponseBodyForInterceptionAsStreamRequest(String interceptionId) {
        this.interceptionId = interceptionId;
    }

    public TakeResponseBodyForInterceptionAsStreamRequest() {
    }

}