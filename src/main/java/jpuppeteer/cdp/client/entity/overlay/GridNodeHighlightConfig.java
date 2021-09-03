package jpuppeteer.cdp.client.entity.overlay;

/**
* Configurations for Persistent Grid Highlight
* experimental
*/
public class GridNodeHighlightConfig {

    /**
    * A descriptor for the highlight appearance.
    */
    public final jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig gridHighlightConfig;

    /**
    * Identifier of the node to highlight.
    */
    public final Integer nodeId;

    public GridNodeHighlightConfig(jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig gridHighlightConfig, Integer nodeId) {
        this.gridHighlightConfig = gridHighlightConfig;
        this.nodeId = nodeId;
    }

}