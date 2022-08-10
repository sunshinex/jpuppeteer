package jpuppeteer.cdp.client.entity.css;

/**
* CSS coverage information.
* experimental
*/
public class RuleUsage {

    /**
    * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
    */
    private String styleSheetId;

    /**
    * Offset of the start of the rule (including selector) from the beginning of the stylesheet.
    */
    private java.math.BigDecimal startOffset;

    /**
    * Offset of the end of the rule body from the beginning of the stylesheet.
    */
    private java.math.BigDecimal endOffset;

    /**
    * Indicates whether the rule was actually used by some element in the page.
    */
    private Boolean used;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setStartOffset (java.math.BigDecimal startOffset) {
        this.startOffset = startOffset;
    }

    public java.math.BigDecimal getStartOffset() {
        return this.startOffset;
    }

    public void setEndOffset (java.math.BigDecimal endOffset) {
        this.endOffset = endOffset;
    }

    public java.math.BigDecimal getEndOffset() {
        return this.endOffset;
    }

    public void setUsed (Boolean used) {
        this.used = used;
    }

    public Boolean getUsed() {
        return this.used;
    }

    public RuleUsage(String styleSheetId, java.math.BigDecimal startOffset, java.math.BigDecimal endOffset, Boolean used) {
        this.styleSheetId = styleSheetId;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.used = used;
    }

    public RuleUsage() {
    }

}