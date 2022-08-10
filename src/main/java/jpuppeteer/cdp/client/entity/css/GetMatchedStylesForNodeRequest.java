package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetMatchedStylesForNodeRequest {

    /**
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetMatchedStylesForNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public GetMatchedStylesForNodeRequest() {
    }

}