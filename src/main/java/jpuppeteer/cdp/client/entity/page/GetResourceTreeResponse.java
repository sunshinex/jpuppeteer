package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetResourceTreeResponse {

    /**
    * Present frame / resource tree structure.
    */
    public final FrameResourceTree frameTree;

    public GetResourceTreeResponse(FrameResourceTree frameTree) {
        this.frameTree = frameTree;
    }

}