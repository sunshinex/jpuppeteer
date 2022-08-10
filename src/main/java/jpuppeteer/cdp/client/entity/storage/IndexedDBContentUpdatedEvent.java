package jpuppeteer.cdp.client.entity.storage;

/**
* The origin's IndexedDB object store has been modified.
* experimental
*/
public class IndexedDBContentUpdatedEvent {

    /**
    * Origin to update.
    */
    private String origin;

    /**
    * Database to update.
    */
    private String databaseName;

    /**
    * ObjectStore to update.
    */
    private String objectStoreName;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setDatabaseName (String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setObjectStoreName (String objectStoreName) {
        this.objectStoreName = objectStoreName;
    }

    public String getObjectStoreName() {
        return this.objectStoreName;
    }

    public IndexedDBContentUpdatedEvent(String origin, String databaseName, String objectStoreName) {
        this.origin = origin;
        this.databaseName = databaseName;
        this.objectStoreName = objectStoreName;
    }

    public IndexedDBContentUpdatedEvent() {
    }

}