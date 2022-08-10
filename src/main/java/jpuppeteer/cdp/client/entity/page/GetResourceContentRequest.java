package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetResourceContentRequest {

    /**
    * Frame id to get resource for.
    */
    private String frameId;

    /**
    * URL of the resource to get content for.
    */
    private String url;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public GetResourceContentRequest(String frameId, String url) {
        this.frameId = frameId;
        this.url = url;
    }

    public GetResourceContentRequest() {
    }

}