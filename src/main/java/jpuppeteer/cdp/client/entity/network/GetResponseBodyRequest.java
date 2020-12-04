package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetResponseBodyRequest {

    /**
    * Identifier of the network request to get content for.
    */
    public final String requestId;

    public GetResponseBodyRequest(String requestId) {
        this.requestId = requestId;
    }

}