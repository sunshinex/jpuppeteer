package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDatabaseNamesRequest {

    /**
    * Security origin.
    */
    private String securityOrigin;

    public void setSecurityOrigin (String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

    public String getSecurityOrigin() {
        return this.securityOrigin;
    }

    public RequestDatabaseNamesRequest(String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

    public RequestDatabaseNamesRequest() {
    }

}