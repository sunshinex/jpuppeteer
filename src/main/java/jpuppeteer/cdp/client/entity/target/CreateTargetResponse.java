package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CreateTargetResponse {

    /**
    * The id of the page opened.
    */
    private String targetId;

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public CreateTargetResponse(String targetId) {
        this.targetId = targetId;
    }

    public CreateTargetResponse() {
    }

}