package jpuppeteer.cdp.client.entity.css;

/**
* CSS style representation.
* experimental
*/
public class CSSStyle {

    /**
    * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
    */
    private String styleSheetId;

    /**
    * CSS properties in the style.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.CSSProperty> cssProperties;

    /**
    * Computed values for all shorthands found in the style.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.ShorthandEntry> shorthandEntries;

    /**
    * Style declaration text (if available).
    */
    private String cssText;

    /**
    * Style declaration range in the enclosing stylesheet (if available).
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange range;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setCssProperties (java.util.List<jpuppeteer.cdp.client.entity.css.CSSProperty> cssProperties) {
        this.cssProperties = cssProperties;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.CSSProperty> getCssProperties() {
        return this.cssProperties;
    }

    public void setShorthandEntries (java.util.List<jpuppeteer.cdp.client.entity.css.ShorthandEntry> shorthandEntries) {
        this.shorthandEntries = shorthandEntries;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.ShorthandEntry> getShorthandEntries() {
        return this.shorthandEntries;
    }

    public void setCssText (String cssText) {
        this.cssText = cssText;
    }

    public String getCssText() {
        return this.cssText;
    }

    public void setRange (jpuppeteer.cdp.client.entity.css.SourceRange range) {
        this.range = range;
    }

    public jpuppeteer.cdp.client.entity.css.SourceRange getRange() {
        return this.range;
    }

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

    public CSSStyle() {
    }

}