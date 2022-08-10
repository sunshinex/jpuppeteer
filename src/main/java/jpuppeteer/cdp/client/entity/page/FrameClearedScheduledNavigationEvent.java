package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame no longer has a scheduled navigation.
*/
public class FrameClearedScheduledNavigationEvent {

    /**
    * Id of the frame that has cleared its scheduled navigation.
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public FrameClearedScheduledNavigationEvent(String frameId) {
        this.frameId = frameId;
    }

    public FrameClearedScheduledNavigationEvent() {
    }

}