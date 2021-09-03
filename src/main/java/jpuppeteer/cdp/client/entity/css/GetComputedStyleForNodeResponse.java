package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetComputedStyleForNodeResponse {

    /**
    * Computed style for the specified DOM node.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> computedStyle;

    public GetComputedStyleForNodeResponse(java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> computedStyle) {
        this.computedStyle = computedStyle;
    }

}