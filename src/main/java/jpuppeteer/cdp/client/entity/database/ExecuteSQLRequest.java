package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class ExecuteSQLRequest {

    /**
    */
    private String databaseId;

    /**
    */
    private String query;

    public void setDatabaseId (String databaseId) {
        this.databaseId = databaseId;
    }

    public String getDatabaseId() {
        return this.databaseId;
    }

    public void setQuery (String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public ExecuteSQLRequest(String databaseId, String query) {
        this.databaseId = databaseId;
        this.query = query;
    }

    public ExecuteSQLRequest() {
    }

}