package jpuppeteer.cdp.client.entity.css;

/**
* CSS keyframe rule representation.
* experimental
*/
public class CSSKeyframeRule {

    /**
    * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
    */
    public final String styleSheetId;

    /**
    * Parent stylesheet's origin.
    */
    public final jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin;

    /**
    * Associated key text.
    */
    public final jpuppeteer.cdp.client.entity.css.Value keyText;

    /**
    * Associated style declaration.
    */
    public final jpuppeteer.cdp.client.entity.css.CSSStyle style;

    public CSSKeyframeRule(String styleSheetId, jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin, jpuppeteer.cdp.client.entity.css.Value keyText, jpuppeteer.cdp.client.entity.css.CSSStyle style) {
        this.styleSheetId = styleSheetId;
        this.origin = origin;
        this.keyText = keyText;
        this.style = style;
    }

    public CSSKeyframeRule(jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin, jpuppeteer.cdp.client.entity.css.Value keyText, jpuppeteer.cdp.client.entity.css.CSSStyle style) {
        this.styleSheetId = null;
        this.origin = origin;
        this.keyText = keyText;
        this.style = style;
    }

}