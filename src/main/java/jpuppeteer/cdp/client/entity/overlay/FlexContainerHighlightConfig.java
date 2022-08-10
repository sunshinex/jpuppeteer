package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for the highlighting of Flex container elements.
* experimental
*/
public class FlexContainerHighlightConfig {

    /**
    * The style of the container border
    */
    private jpuppeteer.cdp.client.entity.overlay.LineStyle containerBorder;

    /**
    * The style of the separator between lines
    */
    private jpuppeteer.cdp.client.entity.overlay.LineStyle lineSeparator;

    /**
    * The style of the separator between items
    */
    private jpuppeteer.cdp.client.entity.overlay.LineStyle itemSeparator;

    /**
    * Style of content-distribution space on the main axis (justify-content).
    */
    private jpuppeteer.cdp.client.entity.overlay.BoxStyle mainDistributedSpace;

    /**
    * Style of content-distribution space on the cross axis (align-content).
    */
    private jpuppeteer.cdp.client.entity.overlay.BoxStyle crossDistributedSpace;

    /**
    * Style of empty space caused by row gaps (gap/row-gap).
    */
    private jpuppeteer.cdp.client.entity.overlay.BoxStyle rowGapSpace;

    /**
    * Style of empty space caused by columns gaps (gap/column-gap).
    */
    private jpuppeteer.cdp.client.entity.overlay.BoxStyle columnGapSpace;

    /**
    * Style of the self-alignment line (align-items).
    */
    private jpuppeteer.cdp.client.entity.overlay.LineStyle crossAlignment;

    public void setContainerBorder (jpuppeteer.cdp.client.entity.overlay.LineStyle containerBorder) {
        this.containerBorder = containerBorder;
    }

    public jpuppeteer.cdp.client.entity.overlay.LineStyle getContainerBorder() {
        return this.containerBorder;
    }

    public void setLineSeparator (jpuppeteer.cdp.client.entity.overlay.LineStyle lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    public jpuppeteer.cdp.client.entity.overlay.LineStyle getLineSeparator() {
        return this.lineSeparator;
    }

    public void setItemSeparator (jpuppeteer.cdp.client.entity.overlay.LineStyle itemSeparator) {
        this.itemSeparator = itemSeparator;
    }

    public jpuppeteer.cdp.client.entity.overlay.LineStyle getItemSeparator() {
        return this.itemSeparator;
    }

    public void setMainDistributedSpace (jpuppeteer.cdp.client.entity.overlay.BoxStyle mainDistributedSpace) {
        this.mainDistributedSpace = mainDistributedSpace;
    }

    public jpuppeteer.cdp.client.entity.overlay.BoxStyle getMainDistributedSpace() {
        return this.mainDistributedSpace;
    }

    public void setCrossDistributedSpace (jpuppeteer.cdp.client.entity.overlay.BoxStyle crossDistributedSpace) {
        this.crossDistributedSpace = crossDistributedSpace;
    }

    public jpuppeteer.cdp.client.entity.overlay.BoxStyle getCrossDistributedSpace() {
        return this.crossDistributedSpace;
    }

    public void setRowGapSpace (jpuppeteer.cdp.client.entity.overlay.BoxStyle rowGapSpace) {
        this.rowGapSpace = rowGapSpace;
    }

    public jpuppeteer.cdp.client.entity.overlay.BoxStyle getRowGapSpace() {
        return this.rowGapSpace;
    }

    public void setColumnGapSpace (jpuppeteer.cdp.client.entity.overlay.BoxStyle columnGapSpace) {
        this.columnGapSpace = columnGapSpace;
    }

    public jpuppeteer.cdp.client.entity.overlay.BoxStyle getColumnGapSpace() {
        return this.columnGapSpace;
    }

    public void setCrossAlignment (jpuppeteer.cdp.client.entity.overlay.LineStyle crossAlignment) {
        this.crossAlignment = crossAlignment;
    }

    public jpuppeteer.cdp.client.entity.overlay.LineStyle getCrossAlignment() {
        return this.crossAlignment;
    }

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