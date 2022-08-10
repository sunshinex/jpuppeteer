package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetNavigatorOverridesRequest {

    /**
    * The platform navigator.platform should return.
    */
    private String platform;

    public void setPlatform (String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return this.platform;
    }

    public SetNavigatorOverridesRequest(String platform) {
        this.platform = platform;
    }

    public SetNavigatorOverridesRequest() {
    }

}