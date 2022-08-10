package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetPermissionsPolicyStateRequest {

    /**
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public GetPermissionsPolicyStateRequest(String frameId) {
        this.frameId = frameId;
    }

    public GetPermissionsPolicyStateRequest() {
    }

}