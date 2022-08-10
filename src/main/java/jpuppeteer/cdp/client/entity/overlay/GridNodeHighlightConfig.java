package jpuppeteer.cdp.client.entity.overlay;

/**
* Configurations for Persistent Grid Highlight
* experimental
*/
public class GridNodeHighlightConfig {

    /**
    * A descriptor for the highlight appearance.
    */
    private jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig gridHighlightConfig;

    /**
    * Identifier of the node to highlight.
    */
    private Integer nodeId;

    public void setGridHighlightConfig (jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig gridHighlightConfig) {
        this.gridHighlightConfig = gridHighlightConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig getGridHighlightConfig() {
        return this.gridHighlightConfig;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GridNodeHighlightConfig(jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig gridHighlightConfig, Integer nodeId) {
        this.gridHighlightConfig = gridHighlightConfig;
        this.nodeId = nodeId;
    }

    public GridNodeHighlightConfig() {
    }

}