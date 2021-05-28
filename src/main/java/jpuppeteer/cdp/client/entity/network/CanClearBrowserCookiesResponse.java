package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CanClearBrowserCookiesResponse {

    /**
    * True if browser cookies can be cleared.
    */
    public final Boolean result;

    public CanClearBrowserCookiesResponse(Boolean result) {
        this.result = result;
    }

}