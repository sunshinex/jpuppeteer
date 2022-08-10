package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightSourceOrderRequest {

    /**
    * A descriptor for the appearance of the overlay drawing.
    */
    private jpuppeteer.cdp.client.entity.overlay.SourceOrderConfig sourceOrderConfig;

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

    public void setSourceOrderConfig (jpuppeteer.cdp.client.entity.overlay.SourceOrderConfig sourceOrderConfig) {
        this.sourceOrderConfig = sourceOrderConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.SourceOrderConfig getSourceOrderConfig() {
        return this.sourceOrderConfig;
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

    public HighlightSourceOrderRequest(jpuppeteer.cdp.client.entity.overlay.SourceOrderConfig sourceOrderConfig, Integer nodeId, Integer backendNodeId, String objectId) {
        this.sourceOrderConfig = sourceOrderConfig;
        this.nodeId = nodeId;
        this.backendNodeId = backendNodeId;
        this.objectId = objectId;
    }

    public HighlightSourceOrderRequest(jpuppeteer.cdp.client.entity.overlay.SourceOrderConfig sourceOrderConfig) {
        this.sourceOrderConfig = sourceOrderConfig;
        this.nodeId = null;
        this.backendNodeId = null;
        this.objectId = null;
    }

    public HighlightSourceOrderRequest() {
    }

}