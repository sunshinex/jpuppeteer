package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class GetDatabaseTableNamesRequest {

    /**
    */
    private String databaseId;

    public void setDatabaseId (String databaseId) {
        this.databaseId = databaseId;
    }

    public String getDatabaseId() {
        return this.databaseId;
    }

    public GetDatabaseTableNamesRequest(String databaseId) {
        this.databaseId = databaseId;
    }

    public GetDatabaseTableNamesRequest() {
    }

}