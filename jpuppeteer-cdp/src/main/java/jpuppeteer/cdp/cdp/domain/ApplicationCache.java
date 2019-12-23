package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class ApplicationCache {

    private jpuppeteer.cdp.CDPSession session;

    public ApplicationCache(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Enables application cache domain notifications.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("ApplicationCache.enable", null, timeout);
    }


    /**
    * Returns relevant application cache data for the document in given frame.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.applicationcache.GetApplicationCacheForFrameResponse getApplicationCacheForFrame(jpuppeteer.cdp.cdp.entity.applicationcache.GetApplicationCacheForFrameRequest request, int timeout) throws Exception {
        return session.send("ApplicationCache.getApplicationCacheForFrame", request, jpuppeteer.cdp.cdp.entity.applicationcache.GetApplicationCacheForFrameResponse.class, timeout);
    }


    /**
    * Returns array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.applicationcache.GetFramesWithManifestsResponse getFramesWithManifests(int timeout) throws Exception {
        return session.send("ApplicationCache.getFramesWithManifests", null, jpuppeteer.cdp.cdp.entity.applicationcache.GetFramesWithManifestsResponse.class, timeout);
    }


    /**
    * Returns manifest URL for document in the given frame.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.applicationcache.GetManifestForFrameResponse getManifestForFrame(jpuppeteer.cdp.cdp.entity.applicationcache.GetManifestForFrameRequest request, int timeout) throws Exception {
        return session.send("ApplicationCache.getManifestForFrame", request, jpuppeteer.cdp.cdp.entity.applicationcache.GetManifestForFrameResponse.class, timeout);
    }

}