package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RemoveNodeRequest {

    /**
    * Id of the node to remove.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public RemoveNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public RemoveNodeRequest() {
    }

}