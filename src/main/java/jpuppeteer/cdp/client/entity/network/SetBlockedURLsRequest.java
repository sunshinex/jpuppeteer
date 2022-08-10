package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetBlockedURLsRequest {

    /**
    * URL patterns to block. Wildcards ('*') are allowed.
    */
    private java.util.List<String> urls;

    public void setUrls (java.util.List<String> urls) {
        this.urls = urls;
    }

    public java.util.List<String> getUrls() {
        return this.urls;
    }

    public SetBlockedURLsRequest(java.util.List<String> urls) {
        this.urls = urls;
    }

    public SetBlockedURLsRequest() {
    }

}