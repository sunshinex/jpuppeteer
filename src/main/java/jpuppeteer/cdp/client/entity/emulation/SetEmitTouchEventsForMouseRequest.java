package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetEmitTouchEventsForMouseRequest {

    /**
    * Whether touch emulation based on mouse input should be enabled.
    */
    public final Boolean enabled;

    /**
    * Touch/gesture events configuration. Default: current platform.
    */
    public final jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration configuration;

    public SetEmitTouchEventsForMouseRequest(Boolean enabled, jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration configuration) {
        this.enabled = enabled;
        this.configuration = configuration;
    }

    public SetEmitTouchEventsForMouseRequest(Boolean enabled) {
        this.enabled = enabled;
        this.configuration = null;
    }

}