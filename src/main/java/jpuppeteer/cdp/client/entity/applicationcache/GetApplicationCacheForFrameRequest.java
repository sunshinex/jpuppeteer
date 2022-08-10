package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetApplicationCacheForFrameRequest {

    /**
    * Identifier of the frame containing document whose application cache is retrieved.
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public GetApplicationCacheForFrameRequest(String frameId) {
        this.frameId = frameId;
    }

    public GetApplicationCacheForFrameRequest() {
    }

}