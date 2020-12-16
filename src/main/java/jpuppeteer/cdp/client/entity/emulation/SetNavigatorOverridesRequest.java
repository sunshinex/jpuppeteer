package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetNavigatorOverridesRequest {

    /**
    * The platform navigator.platform should return.
    */
    public final String platform;

    public SetNavigatorOverridesRequest(String platform) {
        this.platform = platform;
    }

}