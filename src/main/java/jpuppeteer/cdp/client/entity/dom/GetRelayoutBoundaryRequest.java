package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetRelayoutBoundaryRequest {

    /**
    * Id of the node.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetRelayoutBoundaryRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public GetRelayoutBoundaryRequest() {
    }

}