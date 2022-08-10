package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetBypassCSPRequest {

    /**
    * Whether to bypass page CSP.
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetBypassCSPRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetBypassCSPRequest() {
    }

}