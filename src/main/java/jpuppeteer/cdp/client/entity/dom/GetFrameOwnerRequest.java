package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetFrameOwnerRequest {

    /**
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public GetFrameOwnerRequest(String frameId) {
        this.frameId = frameId;
    }

    public GetFrameOwnerRequest() {
    }

}