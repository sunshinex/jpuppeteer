package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetAttributesRequest {

    /**
    * Id of the node to retrieve attibutes for.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetAttributesRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public GetAttributesRequest() {
    }

}