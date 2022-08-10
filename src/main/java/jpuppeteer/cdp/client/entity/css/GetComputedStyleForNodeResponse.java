package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetComputedStyleForNodeResponse {

    /**
    * Computed style for the specified DOM node.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> computedStyle;

    public void setComputedStyle (java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> computedStyle) {
        this.computedStyle = computedStyle;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> getComputedStyle() {
        return this.computedStyle;
    }

    public GetComputedStyleForNodeResponse(java.util.List<jpuppeteer.cdp.client.entity.css.CSSComputedStyleProperty> computedStyle) {
        this.computedStyle = computedStyle;
    }

    public GetComputedStyleForNodeResponse() {
    }

}