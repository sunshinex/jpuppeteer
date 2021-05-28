package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for the highlighting of Flex item elements.
* experimental
*/
public class FlexItemHighlightConfig {

    /**
    * Style of the box representing the item's base size
    */
    public final jpuppeteer.cdp.client.entity.overlay.BoxStyle baseSizeBox;

    /**
    * Style of the border around the box representing the item's base size
    */
    public final jpuppeteer.cdp.client.entity.overlay.LineStyle baseSizeBorder;

    /**
    * Style of the arrow representing if the item grew or shrank
    */
    public final jpuppeteer.cdp.client.entity.overlay.LineStyle flexibilityArrow;

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