package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetApplicationCacheForFrameResponse {

    /**
    * Relevant application cache data for the document in given frame.
    */
    public final jpuppeteer.cdp.client.entity.applicationcache.ApplicationCache applicationCache;

    public GetApplicationCacheForFrameResponse(jpuppeteer.cdp.client.entity.applicationcache.ApplicationCache applicationCache) {
        this.applicationCache = applicationCache;
    }

}