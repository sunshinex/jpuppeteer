package jpuppeteer.cdp.client.entity.css;

/**
* CSS coverage information.
* experimental
*/
public class RuleUsage {

    /**
    * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
    */
    public final String styleSheetId;

    /**
    * Offset of the start of the rule (including selector) from the beginning of the stylesheet.
    */
    public final java.math.BigDecimal startOffset;

    /**
    * Offset of the end of the rule body from the beginning of the stylesheet.
    */
    public final java.math.BigDecimal endOffset;

    /**
    * Indicates whether the rule was actually used by some element in the page.
    */
    public final Boolean used;

    public RuleUsage(String styleSheetId, java.math.BigDecimal startOffset, java.math.BigDecimal endOffset, Boolean used) {
        this.styleSheetId = styleSheetId;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.used = used;
    }

}