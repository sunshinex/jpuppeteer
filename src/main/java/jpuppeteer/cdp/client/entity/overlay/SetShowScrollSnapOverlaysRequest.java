package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowScrollSnapOverlaysRequest {

    /**
    * An array of node identifiers and descriptors for the highlight appearance.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.overlay.ScrollSnapHighlightConfig> scrollSnapHighlightConfigs;

    public void setScrollSnapHighlightConfigs (java.util.List<jpuppeteer.cdp.client.entity.overlay.ScrollSnapHighlightConfig> scrollSnapHighlightConfigs) {
        this.scrollSnapHighlightConfigs = scrollSnapHighlightConfigs;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.overlay.ScrollSnapHighlightConfig> getScrollSnapHighlightConfigs() {
        return this.scrollSnapHighlightConfigs;
    }

    public SetShowScrollSnapOverlaysRequest(java.util.List<jpuppeteer.cdp.client.entity.overlay.ScrollSnapHighlightConfig> scrollSnapHighlightConfigs) {
        this.scrollSnapHighlightConfigs = scrollSnapHighlightConfigs;
    }

    public SetShowScrollSnapOverlaysRequest() {
    }

}