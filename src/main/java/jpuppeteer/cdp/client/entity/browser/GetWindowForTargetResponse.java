package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetWindowForTargetResponse {

    /**
    * Browser window id.
    */
    private Integer windowId;

    /**
    * Bounds information of the window. When window state is 'minimized', the restored window position and size are returned.
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

    public GetWindowForTargetResponse(Integer windowId, jpuppeteer.cdp.client.entity.browser.Bounds bounds) {
        this.windowId = windowId;
        this.bounds = bounds;
    }

    public GetWindowForTargetResponse() {
    }

}