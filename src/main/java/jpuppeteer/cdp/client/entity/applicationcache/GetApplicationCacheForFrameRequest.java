package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetApplicationCacheForFrameRequest {

    /**
    * Identifier of the frame containing document whose application cache is retrieved.
    */
    public final String frameId;

    public GetApplicationCacheForFrameRequest(String frameId) {
        this.frameId = frameId;
    }

}