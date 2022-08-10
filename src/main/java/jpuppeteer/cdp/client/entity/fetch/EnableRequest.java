package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class EnableRequest {

    /**
    * If specified, only requests matching any of these patterns will produce fetchRequested event and will be paused until clients response. If not set, all requests will be affected.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.fetch.RequestPattern> patterns;

    /**
    * If true, authRequired events will be issued and requests will be paused expecting a call to continueWithAuth.
    */
    private Boolean handleAuthRequests;

    public void setPatterns (java.util.List<jpuppeteer.cdp.client.entity.fetch.RequestPattern> patterns) {
        this.patterns = patterns;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.fetch.RequestPattern> getPatterns() {
        return this.patterns;
    }

    public void setHandleAuthRequests (Boolean handleAuthRequests) {
        this.handleAuthRequests = handleAuthRequests;
    }

    public Boolean getHandleAuthRequests() {
        return this.handleAuthRequests;
    }

    public EnableRequest(java.util.List<jpuppeteer.cdp.client.entity.fetch.RequestPattern> patterns, Boolean handleAuthRequests) {
        this.patterns = patterns;
        this.handleAuthRequests = handleAuthRequests;
    }

    public EnableRequest() {
        this.patterns = null;
        this.handleAuthRequests = null;
    }

}