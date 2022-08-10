package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetCookiesRequest {

    /**
    * Cookies to be set.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies;

    public void setCookies (java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies) {
        this.cookies = cookies;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> getCookies() {
        return this.cookies;
    }

    public SetCookiesRequest(java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies) {
        this.cookies = cookies;
    }

    public SetCookiesRequest() {
    }

}