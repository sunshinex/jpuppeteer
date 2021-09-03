package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetWindowBoundsResponse {

    /**
    * Bounds information of the window. When window state is 'minimized', the restored window position and size are returned.
    */
    public final jpuppeteer.cdp.client.entity.browser.Bounds bounds;

    public GetWindowBoundsResponse(jpuppeteer.cdp.client.entity.browser.Bounds bounds) {
        this.bounds = bounds;
    }

}