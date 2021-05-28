package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDatabaseNamesResponse {

    /**
    * Database names for origin.
    */
    public final java.util.List<String> databaseNames;

    public RequestDatabaseNamesResponse(java.util.List<String> databaseNames) {
        this.databaseNames = databaseNames;
    }

}