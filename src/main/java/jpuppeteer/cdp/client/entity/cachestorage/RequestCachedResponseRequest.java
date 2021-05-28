package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestCachedResponseRequest {

    /**
    * Id of cache that contains the entry.
    */
    public final String cacheId;

    /**
    * URL spec of the request.
    */
    public final String requestURL;

    /**
    * headers of the request.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> requestHeaders;

    public RequestCachedResponseRequest(String cacheId, String requestURL, java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> requestHeaders) {
        this.cacheId = cacheId;
        this.requestURL = requestURL;
        this.requestHeaders = requestHeaders;
    }

}