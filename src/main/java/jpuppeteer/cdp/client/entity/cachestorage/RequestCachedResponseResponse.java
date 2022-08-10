package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestCachedResponseResponse {

    /**
    * Response read from the cache.
    */
    private jpuppeteer.cdp.client.entity.cachestorage.CachedResponse response;

    public void setResponse (jpuppeteer.cdp.client.entity.cachestorage.CachedResponse response) {
        this.response = response;
    }

    public jpuppeteer.cdp.client.entity.cachestorage.CachedResponse getResponse() {
        return this.response;
    }

    public RequestCachedResponseResponse(jpuppeteer.cdp.client.entity.cachestorage.CachedResponse response) {
        this.response = response;
    }

    public RequestCachedResponseResponse() {
    }

}