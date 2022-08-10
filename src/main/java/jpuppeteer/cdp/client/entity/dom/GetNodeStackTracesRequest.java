package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodeStackTracesRequest {

    /**
    * Id of the node to get stack traces for.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetNodeStackTracesRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public GetNodeStackTracesRequest() {
    }

}