package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowHingeRequest {

    /**
    * hinge data, null means hideHinge
    */
    public final jpuppeteer.cdp.client.entity.overlay.HingeConfig hingeConfig;

    public SetShowHingeRequest(jpuppeteer.cdp.client.entity.overlay.HingeConfig hingeConfig) {
        this.hingeConfig = hingeConfig;
    }

    public SetShowHingeRequest() {
        this.hingeConfig = null;
    }

}