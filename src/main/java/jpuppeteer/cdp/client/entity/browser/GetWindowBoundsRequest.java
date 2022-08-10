package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetWindowBoundsRequest {

    /**
    * Browser window id.
    */
    private Integer windowId;

    public void setWindowId (Integer windowId) {
        this.windowId = windowId;
    }

    public Integer getWindowId() {
        return this.windowId;
    }

    public GetWindowBoundsRequest(Integer windowId) {
        this.windowId = windowId;
    }

    public GetWindowBoundsRequest() {
    }

}