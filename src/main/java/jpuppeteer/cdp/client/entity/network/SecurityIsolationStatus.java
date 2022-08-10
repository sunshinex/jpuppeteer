package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SecurityIsolationStatus {

    /**
    */
    private jpuppeteer.cdp.client.entity.network.CrossOriginOpenerPolicyStatus coop;

    /**
    */
    private jpuppeteer.cdp.client.entity.network.CrossOriginEmbedderPolicyStatus coep;

    public void setCoop (jpuppeteer.cdp.client.entity.network.CrossOriginOpenerPolicyStatus coop) {
        this.coop = coop;
    }

    public jpuppeteer.cdp.client.entity.network.CrossOriginOpenerPolicyStatus getCoop() {
        return this.coop;
    }

    public void setCoep (jpuppeteer.cdp.client.entity.network.CrossOriginEmbedderPolicyStatus coep) {
        this.coep = coep;
    }

    public jpuppeteer.cdp.client.entity.network.CrossOriginEmbedderPolicyStatus getCoep() {
        return this.coep;
    }

    public SecurityIsolationStatus(jpuppeteer.cdp.client.entity.network.CrossOriginOpenerPolicyStatus coop, jpuppeteer.cdp.client.entity.network.CrossOriginEmbedderPolicyStatus coep) {
        this.coop = coop;
        this.coep = coep;
    }

    public SecurityIsolationStatus() {
        this.coop = null;
        this.coep = null;
    }

}