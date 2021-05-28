package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetBypassServiceWorkerRequest {

    /**
    * Bypass service worker and load from network.
    */
    public final Boolean bypass;

    public SetBypassServiceWorkerRequest(Boolean bypass) {
        this.bypass = bypass;
    }

}