package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetAllCookiesResponse {

    /**
    * Array of cookie objects.
    */
    public final java.util.List<Cookie> cookies;

    public GetAllCookiesResponse(java.util.List<Cookie> cookies) {
        this.cookies = cookies;
    }

}