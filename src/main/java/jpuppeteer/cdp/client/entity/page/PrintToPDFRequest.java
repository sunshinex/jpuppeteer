package jpuppeteer.cdp.client.entity.page;

/**
*/
public class PrintToPDFRequest {

    /**
    * Paper orientation. Defaults to false.
    */
    public final Boolean landscape;

    /**
    * Display header and footer. Defaults to false.
    */
    public final Boolean displayHeaderFooter;

    /**
    * Print background graphics. Defaults to false.
    */
    public final Boolean printBackground;

    /**
    * Scale of the webpage rendering. Defaults to 1.
    */
    public final java.math.BigDecimal scale;

    /**
    * Paper width in inches. Defaults to 8.5 inches.
    */
    public final java.math.BigDecimal paperWidth;

    /**
    * Paper height in inches. Defaults to 11 inches.
    */
    public final java.math.BigDecimal paperHeight;

    /**
    * Top margin in inches. Defaults to 1cm (~0.4 inches).
    */
    public final java.math.BigDecimal marginTop;

    /**
    * Bottom margin in inches. Defaults to 1cm (~0.4 inches).
    */
    public final java.math.BigDecimal marginBottom;

    /**
    * Left margin in inches. Defaults to 1cm (~0.4 inches).
    */
    public final java.math.BigDecimal marginLeft;

    /**
    * Right margin in inches. Defaults to 1cm (~0.4 inches).
    */
    public final java.math.BigDecimal marginRight;

    /**
    * Paper ranges to print, e.g., '1-5, 8, 11-13'. Defaults to the empty string, which means print all pages.
    */
    public final String pageRanges;

    /**
    * Whether to silently ignore invalid but successfully parsed page ranges, such as '3-2'. Defaults to false.
    */
    public final Boolean ignoreInvalidPageRanges;

    /**
    * HTML template for the print header. Should be valid HTML markup with following classes used to inject printing values into them: - `date`: formatted print date - `title`: document title - `url`: document location - `pageNumber`: current page number - `totalPages`: total pages in the document  For example, `<span class=title></span>` would generate span containing the title.
    */
    public final String headerTemplate;

    /**
    * HTML template for the print footer. Should use the same format as the `headerTemplate`.
    */
    public final String footerTemplate;

    /**
    * Whether or not to prefer page size as defined by css. Defaults to false, in which case the content will be scaled to fit the paper size.
    */
    public final Boolean preferCSSPageSize;

    /**
    * return as stream
    */
    public final String transferMode;

    public PrintToPDFRequest(Boolean landscape, Boolean displayHeaderFooter, Boolean printBackground, java.math.BigDecimal scale, java.math.BigDecimal paperWidth, java.math.BigDecimal paperHeight, java.math.BigDecimal marginTop, java.math.BigDecimal marginBottom, java.math.BigDecimal marginLeft, java.math.BigDecimal marginRight, String pageRanges, Boolean ignoreInvalidPageRanges, String headerTemplate, String footerTemplate, Boolean preferCSSPageSize, String transferMode) {
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