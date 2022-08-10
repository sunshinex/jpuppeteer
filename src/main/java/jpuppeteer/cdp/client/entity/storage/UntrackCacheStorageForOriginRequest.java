package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class UntrackCacheStorageForOriginRequest {

    /**
    * Security origin.
    */
    private String origin;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public UntrackCacheStorageForOriginRequest(String origin) {
        this.origin = origin;
    }

    public UntrackCacheStorageForOriginRequest() {
    }

}