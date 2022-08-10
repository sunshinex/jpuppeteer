package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetFramesWithManifestsResponse {

    /**
    * Array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.applicationcache.FrameWithManifest> frameIds;

    public void setFrameIds (java.util.List<jpuppeteer.cdp.client.entity.applicationcache.FrameWithManifest> frameIds) {
        this.frameIds = frameIds;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.applicationcache.FrameWithManifest> getFrameIds() {
        return this.frameIds;
    }

    public GetFramesWithManifestsResponse(java.util.List<jpuppeteer.cdp.client.entity.applicationcache.FrameWithManifest> frameIds) {
        this.frameIds = frameIds;
    }

    public GetFramesWithManifestsResponse() {
    }

}