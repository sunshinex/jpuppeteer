package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetResourceContentRequest {

    /**
    * Frame id to get resource for.
    */
    public final String frameId;

    /**
    * URL of the resource to get content for.
    */
    public final String url;

    public GetResourceContentRequest(String frameId, String url) {
        this.frameId = frameId;
        this.url = url;
    }

}