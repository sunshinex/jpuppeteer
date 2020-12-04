package jpuppeteer.cdp.client.entity.fetch;

/**
* experimental
*/
public class GetResponseBodyRequest {

    /**
    * Identifier for the intercepted request to get body for.
    */
    public final String requestId;

    public GetResponseBodyRequest(String requestId) {
        this.requestId = requestId;
    }

}