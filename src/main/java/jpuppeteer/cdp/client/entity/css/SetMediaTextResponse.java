package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetMediaTextResponse {

    /**
    * The resulting CSS media rule after modification.
    */
    public final CSSMedia media;

    public SetMediaTextResponse(CSSMedia media) {
        this.media = media;
    }

}