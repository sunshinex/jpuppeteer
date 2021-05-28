package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class QueryAXTreeResponse {

    /**
    * A list of `Accessibility.AXNode` matching the specified attributes, including nodes that are ignored for accessibility.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes;

    public QueryAXTreeResponse(java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

}