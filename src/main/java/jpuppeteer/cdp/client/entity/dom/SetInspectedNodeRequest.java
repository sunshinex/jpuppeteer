package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetInspectedNodeRequest {

    /**
    * DOM node id to be accessible by means of $x command line API.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public SetInspectedNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public SetInspectedNodeRequest() {
    }

}