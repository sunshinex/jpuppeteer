package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightSourceOrderRequest {

    /**
    * A descriptor for the appearance of the overlay drawing.
    */
    public final jpuppeteer.cdp.client.entity.overlay.SourceOrderConfig sourceOrderConfig;

    /**
    * Identifier of the node to highlight.
    */
    public final Integer nodeId;

    /**
    * Identifier of the backend node to highlight.
    */
    public final Integer backendNodeId;

    /**
    * JavaScript object id of the node to be highlighted.
    */
    public final String objectId;

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

}