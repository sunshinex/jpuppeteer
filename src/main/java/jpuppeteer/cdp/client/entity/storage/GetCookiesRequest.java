package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class GetCookiesRequest {

    /**
    * Browser context to use when called on the browser endpoint.
    */
    public final String browserContextId;

    public GetCookiesRequest(String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public GetCookiesRequest() {
        this.browserContextId = null;
    }

}