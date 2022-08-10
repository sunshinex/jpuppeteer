package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetKeyframeKeyResponse {

    /**
    * The resulting key text after modification.
    */
    private jpuppeteer.cdp.client.entity.css.Value keyText;

    public void setKeyText (jpuppeteer.cdp.client.entity.css.Value keyText) {
        this.keyText = keyText;
    }

    public jpuppeteer.cdp.client.entity.css.Value getKeyText() {
        return this.keyText;
    }

    public SetKeyframeKeyResponse(jpuppeteer.cdp.client.entity.css.Value keyText) {
        this.keyText = keyText;
    }

    public SetKeyframeKeyResponse() {
    }

}