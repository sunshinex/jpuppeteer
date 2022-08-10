package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class MoveToResponse {

    /**
    * New id of the moved node.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public MoveToResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public MoveToResponse() {
    }

}