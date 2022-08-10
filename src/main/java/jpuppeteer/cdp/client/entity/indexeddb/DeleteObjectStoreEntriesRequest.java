package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class DeleteObjectStoreEntriesRequest {

    /**
    */
    private String securityOrigin;

    /**
    */
    private String databaseName;

    /**
    */
    private String objectStoreName;

    /**
    * Range of entry keys to delete
    */
    private jpuppeteer.cdp.client.entity.indexeddb.KeyRange keyRange;

    public void setSecurityOrigin (String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

    public String getSecurityOrigin() {
        return this.securityOrigin;
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

    public void setKeyRange (jpuppeteer.cdp.client.entity.indexeddb.KeyRange keyRange) {
        this.keyRange = keyRange;
    }

    public jpuppeteer.cdp.client.entity.indexeddb.KeyRange getKeyRange() {
        return this.keyRange;
    }

    public DeleteObjectStoreEntriesRequest(String securityOrigin, String databaseName, String objectStoreName, jpuppeteer.cdp.client.entity.indexeddb.KeyRange keyRange) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
        this.objectStoreName = objectStoreName;
        this.keyRange = keyRange;
    }

    public DeleteObjectStoreEntriesRequest() {
    }

}