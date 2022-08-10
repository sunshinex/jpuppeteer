package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class MoveToRequest {

    /**
    * Id of the node to move.
    */
    private Integer nodeId;

    /**
    * Id of the element to drop the moved node into.
    */
    private Integer targetNodeId;

    /**
    * Drop node before this one (if absent, the moved node becomes the last child of `targetNodeId`).
    */
    private Integer insertBeforeNodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setTargetNodeId (Integer targetNodeId) {
        this.targetNodeId = targetNodeId;
    }

    public Integer getTargetNodeId() {
        return this.targetNodeId;
    }

    public void setInsertBeforeNodeId (Integer insertBeforeNodeId) {
        this.insertBeforeNodeId = insertBeforeNodeId;
    }

    public Integer getInsertBeforeNodeId() {
        return this.insertBeforeNodeId;
    }

    public MoveToRequest(Integer nodeId, Integer targetNodeId, Integer insertBeforeNodeId) {
        this.nodeId = nodeId;
        this.targetNodeId = targetNodeId;
        this.insertBeforeNodeId = insertBeforeNodeId;
    }

    public MoveToRequest(Integer nodeId, Integer targetNodeId) {
        this.nodeId = nodeId;
        this.targetNodeId = targetNodeId;
        this.insertBeforeNodeId = null;
    }

    public MoveToRequest() {
    }

}