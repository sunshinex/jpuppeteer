package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CloseTargetResponse {

    /**
    * Always set to true. If an error occurs, the response indicates protocol error.
    */
    public final Boolean success;

    public CloseTargetResponse(Boolean success) {
        this.success = success;
    }

}