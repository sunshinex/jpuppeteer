package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetRequestInterceptionRequest {

    /**
    * Requests matching any of these patterns will be forwarded and wait for the corresponding continueInterceptedRequest call.
    */
    public final java.util.List<RequestPattern> patterns;

    public SetRequestInterceptionRequest(java.util.List<RequestPattern> patterns) {
        this.patterns = patterns;
    }

}