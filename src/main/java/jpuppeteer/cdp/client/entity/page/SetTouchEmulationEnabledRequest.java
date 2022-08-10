package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetTouchEmulationEnabledRequest {

    /**
    * Whether the touch event emulation should be enabled.
    */
    private Boolean enabled;

    /**
    * Touch/gesture events configuration. Default: current platform.
    */
    private jpuppeteer.cdp.client.constant.page.SetTouchEmulationEnabledRequestConfiguration configuration;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setConfiguration (jpuppeteer.cdp.client.constant.page.SetTouchEmulationEnabledRequestConfiguration configuration) {
        this.configuration = configuration;
    }

    public jpuppeteer.cdp.client.constant.page.SetTouchEmulationEnabledRequestConfiguration getConfiguration() {
        return this.configuration;
    }

    public SetTouchEmulationEnabledRequest(Boolean enabled, jpuppeteer.cdp.client.constant.page.SetTouchEmulationEnabledRequestConfiguration configuration) {
        this.enabled = enabled;
        this.configuration = configuration;
    }

    public SetTouchEmulationEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
        this.configuration = null;
    }

    public SetTouchEmulationEnabledRequest() {
    }

}