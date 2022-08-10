package jpuppeteer.cdp.client.entity.page;

/**
* Fired when opening document to write to.
*/
public class DocumentOpenedEvent {

    /**
    * Frame object.
    */
    private jpuppeteer.cdp.client.entity.page.Frame frame;

    public void setFrame (jpuppeteer.cdp.client.entity.page.Frame frame) {
        this.frame = frame;
    }

    public jpuppeteer.cdp.client.entity.page.Frame getFrame() {
        return this.frame;
    }

    public DocumentOpenedEvent(jpuppeteer.cdp.client.entity.page.Frame frame) {
        this.frame = frame;
    }

    public DocumentOpenedEvent() {
    }

}