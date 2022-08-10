package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowHingeRequest {

    /**
    * hinge data, null means hideHinge
    */
    private jpuppeteer.cdp.client.entity.overlay.HingeConfig hingeConfig;

    public void setHingeConfig (jpuppeteer.cdp.client.entity.overlay.HingeConfig hingeConfig) {
        this.hingeConfig = hingeConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.HingeConfig getHingeConfig() {
        return this.hingeConfig;
    }

    public SetShowHingeRequest(jpuppeteer.cdp.client.entity.overlay.HingeConfig hingeConfig) {
        this.hingeConfig = hingeConfig;
    }

    public SetShowHingeRequest() {
        this.hingeConfig = null;
    }

}