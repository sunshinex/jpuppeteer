package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestCacheNamesResponse {

    /**
    * Caches for the security origin.
    */
    public final java.util.List<Cache> caches;

    public RequestCacheNamesResponse(java.util.List<Cache> caches) {
        this.caches = caches;
    }

}