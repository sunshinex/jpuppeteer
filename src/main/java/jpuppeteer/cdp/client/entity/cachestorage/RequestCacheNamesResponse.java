package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestCacheNamesResponse {

    /**
    * Caches for the security origin.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Cache> caches;

    public void setCaches (java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Cache> caches) {
        this.caches = caches;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Cache> getCaches() {
        return this.caches;
    }

    public RequestCacheNamesResponse(java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Cache> caches) {
        this.caches = caches;
    }

    public RequestCacheNamesResponse() {
    }

}