package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDatabaseRequest {

    /**
    * Security origin.
    */
    public final String securityOrigin;

    /**
    * Database name.
    */
    public final String databaseName;

    public RequestDatabaseRequest(String securityOrigin, String databaseName) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
    }

}