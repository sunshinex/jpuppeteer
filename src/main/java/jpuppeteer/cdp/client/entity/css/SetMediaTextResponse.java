package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetMediaTextResponse {

    /**
    * The resulting CSS media rule after modification.
    */
    public final jpuppeteer.cdp.client.entity.css.CSSMedia media;

    public SetMediaTextResponse(jpuppeteer.cdp.client.entity.css.CSSMedia media) {
        this.media = media;
    }

}