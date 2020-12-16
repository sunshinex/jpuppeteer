package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetBypassCSPRequest {

    /**
    * Whether to bypass page CSP.
    */
    public final Boolean enabled;

    public SetBypassCSPRequest(Boolean enabled) {
        this.enabled = enabled;
    }

}