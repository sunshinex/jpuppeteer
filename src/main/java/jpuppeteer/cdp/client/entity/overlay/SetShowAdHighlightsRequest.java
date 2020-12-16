package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowAdHighlightsRequest {

    /**
    * True for showing ad highlights
    */
    public final Boolean show;

    public SetShowAdHighlightsRequest(Boolean show) {
        this.show = show;
    }

}