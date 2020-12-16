package jpuppeteer.cdp.client.entity.storage;

/**
* A cache's contents have been modified.
* experimental
*/
public class CacheStorageContentUpdatedEvent {

    /**
    * Origin to update.
    */
    public final String origin;

    /**
    * Name of cache in origin.
    */
    public final String cacheName;

    public CacheStorageContentUpdatedEvent(String origin, String cacheName) {
        this.origin = origin;
        this.cacheName = cacheName;
    }

}