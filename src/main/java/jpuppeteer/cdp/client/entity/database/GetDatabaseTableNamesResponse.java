package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class GetDatabaseTableNamesResponse {

    /**
    */
    private java.util.List<String> tableNames;

    public void setTableNames (java.util.List<String> tableNames) {
        this.tableNames = tableNames;
    }

    public java.util.List<String> getTableNames() {
        return this.tableNames;
    }

    public GetDatabaseTableNamesResponse(java.util.List<String> tableNames) {
        this.tableNames = tableNames;
    }

    public GetDatabaseTableNamesResponse() {
    }

}