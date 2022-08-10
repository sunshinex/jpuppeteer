package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for the highlighting of Flex item elements.
* experimental
*/
public class FlexItemHighlightConfig {

    /**
    * Style of the box representing the item's base size
    */
    private jpuppeteer.cdp.client.entity.overlay.BoxStyle baseSizeBox;

    /**
    * Style of the border around the box representing the item's base size
    */
    private jpuppeteer.cdp.client.entity.overlay.LineStyle baseSizeBorder;

    /**
    * Style of the arrow representing if the item grew or shrank
    */
    private jpuppeteer.cdp.client.entity.overlay.LineStyle flexibilityArrow;

    public void setBaseSizeBox (jpuppeteer.cdp.client.entity.overlay.BoxStyle baseSizeBox) {
        this.baseSizeBox = baseSizeBox;
    }

    public jpuppeteer.cdp.client.entity.overlay.BoxStyle getBaseSizeBox() {
        return this.baseSizeBox;
    }

    public void setBaseSizeBorder (jpuppeteer.cdp.client.entity.overlay.LineStyle baseSizeBorder) {
        this.baseSizeBorder = baseSizeBorder;
    }

    public jpuppeteer.cdp.client.entity.overlay.LineStyle getBaseSizeBorder() {
        return this.baseSizeBorder;
    }

    public void setFlexibilityArrow (jpuppeteer.cdp.client.entity.overlay.LineStyle flexibilityArrow) {
        this.flexibilityArrow = flexibilityArrow;
    }

    public jpuppeteer.cdp.client.entity.overlay.LineStyle getFlexibilityArrow() {
        return this.flexibilityArrow;
    }

    public FlexItemHighlightConfig(jpuppeteer.cdp.client.entity.overlay.BoxStyle baseSizeBox, jpuppeteer.cdp.client.entity.overlay.LineStyle baseSizeBorder, jpuppeteer.cdp.client.entity.overlay.LineStyle flexibilityArrow) {
        this.baseSizeBox = baseSizeBox;
        this.baseSizeBorder = baseSizeBorder;
        this.flexibilityArrow = flexibilityArrow;
    }

    public FlexItemHighlightConfig() {
        this.baseSizeBox = null;
        this.baseSizeBorder = null;
        this.flexibilityArrow = null;
    }

}