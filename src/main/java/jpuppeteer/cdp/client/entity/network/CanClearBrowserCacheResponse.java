package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CanClearBrowserCacheResponse {

    /**
    * True if browser cache can be cleared.
    */
    public final Boolean result;

    public CanClearBrowserCacheResponse(Boolean result) {
        this.result = result;
    }

}