package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowGridOverlaysRequest {

    /**
    * An array of node identifiers and descriptors for the highlight appearance.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.overlay.GridNodeHighlightConfig> gridNodeHighlightConfigs;

    public void setGridNodeHighlightConfigs (java.util.List<jpuppeteer.cdp.client.entity.overlay.GridNodeHighlightConfig> gridNodeHighlightConfigs) {
        this.gridNodeHighlightConfigs = gridNodeHighlightConfigs;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.overlay.GridNodeHighlightConfig> getGridNodeHighlightConfigs() {
        return this.gridNodeHighlightConfigs;
    }

    public SetShowGridOverlaysRequest(java.util.List<jpuppeteer.cdp.client.entity.overlay.GridNodeHighlightConfig> gridNodeHighlightConfigs) {
        this.gridNodeHighlightConfigs = gridNodeHighlightConfigs;
    }

    public SetShowGridOverlaysRequest() {
    }

}