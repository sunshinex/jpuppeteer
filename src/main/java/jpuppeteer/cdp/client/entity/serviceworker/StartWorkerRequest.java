package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class StartWorkerRequest {

    /**
    */
    private String scopeURL;

    public void setScopeURL (String scopeURL) {
        this.scopeURL = scopeURL;
    }

    public String getScopeURL() {
        return this.scopeURL;
    }

    public StartWorkerRequest(String scopeURL) {
        this.scopeURL = scopeURL;
    }

    public StartWorkerRequest() {
    }

}