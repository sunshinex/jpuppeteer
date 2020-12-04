package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetTouchEmulationEnabledRequest {

    /**
    * Whether the touch event emulation should be enabled.
    */
    public final Boolean enabled;

    /**
    * Maximum touch points supported. Defaults to one.
    */
    public final Integer maxTouchPoints;

    public SetTouchEmulationEnabledRequest(Boolean enabled, Integer maxTouchPoints) {
        this.enabled = enabled;
        this.maxTouchPoints = maxTouchPoints;
    }

    public SetTouchEmulationEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
        this.maxTouchPoints = null;
    }

}