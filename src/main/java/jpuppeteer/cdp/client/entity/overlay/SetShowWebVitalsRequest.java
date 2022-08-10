package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowWebVitalsRequest {

    /**
    */
    private Boolean show;

    public void setShow (Boolean show) {
        this.show = show;
    }

    public Boolean getShow() {
        return this.show;
    }

    public SetShowWebVitalsRequest(Boolean show) {
        this.show = show;
    }

    public SetShowWebVitalsRequest() {
    }

}