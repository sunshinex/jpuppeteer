package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame has been detached from its parent.
*/
public class FrameDetachedEvent {

    /**
    * Id of the frame that has been detached.
    */
    private String frameId;

    /**
    */
    private jpuppeteer.cdp.client.constant.page.FrameDetachedEventReason reason;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setReason (jpuppeteer.cdp.client.constant.page.FrameDetachedEventReason reason) {
        this.reason = reason;
    }

    public jpuppeteer.cdp.client.constant.page.FrameDetachedEventReason getReason() {
        return this.reason;
    }

    public FrameDetachedEvent(String frameId, jpuppeteer.cdp.client.constant.page.FrameDetachedEventReason reason) {
        this.frameId = frameId;
        this.reason = reason;
    }

    public FrameDetachedEvent() {
    }

}