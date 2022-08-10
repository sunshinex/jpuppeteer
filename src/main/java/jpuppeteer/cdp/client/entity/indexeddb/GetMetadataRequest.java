package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class GetMetadataRequest {

    /**
    * Security origin.
    */
    private String securityOrigin;

    /**
    * Database name.
    */
    private String databaseName;

    /**
    * Object store name.
    */
    private String objectStoreName;

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

    public GetMetadataRequest(String securityOrigin, String databaseName, String objectStoreName) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
        this.objectStoreName = objectStoreName;
    }

    public GetMetadataRequest() {
    }

}