package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowDebugBordersRequest {

    /**
    * True for showing debug borders
    */
    private Boolean show;

    public void setShow (Boolean show) {
        this.show = show;
    }

    public Boolean getShow() {
        return this.show;
    }

    public SetShowDebugBordersRequest(Boolean show) {
        this.show = show;
    }

    public SetShowDebugBordersRequest() {
    }

}