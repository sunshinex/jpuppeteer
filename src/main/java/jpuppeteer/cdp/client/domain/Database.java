package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Database {

    private jpuppeteer.cdp.CDPSession session;

    public Database(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Disables database tracking, prevents database events from being sent to the client.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Database.disable", null);
    }


    /**
    * Enables database tracking, database events will now be delivered to the client.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Database.enable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.database.ExecuteSQLResponse> executeSQL(jpuppeteer.cdp.client.entity.database.ExecuteSQLRequest request) {
        return session.send("Database.executeSQL", request, jpuppeteer.cdp.client.entity.database.ExecuteSQLResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.database.GetDatabaseTableNamesResponse> getDatabaseTableNames(jpuppeteer.cdp.client.entity.database.GetDatabaseTableNamesRequest request) {
        return session.send("Database.getDatabaseTableNames", request, jpuppeteer.cdp.client.entity.database.GetDatabaseTableNamesResponse.class);
    }

}