package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetNodeStackTracesEnabledRequest {

    /**
    * Enable or disable.
    */
    public final Boolean enable;

    public SetNodeStackTracesEnabledRequest(Boolean enable) {
        this.enable = enable;
    }

}