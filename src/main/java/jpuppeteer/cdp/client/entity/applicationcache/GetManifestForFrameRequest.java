package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetManifestForFrameRequest {

    /**
    * Identifier of the frame containing document whose manifest is retrieved.
    */
    public final String frameId;

    public GetManifestForFrameRequest(String frameId) {
        this.frameId = frameId;
    }

}