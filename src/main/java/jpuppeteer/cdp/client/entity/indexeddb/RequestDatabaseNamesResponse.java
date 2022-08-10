package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDatabaseNamesResponse {

    /**
    * Database names for origin.
    */
    private java.util.List<String> databaseNames;

    public void setDatabaseNames (java.util.List<String> databaseNames) {
        this.databaseNames = databaseNames;
    }

    public java.util.List<String> getDatabaseNames() {
        return this.databaseNames;
    }

    public RequestDatabaseNamesResponse(java.util.List<String> databaseNames) {
        this.databaseNames = databaseNames;
    }

    public RequestDatabaseNamesResponse() {
    }

}