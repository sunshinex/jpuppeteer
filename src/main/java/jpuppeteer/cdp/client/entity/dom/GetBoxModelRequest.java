package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetBoxModelRequest {

    /**
    * Identifier of the node.
    */
    public final Integer nodeId;

    /**
    * Identifier of the backend node.
    */
    public final Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper.
    */
    public final String objectId;

    public GetBoxModelRequest(Integer nodeId, Integer backendNodeId, String objectId) {
        this.nodeId = nodeId;
        this.backendNodeId = backendNodeId;
        this.objectId = objectId;
    }

    public GetBoxModelRequest() {
        this.nodeId = null;
        this.backendNodeId = null;
        this.objectId = null;
    }

}