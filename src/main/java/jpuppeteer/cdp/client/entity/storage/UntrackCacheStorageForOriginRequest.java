package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class UntrackCacheStorageForOriginRequest {

    /**
    * Security origin.
    */
    public final String origin;

    public UntrackCacheStorageForOriginRequest(String origin) {
        this.origin = origin;
    }

}