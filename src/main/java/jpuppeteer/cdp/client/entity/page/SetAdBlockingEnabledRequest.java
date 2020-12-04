package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetAdBlockingEnabledRequest {

    /**
    * Whether to block ads.
    */
    public final Boolean enabled;

    public SetAdBlockingEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
    }

}