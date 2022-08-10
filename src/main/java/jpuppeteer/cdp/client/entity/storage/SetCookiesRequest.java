package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class SetCookiesRequest {

    /**
    * Cookies to be set.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies;

    /**
    * Browser context to use when called on the browser endpoint.
    */
    private String browserContextId;

    public void setCookies (java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies) {
        this.cookies = cookies;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> getCookies() {
        return this.cookies;
    }

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

    public SetCookiesRequest(java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies, String browserContextId) {
        this.cookies = cookies;
        this.browserContextId = browserContextId;
    }

    public SetCookiesRequest(java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies) {
        this.cookies = cookies;
        this.browserContextId = null;
    }

    public SetCookiesRequest() {
    }

}