package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class ExecuteSQLRequest {

    /**
    */
    public final String databaseId;

    /**
    */
    public final String query;

    public ExecuteSQLRequest(String databaseId, String query) {
        this.databaseId = databaseId;
        this.query = query;
    }

}