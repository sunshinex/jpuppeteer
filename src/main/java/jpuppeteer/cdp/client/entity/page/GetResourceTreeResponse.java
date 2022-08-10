package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetResourceTreeResponse {

    /**
    * Present frame / resource tree structure.
    */
    private jpuppeteer.cdp.client.entity.page.FrameResourceTree frameTree;

    public void setFrameTree (jpuppeteer.cdp.client.entity.page.FrameResourceTree frameTree) {
        this.frameTree = frameTree;
    }

    public jpuppeteer.cdp.client.entity.page.FrameResourceTree getFrameTree() {
        return this.frameTree;
    }

    public GetResourceTreeResponse(jpuppeteer.cdp.client.entity.page.FrameResourceTree frameTree) {
        this.frameTree = frameTree;
    }

    public GetResourceTreeResponse() {
    }

}