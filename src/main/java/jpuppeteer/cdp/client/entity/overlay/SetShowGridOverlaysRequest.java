package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowGridOverlaysRequest {

    /**
    * An array of node identifiers and descriptors for the highlight appearance.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.overlay.GridNodeHighlightConfig> gridNodeHighlightConfigs;

    public SetShowGridOverlaysRequest(java.util.List<jpuppeteer.cdp.client.entity.overlay.GridNodeHighlightConfig> gridNodeHighlightConfigs) {
        this.gridNodeHighlightConfigs = gridNodeHighlightConfigs;
    }

}