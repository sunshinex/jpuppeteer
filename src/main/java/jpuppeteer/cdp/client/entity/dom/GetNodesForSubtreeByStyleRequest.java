package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodesForSubtreeByStyleRequest {

    /**
    * Node ID pointing to the root of a subtree.
    */
    private Integer nodeId;

    /**
    * The style to filter nodes by (includes nodes if any of properties matches).
    */
    private java.util.List<jpuppeteer.cdp.client.entity.dom.CSSComputedStyleProperty> computedStyles;

    /**
    * Whether or not iframes and shadow roots in the same target should be traversed when returning the results (default is false).
    */
    private Boolean pierce;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setComputedStyles (java.util.List<jpuppeteer.cdp.client.entity.dom.CSSComputedStyleProperty> computedStyles) {
        this.computedStyles = computedStyles;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.dom.CSSComputedStyleProperty> getComputedStyles() {
        return this.computedStyles;
    }

    public void setPierce (Boolean pierce) {
        this.pierce = pierce;
    }

    public Boolean getPierce() {
        return this.pierce;
    }

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

    public GetNodesForSubtreeByStyleRequest() {
    }

}