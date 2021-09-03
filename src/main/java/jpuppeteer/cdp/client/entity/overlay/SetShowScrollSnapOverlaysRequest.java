package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowScrollSnapOverlaysRequest {

    /**
    * An array of node identifiers and descriptors for the highlight appearance.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.overlay.ScrollSnapHighlightConfig> scrollSnapHighlightConfigs;

    public SetShowScrollSnapOverlaysRequest(java.util.List<jpuppeteer.cdp.client.entity.overlay.ScrollSnapHighlightConfig> scrollSnapHighlightConfigs) {
        this.scrollSnapHighlightConfigs = scrollSnapHighlightConfigs;
    }

}