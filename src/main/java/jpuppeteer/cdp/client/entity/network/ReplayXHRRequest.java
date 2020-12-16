package jpuppeteer.cdp.client.entity.network;

/**
*/
public class ReplayXHRRequest {

    /**
    * Identifier of XHR to replay.
    */
    public final String requestId;

    public ReplayXHRRequest(String requestId) {
        this.requestId = requestId;
    }

}