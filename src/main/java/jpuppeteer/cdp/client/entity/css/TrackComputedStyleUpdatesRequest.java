package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class TrackComputedStyleUpdatesRequest {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> propertiesToTrack;

    public void setPropertiesToTrack (java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> propertiesToTrack) {
        this.propertiesToTrack = propertiesToTrack;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> getPropertiesToTrack() {
        return this.propertiesToTrack;
    }

    public TrackComputedStyleUpdatesRequest(java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> propertiesToTrack) {
        this.propertiesToTrack = propertiesToTrack;
    }

    public TrackComputedStyleUpdatesRequest() {
    }

}