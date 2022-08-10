package jpuppeteer.cdp.client.entity.page;

/**
* Fired when the page with currently enabled screencast was shown or hidden `.
*/
public class ScreencastVisibilityChangedEvent {

    /**
    * True if the page is visible.
    */
    private Boolean visible;

    public void setVisible (Boolean visible) {
        this.visible = visible;
    }

    public Boolean getVisible() {
        return this.visible;
    }

    public ScreencastVisibilityChangedEvent(Boolean visible) {
        this.visible = visible;
    }

    public ScreencastVisibilityChangedEvent() {
    }

}