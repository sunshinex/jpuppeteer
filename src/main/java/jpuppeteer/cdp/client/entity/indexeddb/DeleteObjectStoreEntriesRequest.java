package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class DeleteObjectStoreEntriesRequest {

    /**
    */
    public final String securityOrigin;

    /**
    */
    public final String databaseName;

    /**
    */
    public final String objectStoreName;

    /**
    * Range of entry keys to delete
    */
    public final KeyRange keyRange;

    public DeleteObjectStoreEntriesRequest(String securityOrigin, String databaseName, String objectStoreName, KeyRange keyRange) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
        this.objectStoreName = objectStoreName;
        this.keyRange = keyRange;
    }

}