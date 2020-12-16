package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetKeyframeKeyResponse {

    /**
    * The resulting key text after modification.
    */
    public final Value keyText;

    public SetKeyframeKeyResponse(Value keyText) {
        this.keyText = keyText;
    }

}