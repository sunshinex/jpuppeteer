package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame has started loading.
*/
public class FrameStartedLoadingEvent {

    /**
    * Id of the frame that has started loading.
    */
    public final String frameId;

    public FrameStartedLoadingEvent(String frameId) {
        this.frameId = frameId;
    }

}