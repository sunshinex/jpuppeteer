package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetFrameTreeResponse {

    /**
    * Present frame tree structure.
    */
    public final FrameTree frameTree;

    public GetFrameTreeResponse(FrameTree frameTree) {
        this.frameTree = frameTree;
    }

}