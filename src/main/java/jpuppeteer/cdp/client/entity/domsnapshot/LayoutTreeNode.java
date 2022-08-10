package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Details of an element in the DOM tree with a LayoutObject.
* experimental
*/
public class LayoutTreeNode {

    /**
    * The index of the related DOM node in the `domNodes` array returned by `getSnapshot`.
    */
    private Integer domNodeIndex;

    /**
    * The bounding box in document coordinates. Note that scroll offset of the document is ignored.
    */
    private jpuppeteer.cdp.client.entity.dom.Rect boundingBox;

    /**
    * Contents of the LayoutText, if any.
    */
    private String layoutText;

    /**
    * The post-layout inline text nodes, if any.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.InlineTextBox> inlineTextNodes;

    /**
    * Index into the `computedStyles` array returned by `getSnapshot`.
    */
    private Integer styleIndex;

    /**
    * Global paint order index, which is determined by the stacking order of the nodes. Nodes that are painted together will have the same index. Only provided if includePaintOrder in getSnapshot was true.
    */
    private Integer paintOrder;

    /**
    * Set to true to indicate the element begins a new stacking context.
    */
    private Boolean isStackingContext;

    public void setDomNodeIndex (Integer domNodeIndex) {
        this.domNodeIndex = domNodeIndex;
    }

    public Integer getDomNodeIndex() {
        return this.domNodeIndex;
    }

    public void setBoundingBox (jpuppeteer.cdp.client.entity.dom.Rect boundingBox) {
        this.boundingBox = boundingBox;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getBoundingBox() {
        return this.boundingBox;
    }

    public void setLayoutText (String layoutText) {
        this.layoutText = layoutText;
    }

    public String getLayoutText() {
        return this.layoutText;
    }

    public void setInlineTextNodes (java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.InlineTextBox> inlineTextNodes) {
        this.inlineTextNodes = inlineTextNodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.InlineTextBox> getInlineTextNodes() {
        return this.inlineTextNodes;
    }

    public void setStyleIndex (Integer styleIndex) {
        this.styleIndex = styleIndex;
    }

    public Integer getStyleIndex() {
        return this.styleIndex;
    }

    public void setPaintOrder (Integer paintOrder) {
        this.paintOrder = paintOrder;
    }

    public Integer getPaintOrder() {
        return this.paintOrder;
    }

    public void setIsStackingContext (Boolean isStackingContext) {
        this.isStackingContext = isStackingContext;
    }

    public Boolean getIsStackingContext() {
        return this.isStackingContext;
    }

    public LayoutTreeNode(Integer domNodeIndex, jpuppeteer.cdp.client.entity.dom.Rect boundingBox, String layoutText, java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.InlineTextBox> inlineTextNodes, Integer styleIndex, Integer paintOrder, Boolean isStackingContext) {
        this.domNodeIndex = domNodeIndex;
        this.boundingBox = boundingBox;
        this.layoutText = layoutText;
        this.inlineTextNodes = inlineTextNodes;
        this.styleIndex = styleIndex;
        this.paintOrder = paintOrder;
        this.isStackingContext = isStackingContext;
    }

    public LayoutTreeNode(Integer domNodeIndex, jpuppeteer.cdp.client.entity.dom.Rect boundingBox) {
        this.domNodeIndex = domNodeIndex;
        this.boundingBox = boundingBox;
        this.layoutText = null;
        this.inlineTextNodes = null;
        this.styleIndex = null;
        this.paintOrder = null;
        this.isStackingContext = null;
    }

    public LayoutTreeNode() {
    }

}