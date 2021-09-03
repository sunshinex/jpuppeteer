package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowFlexOverlaysRequest {

    /**
    * An array of node identifiers and descriptors for the highlight appearance.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.overlay.FlexNodeHighlightConfig> flexNodeHighlightConfigs;

    public SetShowFlexOverlaysRequest(java.util.List<jpuppeteer.cdp.client.entity.overlay.FlexNodeHighlightConfig> flexNodeHighlightConfigs) {
        this.flexNodeHighlightConfigs = flexNodeHighlightConfigs;
    }

}