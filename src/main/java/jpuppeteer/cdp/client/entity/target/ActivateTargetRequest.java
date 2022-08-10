package jpuppeteer.cdp.client.entity.target;

/**
*/
public class ActivateTargetRequest {

    /**
    */
    private String targetId;

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public ActivateTargetRequest(String targetId) {
        this.targetId = targetId;
    }

    public ActivateTargetRequest() {
    }

}