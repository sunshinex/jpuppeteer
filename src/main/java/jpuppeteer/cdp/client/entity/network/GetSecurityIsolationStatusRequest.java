package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetSecurityIsolationStatusRequest {

    /**
    * If no frameId is provided, the status of the target is provided.
    */
    public final String frameId;

    public GetSecurityIsolationStatusRequest(String frameId) {
        this.frameId = frameId;
    }

    public GetSecurityIsolationStatusRequest() {
        this.frameId = null;
    }

}