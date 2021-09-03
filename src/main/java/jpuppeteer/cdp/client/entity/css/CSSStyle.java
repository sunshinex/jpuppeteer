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
    public final java.util.List<jpuppeteer.cdp.client.entity.css.CSSProperty> cssProperties;

    /**
    * Computed values for all shorthands found in the style.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.ShorthandEntry> shorthandEntries;

    /**
    * Style declaration text (if available).
    */
    public final String cssText;

    /**
    * Style declaration range in the enclosing stylesheet (if available).
    */
    public final jpuppeteer.cdp.client.entity.css.SourceRange range;

    public CSSStyle(String styleSheetId, java.util.List<jpuppeteer.cdp.client.entity.css.CSSProperty> cssProperties, java.util.List<jpuppeteer.cdp.client.entity.css.ShorthandEntry> shorthandEntries, String cssText, jpuppeteer.cdp.client.entity.css.SourceRange range) {
        this.styleSheetId = styleSheetId;
        this.cssProperties = cssProperties;
        this.shorthandEntries = shorthandEntries;
        this.cssText = cssText;
        this.range = range;
    }

    public CSSStyle(java.util.List<jpuppeteer.cdp.client.entity.css.CSSProperty> cssProperties, java.util.List<jpuppeteer.cdp.client.entity.css.ShorthandEntry> shorthandEntries) {
        this.styleSheetId = null;
        this.cssProperties = cssProperties;
        this.shorthandEntries = shorthandEntries;
        this.cssText = null;
        this.range = null;
    }

}