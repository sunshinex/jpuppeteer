package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame has been detached from its parent.
*/
public class FrameDetachedEvent {

    /**
    * Id of the frame that has been detached.
    */
    public final String frameId;

    public FrameDetachedEvent(String frameId) {
        this.frameId = frameId;
    }

}