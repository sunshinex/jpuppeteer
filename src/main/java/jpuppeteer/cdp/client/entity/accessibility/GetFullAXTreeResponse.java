package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class GetFullAXTreeResponse {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes;

    public void setNodes (java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> getNodes() {
        return this.nodes;
    }

    public GetFullAXTreeResponse(java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

    public GetFullAXTreeResponse() {
    }

}