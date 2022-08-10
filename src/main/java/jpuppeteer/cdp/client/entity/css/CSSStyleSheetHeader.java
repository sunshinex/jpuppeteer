package jpuppeteer.cdp.client.entity.css;

/**
* CSS stylesheet metainformation.
* experimental
*/
public class CSSStyleSheetHeader {

    /**
    * The stylesheet identifier.
    */
    private String styleSheetId;

    /**
    * Owner frame identifier.
    */
    private String frameId;

    /**
    * Stylesheet resource URL.
    */
    private String sourceURL;

    /**
    * URL of source map associated with the stylesheet (if any).
    */
    private String sourceMapURL;

    /**
    * Stylesheet origin.
    */
    private jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin;

    /**
    * Stylesheet title.
    */
    private String title;

    /**
    * The backend id for the owner node of the stylesheet.
    */
    private Integer ownerNode;

    /**
    * Denotes whether the stylesheet is disabled.
    */
    private Boolean disabled;

    /**
    * Whether the sourceURL field value comes from the sourceURL comment.
    */
    private Boolean hasSourceURL;

    /**
    * Whether this stylesheet is created for STYLE tag by parser. This flag is not set for document.written STYLE tags.
    */
    private Boolean isInline;

    /**
    * Whether this stylesheet is mutable. Inline stylesheets become mutable after they have been modified via CSSOM API. <link> element's stylesheets become mutable only if DevTools modifies them. Constructed stylesheets (new CSSStyleSheet()) are mutable immediately after creation.
    */
    private Boolean isMutable;

    /**
    * Whether this stylesheet is a constructed stylesheet (created using new CSSStyleSheet()).
    */
    private Boolean isConstructed;

    /**
    * Line offset of the stylesheet within the resource (zero based).
    */
    private java.math.BigDecimal startLine;

    /**
    * Column offset of the stylesheet within the resource (zero based).
    */
    private java.math.BigDecimal startColumn;

    /**
    * Size of the content (in characters).
    */
    private java.math.BigDecimal length;

    /**
    * Line offset of the end of the stylesheet within the resource (zero based).
    */
    private java.math.BigDecimal endLine;

    /**
    * Column offset of the end of the stylesheet within the resource (zero based).
    */
    private java.math.BigDecimal endColumn;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setSourceURL (String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getSourceURL() {
        return this.sourceURL;
    }

    public void setSourceMapURL (String sourceMapURL) {
        this.sourceMapURL = sourceMapURL;
    }

    public String getSourceMapURL() {
        return this.sourceMapURL;
    }

    public void setOrigin (jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin) {
        this.origin = origin;
    }

    public jpuppeteer.cdp.client.constant.css.StyleSheetOrigin getOrigin() {
        return this.origin;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setOwnerNode (Integer ownerNode) {
        this.ownerNode = ownerNode;
    }

    public Integer getOwnerNode() {
        return this.ownerNode;
    }

    public void setDisabled (Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getDisabled() {
        return this.disabled;
    }

    public void setHasSourceURL (Boolean hasSourceURL) {
        this.hasSourceURL = hasSourceURL;
    }

    public Boolean getHasSourceURL() {
        return this.hasSourceURL;
    }

    public void setIsInline (Boolean isInline) {
        this.isInline = isInline;
    }

    public Boolean getIsInline() {
        return this.isInline;
    }

    public void setIsMutable (Boolean isMutable) {
        this.isMutable = isMutable;
    }

    public Boolean getIsMutable() {
        return this.isMutable;
    }

    public void setIsConstructed (Boolean isConstructed) {
        this.isConstructed = isConstructed;
    }

    public Boolean getIsConstructed() {
        return this.isConstructed;
    }

    public void setStartLine (java.math.BigDecimal startLine) {
        this.startLine = startLine;
    }

    public java.math.BigDecimal getStartLine() {
        return this.startLine;
    }

    public void setStartColumn (java.math.BigDecimal startColumn) {
        this.startColumn = startColumn;
    }

    public java.math.BigDecimal getStartColumn() {
        return this.startColumn;
    }

    public void setLength (java.math.BigDecimal length) {
        this.length = length;
    }

    public java.math.BigDecimal getLength() {
        return this.length;
    }

    public void setEndLine (java.math.BigDecimal endLine) {
        this.endLine = endLine;
    }

    public java.math.BigDecimal getEndLine() {
        return this.endLine;
    }

    public void setEndColumn (java.math.BigDecimal endColumn) {
        this.endColumn = endColumn;
    }

    public java.math.BigDecimal getEndColumn() {
        return this.endColumn;
    }

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

    public CSSStyleSheetHeader() {
    }

}