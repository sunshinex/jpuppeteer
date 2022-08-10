package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowViewportSizeOnResizeRequest {

    /**
    * Whether to paint size or not.
    */
    private Boolean show;

    public void setShow (Boolean show) {
        this.show = show;
    }

    public Boolean getShow() {
        return this.show;
    }

    public SetShowViewportSizeOnResizeRequest(Boolean show) {
        this.show = show;
    }

    public SetShowViewportSizeOnResizeRequest() {
    }

}