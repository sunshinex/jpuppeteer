package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetStyleTextsResponse {

    /**
    * The resulting styles after modification.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.CSSStyle> styles;

    public void setStyles (java.util.List<jpuppeteer.cdp.client.entity.css.CSSStyle> styles) {
        this.styles = styles;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.CSSStyle> getStyles() {
        return this.styles;
    }

    public SetStyleTextsResponse(java.util.List<jpuppeteer.cdp.client.entity.css.CSSStyle> styles) {
        this.styles = styles;
    }

    public SetStyleTextsResponse() {
    }

}