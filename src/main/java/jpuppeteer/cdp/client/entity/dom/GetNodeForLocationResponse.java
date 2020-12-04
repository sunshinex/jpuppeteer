package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodeForLocationResponse {

    /**
    * Resulting node.
    */
    public final Integer backendNodeId;

    /**
    * Frame this node belongs to.
    */
    public final String frameId;

    /**
    * Id of the node at given coordinates, only when enabled and requested document.
    */
    public final Integer nodeId;

    public GetNodeForLocationResponse(Integer backendNodeId, String frameId, Integer nodeId) {
        this.backendNodeId = backendNodeId;
        this.frameId = frameId;
        this.nodeId = nodeId;
    }

    public GetNodeForLocationResponse(Integer backendNodeId, String frameId) {
        this.backendNodeId = backendNodeId;
        this.frameId = frameId;
        this.nodeId = null;
    }

}