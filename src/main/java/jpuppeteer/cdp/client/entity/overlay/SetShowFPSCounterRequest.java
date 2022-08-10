package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowFPSCounterRequest {

    /**
    * True for showing the FPS counter
    */
    private Boolean show;

    public void setShow (Boolean show) {
        this.show = show;
    }

    public Boolean getShow() {
        return this.show;
    }

    public SetShowFPSCounterRequest(Boolean show) {
        this.show = show;
    }

    public SetShowFPSCounterRequest() {
    }

}