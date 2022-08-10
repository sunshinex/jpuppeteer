package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class DeleteDatabaseRequest {

    /**
    * Security origin.
    */
    private String securityOrigin;

    /**
    * Database name.
    */
    private String databaseName;

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

    public DeleteDatabaseRequest(String securityOrigin, String databaseName) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
    }

    public DeleteDatabaseRequest() {
    }

}