package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetTouchEmulationEnabledRequest {

    /**
    * Whether the touch event emulation should be enabled.
    */
    private Boolean enabled;

    /**
    * Maximum touch points supported. Defaults to one.
    */
    private Integer maxTouchPoints;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setMaxTouchPoints (Integer maxTouchPoints) {
        this.maxTouchPoints = maxTouchPoints;
    }

    public Integer getMaxTouchPoints() {
        return this.maxTouchPoints;
    }

    public SetTouchEmulationEnabledRequest(Boolean enabled, Integer maxTouchPoints) {
        this.enabled = enabled;
        this.maxTouchPoints = maxTouchPoints;
    }

    public SetTouchEmulationEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
        this.maxTouchPoints = null;
    }

    public SetTouchEmulationEnabledRequest() {
    }

}