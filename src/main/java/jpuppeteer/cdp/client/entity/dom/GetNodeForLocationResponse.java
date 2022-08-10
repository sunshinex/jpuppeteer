package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodeForLocationResponse {

    /**
    * Resulting node.
    */
    private Integer backendNodeId;

    /**
    * Frame this node belongs to.
    */
    private String frameId;

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

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

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

    public GetNodeForLocationResponse() {
    }

}