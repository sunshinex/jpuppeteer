package jpuppeteer.cdp.client.entity.page;

/**
* Fired once navigation of the frame has completed. Frame is now associated with the new loader.
*/
public class FrameNavigatedEvent {

    /**
    * Frame object.
    */
    private jpuppeteer.cdp.client.entity.page.Frame frame;

    /**
    */
    private jpuppeteer.cdp.client.constant.page.NavigationType type;

    public void setFrame (jpuppeteer.cdp.client.entity.page.Frame frame) {
        this.frame = frame;
    }

    public jpuppeteer.cdp.client.entity.page.Frame getFrame() {
        return this.frame;
    }

    public void setType (jpuppeteer.cdp.client.constant.page.NavigationType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.page.NavigationType getType() {
        return this.type;
    }

    public FrameNavigatedEvent(jpuppeteer.cdp.client.entity.page.Frame frame, jpuppeteer.cdp.client.constant.page.NavigationType type) {
        this.frame = frame;
        this.type = type;
    }

    public FrameNavigatedEvent() {
    }

}