package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class DeleteDatabaseRequest {

    /**
    * Security origin.
    */
    public final String securityOrigin;

    /**
    * Database name.
    */
    public final String databaseName;

    public DeleteDatabaseRequest(String securityOrigin, String databaseName) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
    }

}