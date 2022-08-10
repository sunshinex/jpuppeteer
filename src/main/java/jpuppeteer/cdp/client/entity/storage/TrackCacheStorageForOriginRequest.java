package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class TrackCacheStorageForOriginRequest {

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

    public TrackCacheStorageForOriginRequest(String origin) {
        this.origin = origin;
    }

    public TrackCacheStorageForOriginRequest() {
    }

}