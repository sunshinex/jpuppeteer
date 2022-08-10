package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Frame hierarchy along with their cached resources.
*/
public class FrameResourceTree {

    /**
    * Frame information for this tree item.
    */
    private jpuppeteer.cdp.client.entity.page.Frame frame;

    /**
    * Child frames.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.FrameResourceTree> childFrames;

    /**
    * Information about frame resources.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.FrameResource> resources;

    public void setFrame (jpuppeteer.cdp.client.entity.page.Frame frame) {
        this.frame = frame;
    }

    public jpuppeteer.cdp.client.entity.page.Frame getFrame() {
        return this.frame;
    }

    public void setChildFrames (java.util.List<jpuppeteer.cdp.client.entity.page.FrameResourceTree> childFrames) {
        this.childFrames = childFrames;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.FrameResourceTree> getChildFrames() {
        return this.childFrames;
    }

    public void setResources (java.util.List<jpuppeteer.cdp.client.entity.page.FrameResource> resources) {
        this.resources = resources;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.FrameResource> getResources() {
        return this.resources;
    }

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

    public FrameResourceTree() {
    }

}