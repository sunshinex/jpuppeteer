package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame has been detached from its parent.
*/
public class FrameDetachedEvent {

    /**
    * Id of the frame that has been detached.
    */
    public final String frameId;

    /**
    */
    public final jpuppeteer.cdp.client.constant.page.FrameDetachedEventReason reason;

    public FrameDetachedEvent(String frameId, jpuppeteer.cdp.client.constant.page.FrameDetachedEventReason reason) {
        this.frameId = frameId;
        this.reason = reason;
    }

}