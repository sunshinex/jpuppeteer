package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame has stopped loading.
*/
public class FrameStoppedLoadingEvent {

    /**
    * Id of the frame that has stopped loading.
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public FrameStoppedLoadingEvent(String frameId) {
        this.frameId = frameId;
    }

    public FrameStoppedLoadingEvent() {
    }

}