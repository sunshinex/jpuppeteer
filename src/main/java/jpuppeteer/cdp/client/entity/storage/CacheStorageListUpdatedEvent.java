package jpuppeteer.cdp.client.entity.storage;

/**
* A cache has been added/deleted.
* experimental
*/
public class CacheStorageListUpdatedEvent {

    /**
    * Origin to update.
    */
    public final String origin;

    public CacheStorageListUpdatedEvent(String origin) {
        this.origin = origin;
    }

}