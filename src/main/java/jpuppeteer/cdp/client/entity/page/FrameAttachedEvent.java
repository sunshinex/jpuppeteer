package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame has been attached to its parent.
*/
public class FrameAttachedEvent {

    /**
    * Id of the frame that has been attached.
    */
    public final String frameId;

    /**
    * Parent frame identifier.
    */
    public final String parentFrameId;

    /**
    * JavaScript stack trace of when frame was attached, only set if frame initiated from script.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace stack;

    public FrameAttachedEvent(String frameId, String parentFrameId, jpuppeteer.cdp.client.entity.runtime.StackTrace stack) {
        this.frameId = frameId;
        this.parentFrameId = parentFrameId;
        this.stack = stack;
    }

    public FrameAttachedEvent(String frameId, String parentFrameId) {
        this.frameId = frameId;
        this.parentFrameId = parentFrameId;
        this.stack = null;
    }

}