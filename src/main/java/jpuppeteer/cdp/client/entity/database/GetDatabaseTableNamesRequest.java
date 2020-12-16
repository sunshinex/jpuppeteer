package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class GetDatabaseTableNamesRequest {

    /**
    */
    public final String databaseId;

    public GetDatabaseTableNamesRequest(String databaseId) {
        this.databaseId = databaseId;
    }

}