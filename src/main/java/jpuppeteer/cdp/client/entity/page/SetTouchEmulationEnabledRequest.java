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
    public final jpuppeteer.cdp.client.constant.page.SetTouchEmulationEnabledRequestConfiguration configuration;

    public SetTouchEmulationEnabledRequest(Boolean enabled, jpuppeteer.cdp.client.constant.page.SetTouchEmulationEnabledRequestConfiguration configuration) {
        this.enabled = enabled;
        this.configuration = configuration;
    }

    public SetTouchEmulationEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
        this.configuration = null;
    }

}