package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetFramesWithManifestsResponse {

    /**
    * Array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
    */
    public final java.util.List<FrameWithManifest> frameIds;

    public GetFramesWithManifestsResponse(java.util.List<FrameWithManifest> frameIds) {
        this.frameIds = frameIds;
    }

}