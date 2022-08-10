package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetInlineStylesForNodeResponse {

    /**
    * Inline style for the specified DOM node.
    */
    private jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle;

    /**
    * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
    */
    private jpuppeteer.cdp.client.entity.css.CSSStyle attributesStyle;

    public void setInlineStyle (jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle) {
        this.inlineStyle = inlineStyle;
    }

    public jpuppeteer.cdp.client.entity.css.CSSStyle getInlineStyle() {
        return this.inlineStyle;
    }

    public void setAttributesStyle (jpuppeteer.cdp.client.entity.css.CSSStyle attributesStyle) {
        this.attributesStyle = attributesStyle;
    }

    public jpuppeteer.cdp.client.entity.css.CSSStyle getAttributesStyle() {
        return this.attributesStyle;
    }

    public GetInlineStylesForNodeResponse(jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle, jpuppeteer.cdp.client.entity.css.CSSStyle attributesStyle) {
        this.inlineStyle = inlineStyle;
        this.attributesStyle = attributesStyle;
    }

    public GetInlineStylesForNodeResponse() {
        this.inlineStyle = null;
        this.attributesStyle = null;
    }

}