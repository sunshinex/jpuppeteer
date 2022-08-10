package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetApplicationCacheForFrameResponse {

    /**
    * Relevant application cache data for the document in given frame.
    */
    private jpuppeteer.cdp.client.entity.applicationcache.ApplicationCache applicationCache;

    public void setApplicationCache (jpuppeteer.cdp.client.entity.applicationcache.ApplicationCache applicationCache) {
        this.applicationCache = applicationCache;
    }

    public jpuppeteer.cdp.client.entity.applicationcache.ApplicationCache getApplicationCache() {
        return this.applicationCache;
    }

    public GetApplicationCacheForFrameResponse(jpuppeteer.cdp.client.entity.applicationcache.ApplicationCache applicationCache) {
        this.applicationCache = applicationCache;
    }

    public GetApplicationCacheForFrameResponse() {
    }

}