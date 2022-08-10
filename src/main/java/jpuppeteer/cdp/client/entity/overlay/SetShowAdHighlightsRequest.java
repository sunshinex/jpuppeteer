package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowAdHighlightsRequest {

    /**
    * True for showing ad highlights
    */
    private Boolean show;

    public void setShow (Boolean show) {
        this.show = show;
    }

    public Boolean getShow() {
        return this.show;
    }

    public SetShowAdHighlightsRequest(Boolean show) {
        this.show = show;
    }

    public SetShowAdHighlightsRequest() {
    }

}