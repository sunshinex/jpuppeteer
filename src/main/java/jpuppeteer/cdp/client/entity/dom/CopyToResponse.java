package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class CopyToResponse {

    /**
    * Id of the node clone.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public CopyToResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public CopyToResponse() {
    }

}