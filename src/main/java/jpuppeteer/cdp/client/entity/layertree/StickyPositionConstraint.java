package jpuppeteer.cdp.client.entity.layertree;

/**
* Sticky position constraints.
* experimental
*/
public class StickyPositionConstraint {

    /**
    * Layout rectangle of the sticky element before being shifted
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect stickyBoxRect;

    /**
    * Layout rectangle of the containing block of the sticky element
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect containingBlockRect;

    /**
    * The nearest sticky layer that shifts the sticky box
    */
    public final String nearestLayerShiftingStickyBox;

    /**
    * The nearest sticky layer that shifts the containing block
    */
    public final String nearestLayerShiftingContainingBlock;

    public StickyPositionConstraint(jpuppeteer.cdp.client.entity.dom.Rect stickyBoxRect, jpuppeteer.cdp.client.entity.dom.Rect containingBlockRect, String nearestLayerShiftingStickyBox, String nearestLayerShiftingContainingBlock) {
        this.stickyBoxRect = stickyBoxRect;
        this.containingBlockRect = containingBlockRect;
        this.nearestLayerShiftingStickyBox = nearestLayerShiftingStickyBox;
        this.nearestLayerShiftingContainingBlock = nearestLayerShiftingContainingBlock;
    }

    public StickyPositionConstraint(jpuppeteer.cdp.client.entity.dom.Rect stickyBoxRect, jpuppeteer.cdp.client.entity.dom.Rect containingBlockRect) {
        this.stickyBoxRect = stickyBoxRect;
        this.containingBlockRect = containingBlockRect;
        this.nearestLayerShiftingStickyBox = null;
        this.nearestLayerShiftingContainingBlock = null;
    }

}