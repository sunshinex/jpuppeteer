package jpuppeteer.cdp.client.entity.storage;

/**
* The origin's IndexedDB database list has been modified.
* experimental
*/
public class IndexedDBListUpdatedEvent {

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

    public IndexedDBListUpdatedEvent(String origin) {
        this.origin = origin;
    }

    public IndexedDBListUpdatedEvent() {
    }

}