package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetFramesWithManifestsResponse {

    /**
    * Array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.applicationcache.FrameWithManifest> frameIds;

    public GetFramesWithManifestsResponse(java.util.List<jpuppeteer.cdp.client.entity.applicationcache.FrameWithManifest> frameIds) {
        this.frameIds = frameIds;
    }

}