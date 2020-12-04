package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class TrackCacheStorageForOriginRequest {

    /**
    * Security origin.
    */
    public final String origin;

    public TrackCacheStorageForOriginRequest(String origin) {
        this.origin = origin;
    }

}