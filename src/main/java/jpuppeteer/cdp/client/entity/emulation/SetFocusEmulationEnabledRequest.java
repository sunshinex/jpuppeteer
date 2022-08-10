package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetFocusEmulationEnabledRequest {

    /**
    * Whether to enable to disable focus emulation.
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetFocusEmulationEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetFocusEmulationEnabledRequest() {
    }

}