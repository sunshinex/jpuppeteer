package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetCookiesRequest {

    /**
    * Cookies to be set.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies;

    public SetCookiesRequest(java.util.List<jpuppeteer.cdp.client.entity.network.CookieParam> cookies) {
        this.cookies = cookies;
    }

}