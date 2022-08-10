package jpuppeteer.cdp.client.entity.page;

/**
*/
public class PrintToPDFRequest {

    /**
    * Paper orientation. Defaults to false.
    */
    private Boolean landscape;

    /**
    * Display header and footer. Defaults to false.
    */
    private Boolean displayHeaderFooter;

    /**
    * Print background graphics. Defaults to false.
    */
    private Boolean printBackground;

    /**
    * Scale of the webpage rendering. Defaults to 1.
    */
    private java.math.BigDecimal scale;

    /**
    * Paper width in inches. Defaults to 8.5 inches.
    */
    private java.math.BigDecimal paperWidth;

    /**
    * Paper height in inches. Defaults to 11 inches.
    */
    private java.math.BigDecimal paperHeight;

    /**
    * Top margin in inches. Defaults to 1cm (~0.4 inches).
    */
    private java.math.BigDecimal marginTop;

    /**
    * Bottom margin in inches. Defaults to 1cm (~0.4 inches).
    */
    private java.math.BigDecimal marginBottom;

    /**
    * Left margin in inches. Defaults to 1cm (~0.4 inches).
    */
    private java.math.BigDecimal marginLeft;

    /**
    * Right margin in inches. Defaults to 1cm (~0.4 inches).
    */
    private java.math.BigDecimal marginRight;

    /**
    * Paper ranges to print, e.g., '1-5, 8, 11-13'. Defaults to the empty string, which means print all pages.
    */
    private String pageRanges;

    /**
    * Whether to silently ignore invalid but successfully parsed page ranges, such as '3-2'. Defaults to false.
    */
    private Boolean ignoreInvalidPageRanges;

    /**
    * HTML template for the print header. Should be valid HTML markup with following classes used to inject printing values into them: - `date`: formatted print date - `title`: document title - `url`: document location - `pageNumber`: current page number - `totalPages`: total pages in the document  For example, `<span class=title></span>` would generate span containing the title.
    */
    private String headerTemplate;

    /**
    * HTML template for the print footer. Should use the same format as the `headerTemplate`.
    */
    private String footerTemplate;

    /**
    * Whether or not to prefer page size as defined by css. Defaults to false, in which case the content will be scaled to fit the paper size.
    */
    private Boolean preferCSSPageSize;

    /**
    * return as stream
    */
    private jpuppeteer.cdp.client.constant.page.PrintToPDFRequestTransferMode transferMode;

    public void setLandscape (Boolean landscape) {
        this.landscape = landscape;
    }

    public Boolean getLandscape() {
        return this.landscape;
    }

    public void setDisplayHeaderFooter (Boolean displayHeaderFooter) {
        this.displayHeaderFooter = displayHeaderFooter;
    }

    public Boolean getDisplayHeaderFooter() {
        return this.displayHeaderFooter;
    }

    public void setPrintBackground (Boolean printBackground) {
        this.printBackground = printBackground;
    }

    public Boolean getPrintBackground() {
        return this.printBackground;
    }

    public void setScale (java.math.BigDecimal scale) {
        this.scale = scale;
    }

    public java.math.BigDecimal getScale() {
        return this.scale;
    }

    public void setPaperWidth (java.math.BigDecimal paperWidth) {
        this.paperWidth = paperWidth;
    }

    public java.math.BigDecimal getPaperWidth() {
        return this.paperWidth;
    }

    public void setPaperHeight (java.math.BigDecimal paperHeight) {
        this.paperHeight = paperHeight;
    }

    public java.math.BigDecimal getPaperHeight() {
        return this.paperHeight;
    }

    public void setMarginTop (java.math.BigDecimal marginTop) {
        this.marginTop = marginTop;
    }

    public java.math.BigDecimal getMarginTop() {
        return this.marginTop;
    }

    public void setMarginBottom (java.math.BigDecimal marginBottom) {
        this.marginBottom = marginBottom;
    }

    public java.math.BigDecimal getMarginBottom() {
        return this.marginBottom;
    }

    public void setMarginLeft (java.math.BigDecimal marginLeft) {
        this.marginLeft = marginLeft;
    }

    public java.math.BigDecimal getMarginLeft() {
        return this.marginLeft;
    }

    public void setMarginRight (java.math.BigDecimal marginRight) {
        this.marginRight = marginRight;
    }

    public java.math.BigDecimal getMarginRight() {
        return this.marginRight;
    }

    public void setPageRanges (String pageRanges) {
        this.pageRanges = pageRanges;
    }

    public String getPageRanges() {
        return this.pageRanges;
    }

    public void setIgnoreInvalidPageRanges (Boolean ignoreInvalidPageRanges) {
        this.ignoreInvalidPageRanges = ignoreInvalidPageRanges;
    }

    public Boolean getIgnoreInvalidPageRanges() {
        return this.ignoreInvalidPageRanges;
    }

    public void setHeaderTemplate (String headerTemplate) {
        this.headerTemplate = headerTemplate;
    }

    public String getHeaderTemplate() {
        return this.headerTemplate;
    }

    public void setFooterTemplate (String footerTemplate) {
        this.footerTemplate = footerTemplate;
    }

    public String getFooterTemplate() {
        return this.footerTemplate;
    }

    public void setPreferCSSPageSize (Boolean preferCSSPageSize) {
        this.preferCSSPageSize = preferCSSPageSize;
    }

    public Boolean getPreferCSSPageSize() {
        return this.preferCSSPageSize;
    }

    public void setTransferMode (jpuppeteer.cdp.client.constant.page.PrintToPDFRequestTransferMode transferMode) {
        this.transferMode = transferMode;
    }

    public jpuppeteer.cdp.client.constant.page.PrintToPDFRequestTransferMode getTransferMode() {
        return this.transferMode;
    }

    public PrintToPDFRequest(Boolean landscape, Boolean displayHeaderFooter, Boolean printBackground, java.math.BigDecimal scale, java.math.BigDecimal paperWidth, java.math.BigDecimal paperHeight, java.math.BigDecimal marginTop, java.math.BigDecimal marginBottom, java.math.BigDecimal marginLeft, java.math.BigDecimal marginRight, String pageRanges, Boolean ignoreInvalidPageRanges, String headerTemplate, String footerTemplate, Boolean preferCSSPageSize, jpuppeteer.cdp.client.constant.page.PrintToPDFRequestTransferMode transferMode) {
        this.landscape = landscape;
        this.displayHeaderFooter = displayHeaderFooter;
        this.printBackground = printBackground;
        this.scale = scale;
        this.paperWidth = paperWidth;
        this.paperHeight = paperHeight;
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
        this.pageRanges = pageRanges;
        this.ignoreInvalidPageRanges = ignoreInvalidPageRanges;
        this.headerTemplate = headerTemplate;
        this.footerTemplate = footerTemplate;
        this.preferCSSPageSize = preferCSSPageSize;
        this.transferMode = transferMode;
    }

    public PrintToPDFRequest() {
        this.landscape = null;
        this.displayHeaderFooter = null;
        this.printBackground = null;
        this.scale = null;
        this.paperWidth = null;
        this.paperHeight = null;
        this.marginTop = null;
        this.marginBottom = null;
        this.marginLeft = null;
        this.marginRight = null;
        this.pageRanges = null;
        this.ignoreInvalidPageRanges = null;
        this.headerTemplate = null;
        this.footerTemplate = null;
        this.preferCSSPageSize = null;
        this.transferMode = null;
    }

}