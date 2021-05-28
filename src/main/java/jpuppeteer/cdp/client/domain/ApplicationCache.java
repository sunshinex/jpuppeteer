package jpuppeteer.cdp.client.domain;

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
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("ApplicationCache.enable", null);
    }


    /**
    * Returns relevant application cache data for the document in given frame.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.applicationcache.GetApplicationCacheForFrameResponse> getApplicationCacheForFrame(jpuppeteer.cdp.client.entity.applicationcache.GetApplicationCacheForFrameRequest request) {
        return session.send("ApplicationCache.getApplicationCacheForFrame", request, jpuppeteer.cdp.client.entity.applicationcache.GetApplicationCacheForFrameResponse.class);
    }


    /**
    * Returns array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.applicationcache.GetFramesWithManifestsResponse> getFramesWithManifests() {
        return session.send("ApplicationCache.getFramesWithManifests", null, jpuppeteer.cdp.client.entity.applicationcache.GetFramesWithManifestsResponse.class);
    }


    /**
    * Returns manifest URL for document in the given frame.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.applicationcache.GetManifestForFrameResponse> getManifestForFrame(jpuppeteer.cdp.client.entity.applicationcache.GetManifestForFrameRequest request) {
        return session.send("ApplicationCache.getManifestForFrame", request, jpuppeteer.cdp.client.entity.applicationcache.GetManifestForFrameResponse.class);
    }

}