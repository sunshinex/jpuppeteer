package jpuppeteer.cdp.client.entity.page;

/**
* Fired when opening document to write to.
*/
public class DocumentOpenedEvent {

    /**
    * Frame object.
    */
    public final jpuppeteer.cdp.client.entity.page.Frame frame;

    public DocumentOpenedEvent(jpuppeteer.cdp.client.entity.page.Frame frame) {
        this.frame = frame;
    }

}