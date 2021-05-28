package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodesForSubtreeByStyleRequest {

    /**
    * Node ID pointing to the root of a subtree.
    */
    public final Integer nodeId;

    /**
    * The style to filter nodes by (includes nodes if any of properties matches).
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.dom.CSSComputedStyleProperty> computedStyles;

    /**
    * Whether or not iframes and shadow roots in the same target should be traversed when returning the results (default is false).
    */
    public final Boolean pierce;

    public GetNodesForSubtreeByStyleRequest(Integer nodeId, java.util.List<jpuppeteer.cdp.client.entity.dom.CSSComputedStyleProperty> computedStyles, Boolean pierce) {
        this.nodeId = nodeId;
        this.computedStyles = computedStyles;
        this.pierce = pierce;
    }

    public GetNodesForSubtreeByStyleRequest(Integer nodeId, java.util.List<jpuppeteer.cdp.client.entity.dom.CSSComputedStyleProperty> computedStyles) {
        this.nodeId = nodeId;
        this.computedStyles = computedStyles;
        this.pierce = null;
    }

}