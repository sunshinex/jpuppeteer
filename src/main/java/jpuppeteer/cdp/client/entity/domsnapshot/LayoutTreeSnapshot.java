package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Table of details of an element in the DOM tree with a LayoutObject.
* experimental
*/
public class LayoutTreeSnapshot {

    /**
    * Index of the corresponding node in the `NodeTreeSnapshot` array returned by `captureSnapshot`.
    */
    private java.util.List<Integer> nodeIndex;

    /**
    * Array of indexes specifying computed style strings, filtered according to the `computedStyles` parameter passed to `captureSnapshot`.
    */
    private java.util.List<java.util.List<Integer>> styles;

    /**
    * The absolute position bounding box.
    */
    private java.util.List<java.util.List<java.math.BigDecimal>> bounds;

    /**
    * Contents of the LayoutText, if any.
    */
    private java.util.List<Integer> text;

    /**
    * Stacking context information.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData stackingContexts;

    /**
    * Global paint order index, which is determined by the stacking order of the nodes. Nodes that are painted together will have the same index. Only provided if includePaintOrder in captureSnapshot was true.
    */
    private java.util.List<Integer> paintOrders;

    /**
    * The offset rect of nodes. Only available when includeDOMRects is set to true
    */
    private java.util.List<java.util.List<java.math.BigDecimal>> offsetRects;

    /**
    * The scroll rect of nodes. Only available when includeDOMRects is set to true
    */
    private java.util.List<java.util.List<java.math.BigDecimal>> scrollRects;

    /**
    * The client rect of nodes. Only available when includeDOMRects is set to true
    */
    private java.util.List<java.util.List<java.math.BigDecimal>> clientRects;

    /**
    * The list of background colors that are blended with colors of overlapping elements.
    */
    private java.util.List<Integer> blendedBackgroundColors;

    /**
    * The list of computed text opacities.
    */
    private java.util.List<java.math.BigDecimal> textColorOpacities;

    public void setNodeIndex (java.util.List<Integer> nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    public java.util.List<Integer> getNodeIndex() {
        return this.nodeIndex;
    }

    public void setStyles (java.util.List<java.util.List<Integer>> styles) {
        this.styles = styles;
    }

    public java.util.List<java.util.List<Integer>> getStyles() {
        return this.styles;
    }

    public void setBounds (java.util.List<java.util.List<java.math.BigDecimal>> bounds) {
        this.bounds = bounds;
    }

    public java.util.List<java.util.List<java.math.BigDecimal>> getBounds() {
        return this.bounds;
    }

    public void setText (java.util.List<Integer> text) {
        this.text = text;
    }

    public java.util.List<Integer> getText() {
        return this.text;
    }

    public void setStackingContexts (jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData stackingContexts) {
        this.stackingContexts = stackingContexts;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData getStackingContexts() {
        return this.stackingContexts;
    }

    public void setPaintOrders (java.util.List<Integer> paintOrders) {
        this.paintOrders = paintOrders;
    }

    public java.util.List<Integer> getPaintOrders() {
        return this.paintOrders;
    }

    public void setOffsetRects (java.util.List<java.util.List<java.math.BigDecimal>> offsetRects) {
        this.offsetRects = offsetRects;
    }

    public java.util.List<java.util.List<java.math.BigDecimal>> getOffsetRects() {
        return this.offsetRects;
    }

    public void setScrollRects (java.util.List<java.util.List<java.math.BigDecimal>> scrollRects) {
        this.scrollRects = scrollRects;
    }

    public java.util.List<java.util.List<java.math.BigDecimal>> getScrollRects() {
        return this.scrollRects;
    }

    public void setClientRects (java.util.List<java.util.List<java.math.BigDecimal>> clientRects) {
        this.clientRects = clientRects;
    }

    public java.util.List<java.util.List<java.math.BigDecimal>> getClientRects() {
        return this.clientRects;
    }

    public void setBlendedBackgroundColors (java.util.List<Integer> blendedBackgroundColors) {
        this.blendedBackgroundColors = blendedBackgroundColors;
    }

    public java.util.List<Integer> getBlendedBackgroundColors() {
        return this.blendedBackgroundColors;
    }

    public void setTextColorOpacities (java.util.List<java.math.BigDecimal> textColorOpacities) {
        this.textColorOpacities = textColorOpacities;
    }

    public java.util.List<java.math.BigDecimal> getTextColorOpacities() {
        return this.textColorOpacities;
    }

    public LayoutTreeSnapshot(java.util.List<Integer> nodeIndex, java.util.List<java.util.List<Integer>> styles, java.util.List<java.util.List<java.math.BigDecimal>> bounds, java.util.List<Integer> text, jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData stackingContexts, java.util.List<Integer> paintOrders, java.util.List<java.util.List<java.math.BigDecimal>> offsetRects, java.util.List<java.util.List<java.math.BigDecimal>> scrollRects, java.util.List<java.util.List<java.math.BigDecimal>> clientRects, java.util.List<Integer> blendedBackgroundColors, java.util.List<java.math.BigDecimal> textColorOpacities) {
        this.nodeIndex = nodeIndex;
        this.styles = styles;
        this.bounds = bounds;
        this.text = text;
        this.stackingContexts = stackingContexts;
        this.paintOrders = paintOrders;
        this.offsetRects = offsetRects;
        this.scrollRects = scrollRects;
        this.clientRects = clientRects;
        this.blendedBackgroundColors = blendedBackgroundColors;
        this.textColorOpacities = textColorOpacities;
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
        this.blendedBackgroundColors = null;
        this.textColorOpacities = null;
    }

    public LayoutTreeSnapshot() {
    }

}