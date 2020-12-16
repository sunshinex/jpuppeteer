package jpuppeteer.cdp.client.entity.page;

/**
* Fired once navigation of the frame has completed. Frame is now associated with the new loader.
*/
public class FrameNavigatedEvent {

    /**
    * Frame object.
    */
    public final Frame frame;

    public FrameNavigatedEvent(Frame frame) {
        this.frame = frame;
    }

}