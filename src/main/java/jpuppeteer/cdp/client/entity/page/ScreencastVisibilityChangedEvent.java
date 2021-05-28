package jpuppeteer.cdp.client.entity.page;

/**
* Fired when the page with currently enabled screencast was shown or hidden `.
*/
public class ScreencastVisibilityChangedEvent {

    /**
    * True if the page is visible.
    */
    public final Boolean visible;

    public ScreencastVisibilityChangedEvent(Boolean visible) {
        this.visible = visible;
    }

}