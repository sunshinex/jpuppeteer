package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetWindowBoundsRequest {

    /**
    * Browser window id.
    */
    public final Integer windowId;

    /**
    * New window bounds. The 'minimized', 'maximized' and 'fullscreen' states cannot be combined with 'left', 'top', 'width' or 'height'. Leaves unspecified fields unchanged.
    */
    public final Bounds bounds;

    public SetWindowBoundsRequest(Integer windowId, Bounds bounds) {
        this.windowId = windowId;
        this.bounds = bounds;
    }

}