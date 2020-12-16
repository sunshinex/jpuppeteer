package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Details of an element in the DOM tree with a LayoutObject.
* experimental
*/
public class LayoutTreeNode {

    /**
    * The index of the related DOM node in the `domNodes` array returned by `getSnapshot`.
    */
    public final Integer domNodeIndex;

    /**
    * The bounding box in document coordinates. Note that scroll offset of the document is ignored.
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect boundingBox;

    /**
    * Contents of the LayoutText, if any.
    */
    public final String layoutText;

    /**
    * The post-layout inline text nodes, if any.
    */
    public final java.util.List<InlineTextBox> inlineTextNodes;

    /**
    * Index into the `computedStyles` array returned by `getSnapshot`.
    */
    public final Integer styleIndex;

    /**
    * Global paint order index, which is determined by the stacking order of the nodes. Nodes that are painted together will have the same index. Only provided if includePaintOrder in getSnapshot was true.
    */
    public final Integer paintOrder;

    /**
    * Set to true to indicate the element begins a new stacking context.
    */
    public final Boolean isStackingContext;

    public LayoutTreeNode(Integer domNodeIndex, jpuppeteer.cdp.client.entity.dom.Rect boundingBox, String layoutText, java.util.List<InlineTextBox> inlineTextNodes, Integer styleIndex, Integer paintOrder, Boolean isStackingContext) {
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

}