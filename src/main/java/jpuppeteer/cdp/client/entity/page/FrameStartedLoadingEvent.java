package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame has started loading.
*/
public class FrameStartedLoadingEvent {

    /**
    * Id of the frame that has started loading.
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public FrameStartedLoadingEvent(String frameId) {
        this.frameId = frameId;
    }

    public FrameStartedLoadingEvent() {
    }

}