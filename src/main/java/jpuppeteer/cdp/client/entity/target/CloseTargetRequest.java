package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CloseTargetRequest {

    /**
    */
    private String targetId;

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public CloseTargetRequest(String targetId) {
        this.targetId = targetId;
    }

    public CloseTargetRequest() {
    }

}