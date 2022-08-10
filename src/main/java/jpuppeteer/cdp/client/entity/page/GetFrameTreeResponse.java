package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetFrameTreeResponse {

    /**
    * Present frame tree structure.
    */
    private jpuppeteer.cdp.client.entity.page.FrameTree frameTree;

    public void setFrameTree (jpuppeteer.cdp.client.entity.page.FrameTree frameTree) {
        this.frameTree = frameTree;
    }

    public jpuppeteer.cdp.client.entity.page.FrameTree getFrameTree() {
        return this.frameTree;
    }

    public GetFrameTreeResponse(jpuppeteer.cdp.client.entity.page.FrameTree frameTree) {
        this.frameTree = frameTree;
    }

    public GetFrameTreeResponse() {
    }

}