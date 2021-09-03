package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SecurityIsolationStatus {

    /**
    */
    public final jpuppeteer.cdp.client.entity.network.CrossOriginOpenerPolicyStatus coop;

    /**
    */
    public final jpuppeteer.cdp.client.entity.network.CrossOriginEmbedderPolicyStatus coep;

    public SecurityIsolationStatus(jpuppeteer.cdp.client.entity.network.CrossOriginOpenerPolicyStatus coop, jpuppeteer.cdp.client.entity.network.CrossOriginEmbedderPolicyStatus coep) {
        this.coop = coop;
        this.coep = coep;
    }

    public SecurityIsolationStatus() {
        this.coop = null;
        this.coep = null;
    }

}