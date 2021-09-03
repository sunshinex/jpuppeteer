package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Frame hierarchy along with their cached resources.
*/
public class FrameResourceTree {

    /**
    * Frame information for this tree item.
    */
    public final jpuppeteer.cdp.client.entity.page.Frame frame;

    /**
    * Child frames.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.page.FrameResourceTree> childFrames;

    /**
    * Information about frame resources.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.page.FrameResource> resources;

    public FrameResourceTree(jpuppeteer.cdp.client.entity.page.Frame frame, java.util.List<jpuppeteer.cdp.client.entity.page.FrameResourceTree> childFrames, java.util.List<jpuppeteer.cdp.client.entity.page.FrameResource> resources) {
        this.frame = frame;
        this.childFrames = childFrames;
        this.resources = resources;
    }

    public FrameResourceTree(jpuppeteer.cdp.client.entity.page.Frame frame, java.util.List<jpuppeteer.cdp.client.entity.page.FrameResource> resources) {
        this.frame = frame;
        this.childFrames = null;
        this.resources = resources;
    }

}