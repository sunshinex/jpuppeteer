package jpuppeteer.cdp.client.domain;

/**
*/
public class Log {

    private jpuppeteer.cdp.CDPConnection connection;

    public Log(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Clears the log.
    */
    public jpuppeteer.util.XFuture<?> clear() {
        return connection.send("Log.clear", null);
    }


    /**
    * Disables log domain, prevents further log entries from being reported to the client.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("Log.disable", null);
    }


    /**
    * Enables log domain, sends the entries collected so far to the client by means of the `entryAdded` notification.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("Log.enable", null);
    }


    /**
    * start violation reporting.
    */
    public jpuppeteer.util.XFuture<?> startViolationsReport(jpuppeteer.cdp.client.entity.log.StartViolationsReportRequest request) {
        return connection.send("Log.startViolationsReport", request);
    }


    /**
    * Stop violation reporting.
    */
    public jpuppeteer.util.XFuture<?> stopViolationsReport() {
        return connection.send("Log.stopViolationsReport", null);
    }

}