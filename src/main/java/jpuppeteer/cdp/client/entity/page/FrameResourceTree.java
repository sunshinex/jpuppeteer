package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Frame hierarchy along with their cached resources.
*/
public class FrameResourceTree {

    /**
    * Frame information for this tree item.
    */
    public final Frame frame;

    /**
    * Child frames.
    */
    public final java.util.List<FrameResourceTree> childFrames;

    /**
    * Information about frame resources.
    */
    public final java.util.List<FrameResource> resources;

    public FrameResourceTree(Frame frame, java.util.List<FrameResourceTree> childFrames, java.util.List<FrameResource> resources) {
        this.frame = frame;
        this.childFrames = childFrames;
        this.resources = resources;
    }

    public FrameResourceTree(Frame frame, java.util.List<FrameResource> resources) {
        this.frame = frame;
        this.childFrames = null;
        this.resources = resources;
    }

}