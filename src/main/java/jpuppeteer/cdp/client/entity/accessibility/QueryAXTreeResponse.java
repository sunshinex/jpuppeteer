package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class QueryAXTreeResponse {

    /**
    * A list of `Accessibility.AXNode` matching the specified attributes, including nodes that are ignored for accessibility.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes;

    public void setNodes (java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> getNodes() {
        return this.nodes;
    }

    public QueryAXTreeResponse(java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

    public QueryAXTreeResponse() {
    }

}