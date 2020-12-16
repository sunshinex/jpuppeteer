package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetRequestPostDataRequest {

    /**
    * Identifier of the network request to get content for.
    */
    public final String requestId;

    public GetRequestPostDataRequest(String requestId) {
        this.requestId = requestId;
    }

}