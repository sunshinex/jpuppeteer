package jpuppeteer.cdp.client.entity.css;

/**
* CSS rule representation.
* experimental
*/
public class CSSRule {

    /**
    * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
    */
    public final String styleSheetId;

    /**
    * Rule selector data.
    */
    public final SelectorList selectorList;

    /**
    * Parent stylesheet's origin.
    */
    public final jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin;

    /**
    * Associated style declaration.
    */
    public final CSSStyle style;

    /**
    * Media list array (for rules involving media queries). The array enumerates media queries starting with the innermost one, going outwards.
    */
    public final java.util.List<CSSMedia> media;

    public CSSRule(String styleSheetId, SelectorList selectorList, jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin, CSSStyle style, java.util.List<CSSMedia> media) {
        this.styleSheetId = styleSheetId;
        this.selectorList = selectorList;
        this.origin = origin;
        this.style = style;
        this.media = media;
    }

    public CSSRule(SelectorList selectorList, jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin, CSSStyle style) {
        this.styleSheetId = null;
        this.selectorList = selectorList;
        this.origin = origin;
        this.style = style;
        this.media = null;
    }

}