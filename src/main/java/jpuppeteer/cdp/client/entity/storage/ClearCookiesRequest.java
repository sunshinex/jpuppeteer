package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class ClearCookiesRequest {

    /**
    * Browser context to use when called on the browser endpoint.
    */
    private String browserContextId;

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

    public ClearCookiesRequest(String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public ClearCookiesRequest() {
        this.browserContextId = null;
    }

}