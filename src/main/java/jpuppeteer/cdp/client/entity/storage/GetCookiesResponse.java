package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
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