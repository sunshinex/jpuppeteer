package jpuppeteer.cdp.client.entity.css;

/**
* CSS stylesheet metainformation.
* experimental
*/
public class CSSStyleSheetHeader {

    /**
    * The stylesheet identifier.
    */
    public final String styleSheetId;

    /**
    * Owner frame identifier.
    */
    public final String frameId;

    /**
    * Stylesheet resource URL.
    */
    public final String sourceURL;

    /**
    * URL of source map associated with the stylesheet (if any).
    */
    public final String sourceMapURL;

    /**
    * Stylesheet origin.
    */
    public final jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin;

    /**
    * Stylesheet title.
    */
    public final String title;

    /**
    * The backend id for the owner node of the stylesheet.
    */
    public final Integer ownerNode;

    /**
    * Denotes whether the stylesheet is disabled.
    */
    public final Boolean disabled;

    /**
    * Whether the sourceURL field value comes from the sourceURL comment.
    */
    public final Boolean hasSourceURL;

    /**
    * Whether this stylesheet is created for STYLE tag by parser. This flag is not set for document.written STYLE tags.
    */
    public final Boolean isInline;

    /**
    * Whether this stylesheet is mutable. Inline stylesheets become mutable after they have been modified via CSSOM API. <link> element's stylesheets become mutable only if DevTools modifies them. Constructed stylesheets (new CSSStyleSheet()) are mutable immediately after creation.
    */
    public final Boolean isMutable;

    /**
    * Whether this stylesheet is a constructed stylesheet (created using new CSSStyleSheet()).
    */
    public final Boolean isConstructed;

    /**
    * Line offset of the stylesheet within the resource (zero based).
    */
    public final java.math.BigDecimal startLine;

    /**
    * Column offset of the stylesheet within the resource (zero based).
    */
    public final java.math.BigDecimal startColumn;

    /**
    * Size of the content (in characters).
    */
    public final java.math.BigDecimal length;

    /**
    * Line offset of the end of the stylesheet within the resource (zero based).
    */
    public final java.math.BigDecimal endLine;

    /**
    * Column offset of the end of the stylesheet within the resource (zero based).
    */
    public final java.math.BigDecimal endColumn;

    public CSSStyleSheetHeader(String styleSheetId, String frameId, String sourceURL, String sourceMapURL, jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin, String title, Integer ownerNode, Boolean disabled, Boolean hasSourceURL, Boolean isInline, Boolean isMutable, Boolean isConstructed, java.math.BigDecimal startLine, java.math.BigDecimal startColumn, java.math.BigDecimal length, java.math.BigDecimal endLine, java.math.BigDecimal endColumn) {
        this.styleSheetId = styleSheetId;
        this.frameId = frameId;
        this.sourceURL = sourceURL;
        this.sourceMapURL = sourceMapURL;
        this.origin = origin;
        this.title = title;
        this.ownerNode = ownerNode;
        this.disabled = disabled;
        this.hasSourceURL = hasSourceURL;
        this.isInline = isInline;
        this.isMutable = isMutable;
        this.isConstructed = isConstructed;
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.length = length;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public CSSStyleSheetHeader(String styleSheetId, String frameId, String sourceURL, jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin, String title, Boolean disabled, Boolean isInline, Boolean isMutable, Boolean isConstructed, java.math.BigDecimal startLine, java.math.BigDecimal startColumn, java.math.BigDecimal length, java.math.BigDecimal endLine, java.math.BigDecimal endColumn) {
        this.styleSheetId = styleSheetId;
        this.frameId = frameId;
        this.sourceURL = sourceURL;
        this.sourceMapURL = null;
        this.origin = origin;
        this.title = title;
        this.ownerNode = null;
        this.disabled = disabled;
        this.hasSourceURL = null;
        this.isInline = isInline;
        this.isMutable = isMutable;
        this.isConstructed = isConstructed;
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.length = length;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

}