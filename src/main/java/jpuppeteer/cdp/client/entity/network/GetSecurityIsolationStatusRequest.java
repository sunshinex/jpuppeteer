package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetSecurityIsolationStatusRequest {

    /**
    * If no frameId is provided, the status of the target is provided.
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public GetSecurityIsolationStatusRequest(String frameId) {
        this.frameId = frameId;
    }

    public GetSecurityIsolationStatusRequest() {
        this.frameId = null;
    }

}