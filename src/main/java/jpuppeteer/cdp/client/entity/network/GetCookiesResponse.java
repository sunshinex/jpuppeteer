package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetCookiesResponse {

    /**
    * Array of cookie objects.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.Cookie> cookies;

    public void setCookies (java.util.List<jpuppeteer.cdp.client.entity.network.Cookie> cookies) {
        this.cookies = cookies;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.Cookie> getCookies() {
        return this.cookies;
    }

    public GetCookiesResponse(java.util.List<jpuppeteer.cdp.client.entity.network.Cookie> cookies) {
        this.cookies = cookies;
    }

    public GetCookiesResponse() {
    }

}