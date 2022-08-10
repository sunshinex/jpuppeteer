package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CanClearBrowserCacheResponse {

    /**
    * True if browser cache can be cleared.
    */
    private Boolean result;

    public void setResult (Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return this.result;
    }

    public CanClearBrowserCacheResponse(Boolean result) {
        this.result = result;
    }

    public CanClearBrowserCacheResponse() {
    }

}