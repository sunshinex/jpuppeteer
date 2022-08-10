package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetAdBlockingEnabledRequest {

    /**
    * Whether to block ads.
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetAdBlockingEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetAdBlockingEnabledRequest() {
    }

}