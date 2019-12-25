package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("Database.disable", null, timeout);
    }


    /**
    * Enables database tracking, database events will now be delivered to the client.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("Database.enable", null, timeout);
    }


    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.database.ExecuteSQLResponse executeSQL(jpuppeteer.cdp.cdp.entity.database.ExecuteSQLRequest request, int timeout) throws Exception {
        return session.send("Database.executeSQL", request, jpuppeteer.cdp.cdp.entity.database.ExecuteSQLResponse.class, timeout);
    }


    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.database.GetDatabaseTableNamesResponse getDatabaseTableNames(jpuppeteer.cdp.cdp.entity.database.GetDatabaseTableNamesRequest request, int timeout) throws Exception {
        return session.send("Database.getDatabaseTableNames", request, jpuppeteer.cdp.cdp.entity.database.GetDatabaseTableNamesResponse.class, timeout);
    }

}