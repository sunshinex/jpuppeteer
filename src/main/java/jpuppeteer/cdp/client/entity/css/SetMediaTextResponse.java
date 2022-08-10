package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetMediaTextResponse {

    /**
    * The resulting CSS media rule after modification.
    */
    private jpuppeteer.cdp.client.entity.css.CSSMedia media;

    public void setMedia (jpuppeteer.cdp.client.entity.css.CSSMedia media) {
        this.media = media;
    }

    public jpuppeteer.cdp.client.entity.css.CSSMedia getMedia() {
        return this.media;
    }

    public SetMediaTextResponse(jpuppeteer.cdp.client.entity.css.CSSMedia media) {
        this.media = media;
    }

    public SetMediaTextResponse() {
    }

}