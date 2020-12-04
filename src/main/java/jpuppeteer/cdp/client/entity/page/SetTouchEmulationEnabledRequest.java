package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetTouchEmulationEnabledRequest {

    /**
    * Whether the touch event emulation should be enabled.
    */
    public final Boolean enabled;

    /**
    * Touch/gesture events configuration. Default: current platform.
    */
    public final String configuration;

    public SetTouchEmulationEnabledRequest(Boolean enabled, String configuration) {
        this.enabled = enabled;
        this.configuration = configuration;
    }

    public SetTouchEmulationEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
        this.configuration = null;
    }

}