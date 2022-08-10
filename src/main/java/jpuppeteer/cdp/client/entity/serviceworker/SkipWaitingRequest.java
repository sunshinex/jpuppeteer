package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class SkipWaitingRequest {

    /**
    */
    private String scopeURL;

    public void setScopeURL (String scopeURL) {
        this.scopeURL = scopeURL;
    }

    public String getScopeURL() {
        return this.scopeURL;
    }

    public SkipWaitingRequest(String scopeURL) {
        this.scopeURL = scopeURL;
    }

    public SkipWaitingRequest() {
    }

}