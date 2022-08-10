package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class GetPartialAXTreeResponse {

    /**
    * The `Accessibility.AXNode` for this DOM node, if it exists, plus its ancestors, siblings and children, if requested.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes;

    public void setNodes (java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> getNodes() {
        return this.nodes;
    }

    public GetPartialAXTreeResponse(java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

    public GetPartialAXTreeResponse() {
    }

}