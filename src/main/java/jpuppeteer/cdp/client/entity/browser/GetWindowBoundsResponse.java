package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetWindowBoundsResponse {

    /**
    * Bounds information of the window. When window state is 'minimized', the restored window position and size are returned.
    */
    public final Bounds bounds;

    public GetWindowBoundsResponse(Bounds bounds) {
        this.bounds = bounds;
    }

}