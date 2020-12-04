package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetCookiesRequest {

    /**
    * The list of URLs for which applicable cookies will be fetched
    */
    public final java.util.List<String> urls;

    public GetCookiesRequest(java.util.List<String> urls) {
        this.urls = urls;
    }

    public GetCookiesRequest() {
        this.urls = null;
    }

}