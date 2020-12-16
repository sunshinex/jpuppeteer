package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetApplicationCacheForFrameResponse {

    /**
    * Relevant application cache data for the document in given frame.
    */
    public final ApplicationCache applicationCache;

    public GetApplicationCacheForFrameResponse(ApplicationCache applicationCache) {
        this.applicationCache = applicationCache;
    }

}