package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetAllCookiesResponse {

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

    public GetAllCookiesResponse(java.util.List<jpuppeteer.cdp.client.entity.network.Cookie> cookies) {
        this.cookies = cookies;
    }

    public GetAllCookiesResponse() {
    }

}