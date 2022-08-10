package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class UpdateRegistrationRequest {

    /**
    */
    private String scopeURL;

    public void setScopeURL (String scopeURL) {
        this.scopeURL = scopeURL;
    }

    public String getScopeURL() {
        return this.scopeURL;
    }

    public UpdateRegistrationRequest(String scopeURL) {
        this.scopeURL = scopeURL;
    }

    public UpdateRegistrationRequest() {
    }

}