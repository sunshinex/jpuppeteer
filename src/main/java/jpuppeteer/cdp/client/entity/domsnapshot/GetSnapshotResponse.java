package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* experimental
*/
public class GetSnapshotResponse {

    /**
    * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DOMNode> domNodes;

    /**
    * The nodes in the layout tree.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeNode> layoutTreeNodes;

    /**
    * Whitelisted ComputedStyle properties for each node in the layout tree.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.ComputedStyle> computedStyles;

    public void setDomNodes (java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DOMNode> domNodes) {
        this.domNodes = domNodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DOMNode> getDomNodes() {
        return this.domNodes;
    }

    public void setLayoutTreeNodes (java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeNode> layoutTreeNodes) {
        this.layoutTreeNodes = layoutTreeNodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeNode> getLayoutTreeNodes() {
        return this.layoutTreeNodes;
    }

    public void setComputedStyles (java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.ComputedStyle> computedStyles) {
        this.computedStyles = computedStyles;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.ComputedStyle> getComputedStyles() {
        return this.computedStyles;
    }

    public GetSnapshotResponse(java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DOMNode> domNodes, java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeNode> layoutTreeNodes, java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.ComputedStyle> computedStyles) {
        this.domNodes = domNodes;
        this.layoutTreeNodes = layoutTreeNodes;
        this.computedStyles = computedStyles;
    }

    public GetSnapshotResponse() {
    }

}