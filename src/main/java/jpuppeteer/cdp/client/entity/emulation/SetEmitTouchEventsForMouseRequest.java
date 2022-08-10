package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetEmitTouchEventsForMouseRequest {

    /**
    * Whether touch emulation based on mouse input should be enabled.
    */
    private Boolean enabled;

    /**
    * Touch/gesture events configuration. Default: current platform.
    */
    private jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration configuration;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setConfiguration (jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration configuration) {
        this.configuration = configuration;
    }

    public jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration getConfiguration() {
        return this.configuration;
    }

    public SetEmitTouchEventsForMouseRequest(Boolean enabled, jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration configuration) {
        this.enabled = enabled;
        this.configuration = configuration;
    }

    public SetEmitTouchEventsForMouseRequest(Boolean enabled) {
        this.enabled = enabled;
        this.configuration = null;
    }

    public SetEmitTouchEventsForMouseRequest() {
    }

}