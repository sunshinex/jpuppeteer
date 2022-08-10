package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetCookiesRequest {

    /**
    * The list of URLs for which applicable cookies will be fetched. If not specified, it's assumed to be set to the list containing the URLs of the page and all of its subframes.
    */
    private java.util.List<String> urls;

    public void setUrls (java.util.List<String> urls) {
        this.urls = urls;
    }

    public java.util.List<String> getUrls() {
        return this.urls;
    }

    public GetCookiesRequest(java.util.List<String> urls) {
        this.urls = urls;
    }

    public GetCookiesRequest() {
        this.urls = null;
    }

}