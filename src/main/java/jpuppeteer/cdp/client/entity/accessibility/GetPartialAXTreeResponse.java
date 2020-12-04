package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class GetPartialAXTreeResponse {

    /**
    * The `Accessibility.AXNode` for this DOM node, if it exists, plus its ancestors, siblings and children, if requested.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes;

    public GetPartialAXTreeResponse(java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXNode> nodes) {
        this.nodes = nodes;
    }

}