package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetCookieResponse {

    /**
    * True if successfully set cookie.
    */
    public final Boolean success;

    public SetCookieResponse(Boolean success) {
        this.success = success;
    }

}