package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetFrameTreeResponse {

    /**
    * Present frame tree structure.
    */
    public final jpuppeteer.cdp.client.entity.page.FrameTree frameTree;

    public GetFrameTreeResponse(jpuppeteer.cdp.client.entity.page.FrameTree frameTree) {
        this.frameTree = frameTree;
    }

}