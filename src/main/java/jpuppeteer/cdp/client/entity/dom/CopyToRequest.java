package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class CopyToRequest {

    /**
    * Id of the node to copy.
    */
    private Integer nodeId;

    /**
    * Id of the element to drop the copy into.
    */
    private Integer targetNodeId;

    /**
    * Drop the copy before this node (if absent, the copy becomes the last child of `targetNodeId`).
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

    public CopyToRequest(Integer nodeId, Integer targetNodeId, Integer insertBeforeNodeId) {
        this.nodeId = nodeId;
        this.targetNodeId = targetNodeId;
        this.insertBeforeNodeId = insertBeforeNodeId;
    }

    public CopyToRequest(Integer nodeId, Integer targetNodeId) {
        this.nodeId = nodeId;
        this.targetNodeId = targetNodeId;
        this.insertBeforeNodeId = null;
    }

    public CopyToRequest() {
    }

}