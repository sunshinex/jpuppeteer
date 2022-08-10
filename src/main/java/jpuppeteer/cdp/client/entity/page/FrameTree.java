package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Frame hierarchy.
*/
public class FrameTree {

    /**
    * Frame information for this tree item.
    */
    private jpuppeteer.cdp.client.entity.page.Frame frame;

    /**
    * Child frames.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.FrameTree> childFrames;

    public void setFrame (jpuppeteer.cdp.client.entity.page.Frame frame) {
        this.frame = frame;
    }

    public jpuppeteer.cdp.client.entity.page.Frame getFrame() {
        return this.frame;
    }

    public void setChildFrames (java.util.List<jpuppeteer.cdp.client.entity.page.FrameTree> childFrames) {
        this.childFrames = childFrames;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.FrameTree> getChildFrames() {
        return this.childFrames;
    }

    public FrameTree(jpuppeteer.cdp.client.entity.page.Frame frame, java.util.List<jpuppeteer.cdp.client.entity.page.FrameTree> childFrames) {
        this.frame = frame;
        this.childFrames = childFrames;
    }

    public FrameTree(jpuppeteer.cdp.client.entity.page.Frame frame) {
        this.frame = frame;
        this.childFrames = null;
    }

    public FrameTree() {
    }

}