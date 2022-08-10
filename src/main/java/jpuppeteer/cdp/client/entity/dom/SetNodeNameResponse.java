package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetNodeNameResponse {

    /**
    * New node's id.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public SetNodeNameResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public SetNodeNameResponse() {
    }

}