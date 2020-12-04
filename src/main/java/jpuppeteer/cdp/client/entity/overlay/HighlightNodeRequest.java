package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightNodeRequest {

    /**
    * A descriptor for the highlight appearance.
    */
    public final jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig;

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

    /**
    * Selectors to highlight relevant nodes.
    */
    public final String selector;

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

}