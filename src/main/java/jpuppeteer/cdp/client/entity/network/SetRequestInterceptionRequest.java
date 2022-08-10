package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetRequestInterceptionRequest {

    /**
    * Requests matching any of these patterns will be forwarded and wait for the corresponding continueInterceptedRequest call.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.RequestPattern> patterns;

    public void setPatterns (java.util.List<jpuppeteer.cdp.client.entity.network.RequestPattern> patterns) {
        this.patterns = patterns;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.RequestPattern> getPatterns() {
        return this.patterns;
    }

    public SetRequestInterceptionRequest(java.util.List<jpuppeteer.cdp.client.entity.network.RequestPattern> patterns) {
        this.patterns = patterns;
    }

    public SetRequestInterceptionRequest() {
    }

}