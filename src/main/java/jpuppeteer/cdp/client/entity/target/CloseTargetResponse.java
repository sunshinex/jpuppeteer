package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CloseTargetResponse {

    /**
    * Always set to true. If an error occurs, the response indicates protocol error.
    */
    private Boolean success;

    public void setSuccess (Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public CloseTargetResponse(Boolean success) {
        this.success = success;
    }

    public CloseTargetResponse() {
    }

}