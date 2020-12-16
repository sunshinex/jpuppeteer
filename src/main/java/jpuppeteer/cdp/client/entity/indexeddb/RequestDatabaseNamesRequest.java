package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDatabaseNamesRequest {

    /**
    * Security origin.
    */
    public final String securityOrigin;

    public RequestDatabaseNamesRequest(String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

}