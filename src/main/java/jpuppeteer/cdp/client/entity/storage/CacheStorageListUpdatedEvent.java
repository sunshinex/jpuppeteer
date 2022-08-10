package jpuppeteer.cdp.client.entity.storage;

/**
* A cache has been added/deleted.
* experimental
*/
public class CacheStorageListUpdatedEvent {

    /**
    * Origin to update.
    */
    private String origin;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public CacheStorageListUpdatedEvent(String origin) {
        this.origin = origin;
    }

    public CacheStorageListUpdatedEvent() {
    }

}