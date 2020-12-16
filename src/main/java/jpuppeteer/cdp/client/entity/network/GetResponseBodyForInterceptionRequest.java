package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetResponseBodyForInterceptionRequest {

    /**
    * Identifier for the intercepted request to get body for.
    */
    public final String interceptionId;

    public GetResponseBodyForInterceptionRequest(String interceptionId) {
        this.interceptionId = interceptionId;
    }

}