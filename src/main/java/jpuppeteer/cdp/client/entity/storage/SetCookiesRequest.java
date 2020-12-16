package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class SetCookiesRequest {

    /**
    * Cookies to be set.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies;

    /**
    * Browser context to use when called on the browser endpoint.
    */
    public final String browserContextId;

    public SetCookiesRequest(java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies, String browserContextId) {
        this.cookies = cookies;
        this.browserContextId = browserContextId;
    }

    public SetCookiesRequest(java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies) {
        this.cookies = cookies;
        this.browserContextId = null;
    }

}