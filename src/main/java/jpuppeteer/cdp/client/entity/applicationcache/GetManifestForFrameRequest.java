package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetManifestForFrameRequest {

    /**
    * Identifier of the frame containing document whose manifest is retrieved.
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public GetManifestForFrameRequest(String frameId) {
        this.frameId = frameId;
    }

    public GetManifestForFrameRequest() {
    }

}