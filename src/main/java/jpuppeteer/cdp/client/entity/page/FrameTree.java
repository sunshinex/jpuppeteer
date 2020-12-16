package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Frame hierarchy.
*/
public class FrameTree {

    /**
    * Frame information for this tree item.
    */
    public final Frame frame;

    /**
    * Child frames.
    */
    public final java.util.List<FrameTree> childFrames;

    public FrameTree(Frame frame, java.util.List<FrameTree> childFrames) {
        this.frame = frame;
        this.childFrames = childFrames;
    }

    public FrameTree(Frame frame) {
        this.frame = frame;
        this.childFrames = null;
    }

}