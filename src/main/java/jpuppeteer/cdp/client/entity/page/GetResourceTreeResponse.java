package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetResourceTreeResponse {

    /**
    * Present frame / resource tree structure.
    */
    public final jpuppeteer.cdp.client.entity.page.FrameResourceTree frameTree;

    public GetResourceTreeResponse(jpuppeteer.cdp.client.entity.page.FrameResourceTree frameTree) {
        this.frameTree = frameTree;
    }

}