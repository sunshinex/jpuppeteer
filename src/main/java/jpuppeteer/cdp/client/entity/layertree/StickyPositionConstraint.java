package jpuppeteer.cdp.client.entity.layertree;

/**
* Sticky position constraints.
* experimental
*/
public class StickyPositionConstraint {

    /**
    * Layout rectangle of the sticky element before being shifted
    */
    private jpuppeteer.cdp.client.entity.dom.Rect stickyBoxRect;

    /**
    * Layout rectangle of the containing block of the sticky element
    */
    private jpuppeteer.cdp.client.entity.dom.Rect containingBlockRect;

    /**
    * The nearest sticky layer that shifts the sticky box
    */
    private String nearestLayerShiftingStickyBox;

    /**
    * The nearest sticky layer that shifts the containing block
    */
    private String nearestLayerShiftingContainingBlock;

    public void setStickyBoxRect (jpuppeteer.cdp.client.entity.dom.Rect stickyBoxRect) {
        this.stickyBoxRect = stickyBoxRect;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getStickyBoxRect() {
        return this.stickyBoxRect;
    }

    public void setContainingBlockRect (jpuppeteer.cdp.client.entity.dom.Rect containingBlockRect) {
        this.containingBlockRect = containingBlockRect;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getContainingBlockRect() {
        return this.containingBlockRect;
    }

    public void setNearestLayerShiftingStickyBox (String nearestLayerShiftingStickyBox) {
        this.nearestLayerShiftingStickyBox = nearestLayerShiftingStickyBox;
    }

    public String getNearestLayerShiftingStickyBox() {
        return this.nearestLayerShiftingStickyBox;
    }

    public void setNearestLayerShiftingContainingBlock (String nearestLayerShiftingContainingBlock) {
        this.nearestLayerShiftingContainingBlock = nearestLayerShiftingContainingBlock;
    }

    public String getNearestLayerShiftingContainingBlock() {
        return this.nearestLayerShiftingContainingBlock;
    }

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

    public StickyPositionConstraint() {
    }

}