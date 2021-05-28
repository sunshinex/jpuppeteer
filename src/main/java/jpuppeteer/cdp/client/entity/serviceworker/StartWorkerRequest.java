package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class StartWorkerRequest {

    /**
    */
    public final String scopeURL;

    public StartWorkerRequest(String scopeURL) {
        this.scopeURL = scopeURL;
    }

}