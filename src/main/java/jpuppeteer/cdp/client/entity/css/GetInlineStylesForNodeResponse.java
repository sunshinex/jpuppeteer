package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetInlineStylesForNodeResponse {

    /**
    * Inline style for the specified DOM node.
    */
    public final jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle;

    /**
    * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
    */
    public final jpuppeteer.cdp.client.entity.css.CSSStyle attributesStyle;

    public GetInlineStylesForNodeResponse(jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle, jpuppeteer.cdp.client.entity.css.CSSStyle attributesStyle) {
        this.inlineStyle = inlineStyle;
        this.attributesStyle = attributesStyle;
    }

    public GetInlineStylesForNodeResponse() {
        this.inlineStyle = null;
        this.attributesStyle = null;
    }

}