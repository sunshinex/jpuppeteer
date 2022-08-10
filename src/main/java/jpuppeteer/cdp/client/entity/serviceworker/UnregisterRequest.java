package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class UnregisterRequest {

    /**
    */
    private String scopeURL;

    public void setScopeURL (String scopeURL) {
        this.scopeURL = scopeURL;
    }

    public String getScopeURL() {
        return this.scopeURL;
    }

    public UnregisterRequest(String scopeURL) {
        this.scopeURL = scopeURL;
    }

    public UnregisterRequest() {
    }

}