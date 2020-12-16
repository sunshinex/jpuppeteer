package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class CopyToRequest {

    /**
    * Id of the node to copy.
    */
    public final Integer nodeId;

    /**
    * Id of the element to drop the copy into.
    */
    public final Integer targetNodeId;

    /**
    * Drop the copy before this node (if absent, the copy becomes the last child of `targetNodeId`).
    */
    public final Integer insertBeforeNodeId;

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

}