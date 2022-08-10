package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowHitTestBordersRequest {

    /**
    * True for showing hit-test borders
    */
    private Boolean show;

    public void setShow (Boolean show) {
        this.show = show;
    }

    public Boolean getShow() {
        return this.show;
    }

    public SetShowHitTestBordersRequest(Boolean show) {
        this.show = show;
    }

    public SetShowHitTestBordersRequest() {
    }

}