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
    public final jpuppeteer.cdp.client.entity.indexeddb.KeyRange keyRange;

    public DeleteObjectStoreEntriesRequest(String securityOrigin, String databaseName, String objectStoreName, jpuppeteer.cdp.client.entity.indexeddb.KeyRange keyRange) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
        this.objectStoreName = objectStoreName;
        this.keyRange = keyRange;
    }

}