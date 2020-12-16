package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class UnregisterRequest {

    /**
    */
    public final String scopeURL;

    public UnregisterRequest(String scopeURL) {
        this.scopeURL = scopeURL;
    }

}