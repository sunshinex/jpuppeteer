package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetInlineStylesForNodeRequest {

    /**
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetInlineStylesForNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public GetInlineStylesForNodeRequest() {
    }

}