package jpuppeteer.cdp.client.entity.storage;

/**
* The origin's IndexedDB database list has been modified.
* experimental
*/
public class IndexedDBListUpdatedEvent {

    /**
    * Origin to update.
    */
    public final String origin;

    public IndexedDBListUpdatedEvent(String origin) {
        this.origin = origin;
    }

}