package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* experimental
*/
public class GetSnapshotResponse {

    /**
    * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DOMNode> domNodes;

    /**
    * The nodes in the layout tree.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeNode> layoutTreeNodes;

    /**
    * Whitelisted ComputedStyle properties for each node in the layout tree.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.ComputedStyle> computedStyles;

    public GetSnapshotResponse(java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DOMNode> domNodes, java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeNode> layoutTreeNodes, java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.ComputedStyle> computedStyles) {
        this.domNodes = domNodes;
        this.layoutTreeNodes = layoutTreeNodes;
        this.computedStyles = computedStyles;
    }

}