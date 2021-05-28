package jpuppeteer.cdp.client.entity.storage;

/**
* The origin's IndexedDB object store has been modified.
* experimental
*/
public class IndexedDBContentUpdatedEvent {

    /**
    * Origin to update.
    */
    public final String origin;

    /**
    * Database to update.
    */
    public final String databaseName;

    /**
    * ObjectStore to update.
    */
    public final String objectStoreName;

    public IndexedDBContentUpdatedEvent(String origin, String databaseName, String objectStoreName) {
        this.origin = origin;
        this.databaseName = databaseName;
        this.objectStoreName = objectStoreName;
    }

}