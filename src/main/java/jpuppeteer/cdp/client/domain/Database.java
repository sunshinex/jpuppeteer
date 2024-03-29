package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Database {

    private jpuppeteer.cdp.CDPConnection connection;

    public Database(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Disables database tracking, prevents database events from being sent to the client.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("Database.disable", null);
    }


    /**
    * Enables database tracking, database events will now be delivered to the client.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("Database.enable", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.database.ExecuteSQLResponse> executeSQL(jpuppeteer.cdp.client.entity.database.ExecuteSQLRequest request) {
        return connection.send("Database.executeSQL", request, jpuppeteer.cdp.client.entity.database.ExecuteSQLResponse.class);
    }


    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.database.GetDatabaseTableNamesResponse> getDatabaseTableNames(jpuppeteer.cdp.client.entity.database.GetDatabaseTableNamesRequest request) {
        return connection.send("Database.getDatabaseTableNames", request, jpuppeteer.cdp.client.entity.database.GetDatabaseTableNamesResponse.class);
    }

}