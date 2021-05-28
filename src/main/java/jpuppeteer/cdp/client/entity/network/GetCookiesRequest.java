package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetCookiesRequest {

    /**
    * The list of URLs for which applicable cookies will be fetched. If not specified, it's assumed to be set to the list containing the URLs of the page and all of its subframes.
    */
    public final java.util.List<String> urls;

    public GetCookiesRequest(java.util.List<String> urls) {
        this.urls = urls;
    }

    public GetCookiesRequest() {
        this.urls = null;
    }

}