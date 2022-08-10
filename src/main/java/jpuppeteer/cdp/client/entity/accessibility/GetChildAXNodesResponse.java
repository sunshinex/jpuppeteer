package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class GetChildAXNodesResponse {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes;

    public void setNodes (java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> getNodes() {
        return this.nodes;
    }

    public GetChildAXNodesResponse(java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

    public GetChildAXNodesResponse() {
    }

}