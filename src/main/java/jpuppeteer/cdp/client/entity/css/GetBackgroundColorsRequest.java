package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetBackgroundColorsRequest {

    /**
    * Id of the node to get background colors for.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetBackgroundColorsRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public GetBackgroundColorsRequest() {
    }

}