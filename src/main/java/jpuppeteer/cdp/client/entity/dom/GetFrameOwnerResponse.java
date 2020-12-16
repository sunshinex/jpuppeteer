package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetFrameOwnerResponse {

    /**
    * Resulting node.
    */
    public final Integer backendNodeId;

    /**
    * Id of the node at given coordinates, only when enabled and requested document.
    */
    public final Integer nodeId;

    public GetFrameOwnerResponse(Integer backendNodeId, Integer nodeId) {
        this.backendNodeId = backendNodeId;
        this.nodeId = nodeId;
    }

    public GetFrameOwnerResponse(Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
        this.nodeId = null;
    }

}