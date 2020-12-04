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
    public final String configuration;

    public SetEmitTouchEventsForMouseRequest(Boolean enabled, String configuration) {
        this.enabled = enabled;
        this.configuration = configuration;
    }

    public SetEmitTouchEventsForMouseRequest(Boolean enabled) {
        this.enabled = enabled;
        this.configuration = null;
    }

}