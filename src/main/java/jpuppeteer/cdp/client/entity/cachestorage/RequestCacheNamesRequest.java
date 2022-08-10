package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestCacheNamesRequest {

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

    public RequestCacheNamesRequest(String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

    public RequestCacheNamesRequest() {
    }

}