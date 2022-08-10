package jpuppeteer.cdp.client.entity.target;

/**
*/
public class GetTargetInfoRequest {

    /**
    */
    private String targetId;

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public GetTargetInfoRequest(String targetId) {
        this.targetId = targetId;
    }

    public GetTargetInfoRequest() {
        this.targetId = null;
    }

}