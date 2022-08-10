package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightNodeRequest {

    /**
    * A descriptor for the highlight appearance.
    */
    private jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig;

    /**
    * Identifier of the node to highlight.
    */
    private Integer nodeId;

    /**
    * Identifier of the backend node to highlight.
    */
    private Integer backendNodeId;

    /**
    * JavaScript object id of the node to be highlighted.
    */
    private String objectId;

    /**
    * Selectors to highlight relevant nodes.
    */
    private String selector;

    public void setHighlightConfig (jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig) {
        this.highlightConfig = highlightConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.HighlightConfig getHighlightConfig() {
        return this.highlightConfig;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setSelector (String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return this.selector;
    }

    public HighlightNodeRequest(jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig, Integer nodeId, Integer backendNodeId, String objectId, String selector) {
        this.highlightConfig = highlightConfig;
        this.nodeId = nodeId;
        this.backendNodeId = backendNodeId;
        this.objectId = objectId;
        this.selector = selector;
    }

    public HighlightNodeRequest(jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig) {
        this.highlightConfig = highlightConfig;
        this.nodeId = null;
        this.backendNodeId = null;
        this.objectId = null;
        this.selector = null;
    }

    public HighlightNodeRequest() {
    }

}