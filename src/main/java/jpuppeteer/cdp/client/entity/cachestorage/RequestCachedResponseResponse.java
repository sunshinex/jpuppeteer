package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestCachedResponseResponse {

    /**
    * Response read from the cache.
    */
    public final CachedResponse response;

    public RequestCachedResponseResponse(CachedResponse response) {
        this.response = response;
    }

}