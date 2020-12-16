package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* experimental
*/
public class GetSnapshotResponse {

    /**
    * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.
    */
    public final java.util.List<DOMNode> domNodes;

    /**
    * The nodes in the layout tree.
    */
    public final java.util.List<LayoutTreeNode> layoutTreeNodes;

    /**
    * Whitelisted ComputedStyle properties for each node in the layout tree.
    */
    public final java.util.List<ComputedStyle> computedStyles;

    public GetSnapshotResponse(java.util.List<DOMNode> domNodes, java.util.List<LayoutTreeNode> layoutTreeNodes, java.util.List<ComputedStyle> computedStyles) {
        this.domNodes = domNodes;
        this.layoutTreeNodes = layoutTreeNodes;
        this.computedStyles = computedStyles;
    }

}