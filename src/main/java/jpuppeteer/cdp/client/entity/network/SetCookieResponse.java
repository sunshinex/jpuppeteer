package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetCookieResponse {

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

    public SetCookieResponse(Boolean success) {
        this.success = success;
    }

    public SetCookieResponse() {
    }

}