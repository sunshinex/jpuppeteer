package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class MoveToRequest {

    /**
    * Id of the node to move.
    */
    public final Integer nodeId;

    /**
    * Id of the element to drop the moved node into.
    */
    public final Integer targetNodeId;

    /**
    * Drop node before this one (if absent, the moved node becomes the last child of `targetNodeId`).
    */
    public final Integer insertBeforeNodeId;

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

}