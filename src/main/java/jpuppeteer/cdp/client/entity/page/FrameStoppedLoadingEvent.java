package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame has stopped loading.
*/
public class FrameStoppedLoadingEvent {

    /**
    * Id of the frame that has stopped loading.
    */
    public final String frameId;

    public FrameStoppedLoadingEvent(String frameId) {
        this.frameId = frameId;
    }

}