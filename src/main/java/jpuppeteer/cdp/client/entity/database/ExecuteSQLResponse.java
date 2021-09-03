package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class ExecuteSQLResponse {

    /**
    */
    public final java.util.List<String> columnNames;

    /**
    */
    public final java.util.List<Object> values;

    /**
    */
    public final jpuppeteer.cdp.client.entity.database.Error sqlError;

    public ExecuteSQLResponse(java.util.List<String> columnNames, java.util.List<Object> values, jpuppeteer.cdp.client.entity.database.Error sqlError) {
        this.columnNames = columnNames;
        this.values = values;
        this.sqlError = sqlError;
    }

    public ExecuteSQLResponse() {
        this.columnNames = null;
        this.values = null;
        this.sqlError = null;
    }

}