package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetBlockedURLsRequest {

    /**
    * URL patterns to block. Wildcards ('*') are allowed.
    */
    public final java.util.List<String> urls;

    public SetBlockedURLsRequest(java.util.List<String> urls) {
        this.urls = urls;
    }

}