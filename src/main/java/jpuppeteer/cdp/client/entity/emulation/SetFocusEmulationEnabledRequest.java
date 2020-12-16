package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetFocusEmulationEnabledRequest {

    /**
    * Whether to enable to disable focus emulation.
    */
    public final Boolean enabled;

    public SetFocusEmulationEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
    }

}