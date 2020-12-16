package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class ClearObjectStoreRequest {

    /**
    * Security origin.
    */
    public final String securityOrigin;

    /**
    * Database name.
    */
    public final String databaseName;

    /**
    * Object store name.
    */
    public final String objectStoreName;

    public ClearObjectStoreRequest(String securityOrigin, String databaseName, String objectStoreName) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
        this.objectStoreName = objectStoreName;
    }

}