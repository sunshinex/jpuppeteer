package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetWindowBoundsRequest {

    /**
    * Browser window id.
    */
    private Integer windowId;

    /**
    * New window bounds. The 'minimized', 'maximized' and 'fullscreen' states cannot be combined with 'left', 'top', 'width' or 'height'. Leaves unspecified fields unchanged.
    */
    private jpuppeteer.cdp.client.entity.browser.Bounds bounds;

    public void setWindowId (Integer windowId) {
        this.windowId = windowId;
    }

    public Integer getWindowId() {
        return this.windowId;
    }

    public void setBounds (jpuppeteer.cdp.client.entity.browser.Bounds bounds) {
        this.bounds = bounds;
    }

    public jpuppeteer.cdp.client.entity.browser.Bounds getBounds() {
        return this.bounds;
    }

    public SetWindowBoundsRequest(Integer windowId, jpuppeteer.cdp.client.entity.browser.Bounds bounds) {
        this.windowId = windowId;
        this.bounds = bounds;
    }

    public SetWindowBoundsRequest() {
    }

}