package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetPlatformFontsForNodeRequest {

    /**
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public GetPlatformFontsForNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public GetPlatformFontsForNodeRequest() {
    }

}