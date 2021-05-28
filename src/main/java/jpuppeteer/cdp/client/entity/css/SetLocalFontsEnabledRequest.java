package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetLocalFontsEnabledRequest {

    /**
    * Whether rendering of local fonts is enabled.
    */
    public final Boolean enabled;

    public SetLocalFontsEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
    }

}