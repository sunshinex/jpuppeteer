package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class GetCookiesRequest {

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

    public GetCookiesRequest(String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public GetCookiesRequest() {
        this.browserContextId = null;
    }

}