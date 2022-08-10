package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetBoxModelRequest {

    /**
    * Identifier of the node.
    */
    private Integer nodeId;

    /**
    * Identifier of the backend node.
    */
    private Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper.
    */
    private String objectId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

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