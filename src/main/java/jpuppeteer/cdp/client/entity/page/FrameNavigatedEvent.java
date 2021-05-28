package jpuppeteer.cdp.client.entity.page;

/**
* Fired once navigation of the frame has completed. Frame is now associated with the new loader.
*/
public class FrameNavigatedEvent {

    /**
    * Frame object.
    */
    public final jpuppeteer.cdp.client.entity.page.Frame frame;

    /**
    */
    public final jpuppeteer.cdp.client.constant.page.NavigationType type;

    public FrameNavigatedEvent(jpuppeteer.cdp.client.entity.page.Frame frame, jpuppeteer.cdp.client.constant.page.NavigationType type) {
        this.frame = frame;
        this.type = type;
    }

}