package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetInlineStylesForNodeResponse {

    /**
    * Inline style for the specified DOM node.
    */
    public final CSSStyle inlineStyle;

    /**
    * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
    */
    public final CSSStyle attributesStyle;

    public GetInlineStylesForNodeResponse(CSSStyle inlineStyle, CSSStyle attributesStyle) {
        this.inlineStyle = inlineStyle;
        this.attributesStyle = attributesStyle;
    }

    public GetInlineStylesForNodeResponse() {
        this.inlineStyle = null;
        this.attributesStyle = null;
    }

}