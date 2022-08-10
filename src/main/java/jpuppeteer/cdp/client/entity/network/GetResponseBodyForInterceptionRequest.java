package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetResponseBodyForInterceptionRequest {

    /**
    * Identifier for the intercepted request to get body for.
    */
    private String interceptionId;

    public void setInterceptionId (String interceptionId) {
        this.interceptionId = interceptionId;
    }

    public String getInterceptionId() {
        return this.interceptionId;
    }

    public GetResponseBodyForInterceptionRequest(String interceptionId) {
        this.interceptionId = interceptionId;
    }

    public GetResponseBodyForInterceptionRequest() {
    }

}