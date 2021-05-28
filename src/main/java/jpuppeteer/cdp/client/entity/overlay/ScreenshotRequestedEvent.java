package jpuppeteer.cdp.client.entity.overlay;

/**
* Fired when user asks to capture screenshot of some area on the page.
* experimental
*/
public class ScreenshotRequestedEvent {

    /**
    * Viewport to capture, in device independent pixels (dip).
    */
    public final jpuppeteer.cdp.client.entity.page.Viewport viewport;

    public ScreenshotRequestedEvent(jpuppeteer.cdp.client.entity.page.Viewport viewport) {
        this.viewport = viewport;
    }

}