package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetRelayoutBoundaryResponse {

    /**
    * Relayout boundary node id for the given node.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetRelayoutBoundaryResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public GetRelayoutBoundaryResponse() {
    }

}