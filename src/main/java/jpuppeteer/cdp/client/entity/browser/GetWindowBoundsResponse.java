package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetWindowBoundsResponse {

    /**
    * Bounds information of the window. When window state is 'minimized', the restored window position and size are returned.
    */
    private jpuppeteer.cdp.client.entity.browser.Bounds bounds;

    public void setBounds (jpuppeteer.cdp.client.entity.browser.Bounds bounds) {
        this.bounds = bounds;
    }

    public jpuppeteer.cdp.client.entity.browser.Bounds getBounds() {
        return this.bounds;
    }

    public GetWindowBoundsResponse(jpuppeteer.cdp.client.entity.browser.Bounds bounds) {
        this.bounds = bounds;
    }

    public GetWindowBoundsResponse() {
    }

}