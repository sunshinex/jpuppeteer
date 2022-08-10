package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetBypassServiceWorkerRequest {

    /**
    * Bypass service worker and load from network.
    */
    private Boolean bypass;

    public void setBypass (Boolean bypass) {
        this.bypass = bypass;
    }

    public Boolean getBypass() {
        return this.bypass;
    }

    public SetBypassServiceWorkerRequest(Boolean bypass) {
        this.bypass = bypass;
    }

    public SetBypassServiceWorkerRequest() {
    }

}