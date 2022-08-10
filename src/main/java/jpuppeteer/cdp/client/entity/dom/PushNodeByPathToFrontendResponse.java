package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PushNodeByPathToFrontendResponse {

    /**
    * Id of the node for given path.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public PushNodeByPathToFrontendResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public PushNodeByPathToFrontendResponse() {
    }

}