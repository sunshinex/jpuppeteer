package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for the highlighting of Flex container elements.
* experimental
*/
public class FlexContainerHighlightConfig {

    /**
    * The style of the container border
    */
    public final jpuppeteer.cdp.client.entity.overlay.LineStyle containerBorder;

    /**
    * The style of the separator between lines
    */
    public final jpuppeteer.cdp.client.entity.overlay.LineStyle lineSeparator;

    /**
    * The style of the separator between items
    */
    public final jpuppeteer.cdp.client.entity.overlay.LineStyle itemSeparator;

    /**
    * Style of content-distribution space on the main axis (justify-content).
    */
    public final jpuppeteer.cdp.client.entity.overlay.BoxStyle mainDistributedSpace;

    /**
    * Style of content-distribution space on the cross axis (align-content).
    */
    public final jpuppeteer.cdp.client.entity.overlay.BoxStyle crossDistributedSpace;

    /**
    * Style of empty space caused by row gaps (gap/row-gap).
    */
    public final jpuppeteer.cdp.client.entity.overlay.BoxStyle rowGapSpace;

    /**
    * Style of empty space caused by columns gaps (gap/column-gap).
    */
    public final jpuppeteer.cdp.client.entity.overlay.BoxStyle columnGapSpace;

    /**
    * Style of the self-alignment line (align-items).
    */
    public final jpuppeteer.cdp.client.entity.overlay.LineStyle crossAlignment;

    public FlexContainerHighlightConfig(jpuppeteer.cdp.client.entity.overlay.LineStyle containerBorder, jpuppeteer.cdp.client.entity.overlay.LineStyle lineSeparator, jpuppeteer.cdp.client.entity.overlay.LineStyle itemSeparator, jpuppeteer.cdp.client.entity.overlay.BoxStyle mainDistributedSpace, jpuppeteer.cdp.client.entity.overlay.BoxStyle crossDistributedSpace, jpuppeteer.cdp.client.entity.overlay.BoxStyle rowGapSpace, jpuppeteer.cdp.client.entity.overlay.BoxStyle columnGapSpace, jpuppeteer.cdp.client.entity.overlay.LineStyle crossAlignment) {
        this.containerBorder = containerBorder;
        this.lineSeparator = lineSeparator;
        this.itemSeparator = itemSeparator;
        this.mainDistributedSpace = mainDistributedSpace;
        this.crossDistributedSpace = crossDistributedSpace;
        this.rowGapSpace = rowGapSpace;
        this.columnGapSpace = columnGapSpace;
        this.crossAlignment = crossAlignment;
    }

    public FlexContainerHighlightConfig() {
        this.containerBorder = null;
        this.lineSeparator = null;
        this.itemSeparator = null;
        this.mainDistributedSpace = null;
        this.crossDistributedSpace = null;
        this.rowGapSpace = null;
        this.columnGapSpace = null;
        this.crossAlignment = null;
    }

}