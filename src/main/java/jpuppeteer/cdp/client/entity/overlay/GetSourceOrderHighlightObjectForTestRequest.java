package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetSourceOrderHighlightObjectForTestRequest {

    /**
    * Id of the node to highlight.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetSourceOrderHighlightObjectForTestRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public GetSourceOrderHighlightObjectForTestRequest() {
    }

}