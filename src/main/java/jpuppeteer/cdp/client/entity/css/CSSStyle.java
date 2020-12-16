package jpuppeteer.cdp.client.entity.css;

/**
* CSS style representation.
* experimental
*/
public class CSSStyle {

    /**
    * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
    */
    public final String styleSheetId;

    /**
    * CSS properties in the style.
    */
    public final java.util.List<CSSProperty> cssProperties;

    /**
    * Computed values for all shorthands found in the style.
    */
    public final java.util.List<ShorthandEntry> shorthandEntries;

    /**
    * Style declaration text (if available).
    */
    public final String cssText;

    /**
    * Style declaration range in the enclosing stylesheet (if available).
    */
    public final SourceRange range;

    public CSSStyle(String styleSheetId, java.util.List<CSSProperty> cssProperties, java.util.List<ShorthandEntry> shorthandEntries, String cssText, SourceRange range) {
        this.styleSheetId = styleSheetId;
        this.cssProperties = cssProperties;
        this.shorthandEntries = shorthandEntries;
        this.cssText = cssText;
        this.range = range;
    }

    public CSSStyle(java.util.List<CSSProperty> cssProperties, java.util.List<ShorthandEntry> shorthandEntries) {
        this.styleSheetId = null;
        this.cssProperties = cssProperties;
        this.shorthandEntries = shorthandEntries;
        this.cssText = null;
        this.range = null;
    }

}