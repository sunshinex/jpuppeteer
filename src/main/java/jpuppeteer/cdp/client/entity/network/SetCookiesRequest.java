package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetCookiesRequest {

    /**
    * Cookies to be set.
    */
    public final java.util.List<CookieParam> cookies;

    public SetCookiesRequest(java.util.List<CookieParam> cookies) {
        this.cookies = cookies;
    }

}