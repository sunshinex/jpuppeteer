package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CreateTargetResponse {

    /**
    * The id of the page opened.
    */
    public final String targetId;

    public CreateTargetResponse(String targetId) {
        this.targetId = targetId;
    }

}