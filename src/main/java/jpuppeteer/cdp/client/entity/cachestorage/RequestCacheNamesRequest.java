package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestCacheNamesRequest {

    /**
    * Security origin.
    */
    public final String securityOrigin;

    public RequestCacheNamesRequest(String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

}