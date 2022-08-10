package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for the highlighting of Grid elements.
* experimental
*/
public class GridHighlightConfig {

    /**
    * Whether the extension lines from grid cells to the rulers should be shown (default: false).
    */
    private Boolean showGridExtensionLines;

    /**
    * Show Positive line number labels (default: false).
    */
    private Boolean showPositiveLineNumbers;

    /**
    * Show Negative line number labels (default: false).
    */
    private Boolean showNegativeLineNumbers;

    /**
    * Show area name labels (default: false).
    */
    private Boolean showAreaNames;

    /**
    * Show line name labels (default: false).
    */
    private Boolean showLineNames;

    /**
    * Show track size labels (default: false).
    */
    private Boolean showTrackSizes;

    /**
    * The grid container border highlight color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA gridBorderColor;

    /**
    * The cell border color (default: transparent). Deprecated, please use rowLineColor and columnLineColor instead.
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA cellBorderColor;

    /**
    * The row line color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA rowLineColor;

    /**
    * The column line color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA columnLineColor;

    /**
    * Whether the grid border is dashed (default: false).
    */
    private Boolean gridBorderDash;

    /**
    * Whether the cell border is dashed (default: false). Deprecated, please us rowLineDash and columnLineDash instead.
    */
    private Boolean cellBorderDash;

    /**
    * Whether row lines are dashed (default: false).
    */
    private Boolean rowLineDash;

    /**
    * Whether column lines are dashed (default: false).
    */
    private Boolean columnLineDash;

    /**
    * The row gap highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA rowGapColor;

    /**
    * The row gap hatching fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA rowHatchColor;

    /**
    * The column gap highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA columnGapColor;

    /**
    * The column gap hatching fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA columnHatchColor;

    /**
    * The named grid areas border color (Default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA areaBorderColor;

    /**
    * The grid container background color (Default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA gridBackgroundColor;

    public void setShowGridExtensionLines (Boolean showGridExtensionLines) {
        this.showGridExtensionLines = showGridExtensionLines;
    }

    public Boolean getShowGridExtensionLines() {
        return this.showGridExtensionLines;
    }

    public void setShowPositiveLineNumbers (Boolean showPositiveLineNumbers) {
        this.showPositiveLineNumbers = showPositiveLineNumbers;
    }

    public Boolean getShowPositiveLineNumbers() {
        return this.showPositiveLineNumbers;
    }

    public void setShowNegativeLineNumbers (Boolean showNegativeLineNumbers) {
        this.showNegativeLineNumbers = showNegativeLineNumbers;
    }

    public Boolean getShowNegativeLineNumbers() {
        return this.showNegativeLineNumbers;
    }

    public void setShowAreaNames (Boolean showAreaNames) {
        this.showAreaNames = showAreaNames;
    }

    public Boolean getShowAreaNames() {
        return this.showAreaNames;
    }

    public void setShowLineNames (Boolean showLineNames) {
        this.showLineNames = showLineNames;
    }

    public Boolean getShowLineNames() {
        return this.showLineNames;
    }

    public void setShowTrackSizes (Boolean showTrackSizes) {
        this.showTrackSizes = showTrackSizes;
    }

    public Boolean getShowTrackSizes() {
        return this.showTrackSizes;
    }

    public void setGridBorderColor (jpuppeteer.cdp.client.entity.dom.RGBA gridBorderColor) {
        this.gridBorderColor = gridBorderColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getGridBorderColor() {
        return this.gridBorderColor;
    }

    public void setCellBorderColor (jpuppeteer.cdp.client.entity.dom.RGBA cellBorderColor) {
        this.cellBorderColor = cellBorderColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getCellBorderColor() {
        return this.cellBorderColor;
    }

    public void setRowLineColor (jpuppeteer.cdp.client.entity.dom.RGBA rowLineColor) {
        this.rowLineColor = rowLineColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getRowLineColor() {
        return this.rowLineColor;
    }

    public void setColumnLineColor (jpuppeteer.cdp.client.entity.dom.RGBA columnLineColor) {
        this.columnLineColor = columnLineColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getColumnLineColor() {
        return this.columnLineColor;
    }

    public void setGridBorderDash (Boolean gridBorderDash) {
        this.gridBorderDash = gridBorderDash;
    }

    public Boolean getGridBorderDash() {
        return this.gridBorderDash;
    }

    public void setCellBorderDash (Boolean cellBorderDash) {
        this.cellBorderDash = cellBorderDash;
    }

    public Boolean getCellBorderDash() {
        return this.cellBorderDash;
    }

    public void setRowLineDash (Boolean rowLineDash) {
        this.rowLineDash = rowLineDash;
    }

    public Boolean getRowLineDash() {
        return this.rowLineDash;
    }

    public void setColumnLineDash (Boolean columnLineDash) {
        this.columnLineDash = columnLineDash;
    }

    public Boolean getColumnLineDash() {
        return this.columnLineDash;
    }

    public void setRowGapColor (jpuppeteer.cdp.client.entity.dom.RGBA rowGapColor) {
        this.rowGapColor = rowGapColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getRowGapColor() {
        return this.rowGapColor;
    }

    public void setRowHatchColor (jpuppeteer.cdp.client.entity.dom.RGBA rowHatchColor) {
        this.rowHatchColor = rowHatchColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getRowHatchColor() {
        return this.rowHatchColor;
    }

    public void setColumnGapColor (jpuppeteer.cdp.client.entity.dom.RGBA columnGapColor) {
        this.columnGapColor = columnGapColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getColumnGapColor() {
        return this.columnGapColor;
    }

    public void setColumnHatchColor (jpuppeteer.cdp.client.entity.dom.RGBA columnHatchColor) {
        this.columnHatchColor = columnHatchColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getColumnHatchColor() {
        return this.columnHatchColor;
    }

    public void setAreaBorderColor (jpuppeteer.cdp.client.entity.dom.RGBA areaBorderColor) {
        this.areaBorderColor = areaBorderColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getAreaBorderColor() {
        return this.areaBorderColor;
    }

    public void setGridBackgroundColor (jpuppeteer.cdp.client.entity.dom.RGBA gridBackgroundColor) {
        this.gridBackgroundColor = gridBackgroundColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getGridBackgroundColor() {
        return this.gridBackgroundColor;
    }

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