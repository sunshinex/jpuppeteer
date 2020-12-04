package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetCookiesResponse {

    /**
    * Array of cookie objects.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.network.Cookie> cookies;

    public GetCookiesResponse(java.util.List<jpuppeteer.cdp.client.entity.network.Cookie> cookies) {
        this.cookies = cookies;
    }

}