package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Frame hierarchy.
*/
public class FrameTree {

    /**
    * Frame information for this tree item.
    */
    public final jpuppeteer.cdp.client.entity.page.Frame frame;

    /**
    * Child frames.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.page.FrameTree> childFrames;

    public FrameTree(jpuppeteer.cdp.client.entity.page.Frame frame, java.util.List<jpuppeteer.cdp.client.entity.page.FrameTree> childFrames) {
        this.frame = frame;
        this.childFrames = childFrames;
    }

    public FrameTree(jpuppeteer.cdp.client.entity.page.Frame frame) {
        this.frame = frame;
        this.childFrames = null;
    }

}