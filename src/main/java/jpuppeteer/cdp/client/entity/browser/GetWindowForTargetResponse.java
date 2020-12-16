package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetWindowForTargetResponse {

    /**
    * Browser window id.
    */
    public final Integer windowId;

    /**
    * Bounds information of the window. When window state is 'minimized', the restored window position and size are returned.
    */
    public final Bounds bounds;

    public GetWindowForTargetResponse(Integer windowId, Bounds bounds) {
        this.windowId = windowId;
        this.bounds = bounds;
    }

}