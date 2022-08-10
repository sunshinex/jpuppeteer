package jpuppeteer.cdp.client.entity.css;

/**
* CSS keyframe rule representation.
* experimental
*/
public class CSSKeyframeRule {

    /**
    * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
    */
    private String styleSheetId;

    /**
    * Parent stylesheet's origin.
    */
    private jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin;

    /**
    * Associated key text.
    */
    private jpuppeteer.cdp.client.entity.css.Value keyText;

    /**
    * Associated style declaration.
    */
    private jpuppeteer.cdp.client.entity.css.CSSStyle style;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setOrigin (jpuppeteer.cdp.client.constant.css.StyleSheetOrigin origin) {
        this.origin = origin;
    }

    public jpuppeteer.cdp.client.constant.css.StyleSheetOrigin getOrigin() {
        return this.origin;
    }

    public void setKeyText (jpuppeteer.cdp.client.entity.css.Value keyText) {
        this.keyText = keyText;
    }

    public jpuppeteer.cdp.client.entity.css.Value getKeyText() {
        return this.keyText;
    }

    public void setStyle (jpuppeteer.cdp.client.entity.css.CSSStyle style) {
        this.style = style;
    }

    public jpuppeteer.cdp.client.entity.css.CSSStyle getStyle() {
        return this.style;
    }

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

    public CSSKeyframeRule() {
    }

}