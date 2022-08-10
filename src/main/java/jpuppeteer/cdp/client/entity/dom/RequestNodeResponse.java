package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RequestNodeResponse {

    /**
    * Node id for given object.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public RequestNodeResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public RequestNodeResponse() {
    }

}