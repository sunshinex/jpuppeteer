package jpuppeteer.cdp.client.entity.css;

/**
* CSS rule representation.
* experimental
*/
public class CSSRule {

    /**
    * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
    */
    private String styleSheetId;

    /**
    * Rule selector data.
    */
    private jpuppeteer.cdp.client.entity.css.SelectorList selectorList;

    /**
    * Parent stylesheet's origin.
    */
    private jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin;

    /**
    * Associated style declaration.
    */
    private jpuppeteer.cdp.client.entity.css.CSSStyle style;

    /**
    * Media list array (for rules involving media queries). The array enumerates media queries starting with the innermost one, going outwards.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.CSSMedia> media;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setSelectorList (jpuppeteer.cdp.client.entity.css.SelectorList selectorList) {
        this.selectorList = selectorList;
    }

    public jpuppeteer.cdp.client.entity.css.SelectorList getSelectorList() {
        return this.selectorList;
    }

    public void setOrigin (jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin) {
        this.origin = origin;
    }

    public jpuppeteer.cdp.client.constant.css.StyleSheetOrigin getOrigin() {
        return this.origin;
    }

    public void setStyle (jpuppeteer.cdp.client.entity.css.CSSStyle style) {
        this.style = style;
    }

    public jpuppeteer.cdp.client.entity.css.CSSStyle getStyle() {
        return this.style;
    }

    public void setMedia (java.util.List<jpuppeteer.cdp.client.entity.css.CSSMedia> media) {
        this.media = media;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.CSSMedia> getMedia() {
        return this.media;
    }

    public CSSRule(String styleSheetId, jpuppeteer.cdp.client.entity.css.SelectorList selectorList, jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin, jpuppeteer.cdp.client.entity.css.CSSStyle style, java.util.List<jpuppeteer.cdp.client.entity.css.CSSMedia> media) {
        this.styleSheetId = styleSheetId;
        this.selectorList = selectorList;
        this.origin = origin;
        this.style = style;
        this.media = media;
    }

    public CSSRule(jpuppeteer.cdp.client.entity.css.SelectorList selectorList, jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin, jpuppeteer.cdp.client.entity.css.CSSStyle style) {
        this.styleSheetId = null;
        this.selectorList = selectorList;
        this.origin = origin;
        this.style = style;
        this.media = null;
    }

    public CSSRule() {
    }

}