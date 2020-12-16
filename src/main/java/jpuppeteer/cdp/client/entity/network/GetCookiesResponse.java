package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetCookiesResponse {

    /**
    * Array of cookie objects.
    */
    public final java.util.List<Cookie> cookies;

    public GetCookiesResponse(java.util.List<Cookie> cookies) {
        this.cookies = cookies;
    }

}