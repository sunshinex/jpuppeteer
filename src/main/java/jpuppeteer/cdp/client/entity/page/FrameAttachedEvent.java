package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame has been attached to its parent.
*/
public class FrameAttachedEvent {

    /**
    * Id of the frame that has been attached.
    */
    private String frameId;

    /**
    * Parent frame identifier.
    */
    private String parentFrameId;

    /**
    * JavaScript stack trace of when frame was attached, only set if frame initiated from script.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace stack;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setParentFrameId (String parentFrameId) {
        this.parentFrameId = parentFrameId;
    }

    public String getParentFrameId() {
        return this.parentFrameId;
    }

    public void setStack (jpuppeteer.cdp.client.entity.runtime.StackTrace stack) {
        this.stack = stack;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getStack() {
        return this.stack;
    }

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

    public FrameAttachedEvent() {
    }

}