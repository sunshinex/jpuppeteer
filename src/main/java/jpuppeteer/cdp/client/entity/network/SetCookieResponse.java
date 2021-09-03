package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetCookieResponse {

    /**
    * Always set to true. If an error occurs, the response indicates protocol error.
    */
    public final Boolean success;

    public SetCookieResponse(Boolean success) {
        this.success = success;
    }

}