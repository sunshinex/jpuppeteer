package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class ExecuteSQLResponse {

    /**
    */
    private java.util.List<String> columnNames;

    /**
    */
    private java.util.List<Object> values;

    /**
    */
    private jpuppeteer.cdp.client.entity.database.Error sqlError;

    public void setColumnNames (java.util.List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public java.util.List<String> getColumnNames() {
        return this.columnNames;
    }

    public void setValues (java.util.List<Object> values) {
        this.values = values;
    }

    public java.util.List<Object> getValues() {
        return this.values;
    }

    public void setSqlError (jpuppeteer.cdp.client.entity.database.Error sqlError) {
        this.sqlError = sqlError;
    }

    public jpuppeteer.cdp.client.entity.database.Error getSqlError() {
        return this.sqlError;
    }

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