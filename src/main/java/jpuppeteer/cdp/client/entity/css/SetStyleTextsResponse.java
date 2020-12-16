package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetStyleTextsResponse {

    /**
    * The resulting styles after modification.
    */
    public final java.util.List<CSSStyle> styles;

    public SetStyleTextsResponse(java.util.List<CSSStyle> styles) {
        this.styles = styles;
    }

}