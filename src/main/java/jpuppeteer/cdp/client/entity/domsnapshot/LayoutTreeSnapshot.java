package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Table of details of an element in the DOM tree with a LayoutObject.
* experimental
*/
public class LayoutTreeSnapshot {

    /**
    * Index of the corresponding node in the `NodeTreeSnapshot` array returned by `captureSnapshot`.
    */
    public final java.util.List<Integer> nodeIndex;

    /**
    * Array of indexes specifying computed style strings, filtered according to the `computedStyles` parameter passed to `captureSnapshot`.
    */
    public final java.util.List<java.util.List<Integer>> styles;

    /**
    * The absolute position bounding box.
    */
    public final java.util.List<java.util.List<java.math.BigDecimal>> bounds;

    /**
    * Contents of the LayoutText, if any.
    */
    public final java.util.List<Integer> text;

    /**
    * Stacking context information.
    */
    public final jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData stackingContexts;

    /**
    * Global paint order index, which is determined by the stacking order of the nodes. Nodes that are painted together will have the same index. Only provided if includePaintOrder in captureSnapshot was true.
    */
    public final java.util.List<Integer> paintOrders;

    /**
    * The offset rect of nodes. Only available when includeDOMRects is set to true
    */
    public final java.util.List<java.util.List<java.math.BigDecimal>> offsetRects;

    /**
    * The scroll rect of nodes. Only available when includeDOMRects is set to true
    */
    public final java.util.List<java.util.List<java.math.BigDecimal>> scrollRects;

    /**
    * The client rect of nodes. Only available when includeDOMRects is set to true
    */
    public final java.util.List<java.util.List<java.math.BigDecimal>> clientRects;

    public LayoutTreeSnapshot(java.util.List<Integer> nodeIndex, java.util.List<java.util.List<Integer>> styles, java.util.List<java.util.List<java.math.BigDecimal>> bounds, java.util.List<Integer> text, jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData stackingContexts, java.util.List<Integer> paintOrders, java.util.List<java.util.List<java.math.BigDecimal>> offsetRects, java.util.List<java.util.List<java.math.BigDecimal>> scrollRects, java.util.List<java.util.List<java.math.BigDecimal>> clientRects) {
        this.nodeIndex = nodeIndex;
        this.styles = styles;
        this.bounds = bounds;
        this.text = text;
        this.stackingContexts = stackingContexts;
        this.paintOrders = paintOrders;
        this.offsetRects = offsetRects;
        this.scrollRects = scrollRects;
        this.clientRects = clientRects;
    }

    public LayoutTreeSnapshot(java.util.List<Integer> nodeIndex, java.util.List<java.util.List<Integer>> styles, java.util.List<java.util.List<java.math.BigDecimal>> bounds, java.util.List<Integer> text, jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData stackingContexts) {
        this.nodeIndex = nodeIndex;
        this.styles = styles;
        this.bounds = bounds;
        this.text = text;
        this.stackingContexts = stackingContexts;
        this.paintOrders = null;
        this.offsetRects = null;
        this.scrollRects = null;
        this.clientRects = null;
    }

}