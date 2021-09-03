package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetRequestInterceptionRequest {

    /**
    * Requests matching any of these patterns will be forwarded and wait for the corresponding continueInterceptedRequest call.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.network.RequestPattern> patterns;

    public SetRequestInterceptionRequest(java.util.List<jpuppeteer.cdp.client.entity.network.RequestPattern> patterns) {
        this.patterns = patterns;
    }

}