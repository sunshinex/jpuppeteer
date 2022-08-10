package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetFrameOwnerResponse {

    /**
    * Resulting node.
    */
    private Integer backendNodeId;

    /**
    * Id of the node at given coordinates, only when enabled and requested document.
    */
    private Integer nodeId;

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetFrameOwnerResponse(Integer backendNodeId, Integer nodeId) {
        this.backendNodeId = backendNodeId;
        this.nodeId = nodeId;
    }

    public GetFrameOwnerResponse(Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
        this.nodeId = null;
    }

    public GetFrameOwnerResponse() {
    }

}