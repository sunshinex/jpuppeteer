package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetStyleTextsResponse {

    /**
    * The resulting styles after modification.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.CSSStyle> styles;

    public SetStyleTextsResponse(java.util.List<jpuppeteer.cdp.client.entity.css.CSSStyle> styles) {
        this.styles = styles;
    }

}