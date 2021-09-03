package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class TrackComputedStyleUpdatesRequest {

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> propertiesToTrack;

    public TrackComputedStyleUpdatesRequest(java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> propertiesToTrack) {
        this.propertiesToTrack = propertiesToTrack;
    }

}