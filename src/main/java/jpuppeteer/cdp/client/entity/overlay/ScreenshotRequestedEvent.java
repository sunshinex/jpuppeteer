package jpuppeteer.cdp.client.entity.overlay;

/**
* Fired when user asks to capture screenshot of some area on the page.
* experimental
*/
public class ScreenshotRequestedEvent {

    /**
    * Viewport to capture, in device independent pixels (dip).
    */
    private jpuppeteer.cdp.client.entity.page.Viewport viewport;

    public void setViewport (jpuppeteer.cdp.client.entity.page.Viewport viewport) {
        this.viewport = viewport;
    }

    public jpuppeteer.cdp.client.entity.page.Viewport getViewport() {
        return this.viewport;
    }

    public ScreenshotRequestedEvent(jpuppeteer.cdp.client.entity.page.Viewport viewport) {
        this.viewport = viewport;
    }

    public ScreenshotRequestedEvent() {
    }

}