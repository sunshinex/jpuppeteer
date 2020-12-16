package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class ClearCookiesRequest {

    /**
    * Browser context to use when called on the browser endpoint.
    */
    public final String browserContextId;

    public ClearCookiesRequest(String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public ClearCookiesRequest() {
        this.browserContextId = null;
    }

}