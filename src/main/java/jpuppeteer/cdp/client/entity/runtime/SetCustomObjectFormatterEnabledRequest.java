package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class SetCustomObjectFormatterEnabledRequest {

    /**
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetCustomObjectFormatterEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetCustomObjectFormatterEnabledRequest() {
    }

}