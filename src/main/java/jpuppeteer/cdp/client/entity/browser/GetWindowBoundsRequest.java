package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetWindowBoundsRequest {

    /**
    * Browser window id.
    */
    public final Integer windowId;

    public GetWindowBoundsRequest(Integer windowId) {
        this.windowId = windowId;
    }

}