package jpuppeteer.cdp.client.entity.storage;

/**
* A cache's contents have been modified.
* experimental
*/
public class CacheStorageContentUpdatedEvent {

    /**
    * Origin to update.
    */
    private String origin;

    /**
    * Name of cache in origin.
    */
    private String cacheName;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setCacheName (String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheName() {
        return this.cacheName;
    }

    public CacheStorageContentUpdatedEvent(String origin, String cacheName) {
        this.origin = origin;
        this.cacheName = cacheName;
    }

    public CacheStorageContentUpdatedEvent() {
    }

}