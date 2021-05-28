package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for the highlighting of Grid elements.
* experimental
*/
public class GridHighlightConfig {

    /**
    * Whether the extension lines from grid cells to the rulers should be shown (default: false).
    */
    public final Boolean showGridExtensionLines;

    /**
    * Show Positive line number labels (default: false).
    */
    public final Boolean showPositiveLineNumbers;

    /**
    * Show Negative line number labels (default: false).
    */
    public final Boolean showNegativeLineNumbers;

    /**
    * Show area name labels (default: false).
    */
    public final Boolean showAreaNames;

    /**
    * Show line name labels (default: false).
    */
    public final Boolean showLineNames;

    /**
    * Show track size labels (default: false).
    */
    public final Boolean showTrackSizes;

    /**
    * The grid container border highlight color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA gridBorderColor;

    /**
    * The cell border color (default: transparent). Deprecated, please use rowLineColor and columnLineColor instead.
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA cellBorderColor;

    /**
    * The row line color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA rowLineColor;

    /**
    * The column line color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA columnLineColor;

    /**
    * Whether the grid border is dashed (default: false).
    */
    public final Boolean gridBorderDash;

    /**
    * Whether the cell border is dashed (default: false). Deprecated, please us rowLineDash and columnLineDash instead.
    */
    public final Boolean cellBorderDash;

    /**
    * Whether row lines are dashed (default: false).
    */
    public final Boolean rowLineDash;

    /**
    * Whether column lines are dashed (default: false).
    */
    public final Boolean columnLineDash;

    /**
    * The row gap highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA rowGapColor;

    /**
    * The row gap hatching fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA rowHatchColor;

    /**
    * The column gap highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA columnGapColor;

    /**
    * The column gap hatching fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA columnHatchColor;

    /**
    * The named grid areas border color (Default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA areaBorderColor;

    /**
    * The grid container background color (Default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA gridBackgroundColor;

    public GridHighlightConfig(Boolean showGridExtensionLines, Boolean showPositiveLineNumbers, Boolean showNegativeLineNumbers, Boolean showAreaNames, Boolean showLineNames, Boolean showTrackSizes, jpuppeteer.cdp.client.entity.dom.RGBA gridBorderColor, jpuppeteer.cdp.client.entity.dom.RGBA cellBorderColor, jpuppeteer.cdp.client.entity.dom.RGBA rowLineColor, jpuppeteer.cdp.client.entity.dom.RGBA columnLineColor, Boolean gridBorderDash, Boolean cellBorderDash, Boolean rowLineDash, Boolean columnLineDash, jpuppeteer.cdp.client.entity.dom.RGBA rowGapColor, jpuppeteer.cdp.client.entity.dom.RGBA rowHatchColor, jpuppeteer.cdp.client.entity.dom.RGBA columnGapColor, jpuppeteer.cdp.client.entity.dom.RGBA columnHatchColor, jpuppeteer.cdp.client.entity.dom.RGBA areaBorderColor, jpuppeteer.cdp.client.entity.dom.RGBA gridBackgroundColor) {
        this.showGridExtensionLines = showGridExtensionLines;
        this.showPositiveLineNumbers = showPositiveLineNumbers;
        this.showNegativeLineNumbers = showNegativeLineNumbers;
        this.showAreaNames = showAreaNames;
        this.showLineNames = showLineNames;
        this.showTrackSizes = showTrackSizes;
        this.gridBorderColor = gridBorderColor;
        this.cellBorderColor = cellBorderColor;
        this.rowLineColor = rowLineColor;
        this.columnLineColor = columnLineColor;
        this.gridBorderDash = gridBorderDash;
        this.cellBorderDash = cellBorderDash;
        this.rowLineDash = rowLineDash;
        this.columnLineDash = columnLineDash;
        this.rowGapColor = rowGapColor;
        this.rowHatchColor = rowHatchColor;
        this.columnGapColor = columnGapColor;
        this.columnHatchColor = columnHatchColor;
        this.areaBorderColor = areaBorderColor;
        this.gridBackgroundColor = gridBackgroundColor;
    }

    public GridHighlightConfig() {
        this.showGridExtensionLines = null;
        this.showPositiveLineNumbers = null;
        this.showNegativeLineNumbers = null;
        this.showAreaNames = null;
        this.showLineNames = null;
        this.showTrackSizes = null;
        this.gridBorderColor = null;
        this.cellBorderColor = null;
        this.rowLineColor = null;
        this.columnLineColor = null;
        this.gridBorderDash = null;
        this.cellBorderDash = null;
        this.rowLineDash = null;
        this.columnLineDash = null;
        this.rowGapColor = null;
        this.rowHatchColor = null;
        this.columnGapColor = null;
        this.columnHatchColor = null;
        this.areaBorderColor = null;
        this.gridBackgroundColor = null;
    }

}