package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestCachedResponseResponse {

    /**
    * Response read from the cache.
    */
    public final jpuppeteer.cdp.client.entity.cachestorage.CachedResponse response;

    public RequestCachedResponseResponse(jpuppeteer.cdp.client.entity.cachestorage.CachedResponse response) {
        this.response = response;
    }

}