package jpuppeteer.cdp.client.domain;

/**
*/
public class Log {

    private jpuppeteer.cdp.CDPSession session;

    public Log(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Clears the log.
    */
    public io.netty.util.concurrent.Future clear() {
        return session.send("Log.clear", null);
    }


    /**
    * Disables log domain, prevents further log entries from being reported to the client.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Log.disable", null);
    }


    /**
    * Enables log domain, sends the entries collected so far to the client by means of the `entryAdded` notification.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Log.enable", null);
    }


    /**
    * start violation reporting.
    */
    public io.netty.util.concurrent.Future startViolationsReport(jpuppeteer.cdp.client.entity.log.StartViolationsReportRequest request) {
        return session.send("Log.startViolationsReport", request);
    }


    /**
    * Stop violation reporting.
    */
    public io.netty.util.concurrent.Future stopViolationsReport() {
        return session.send("Log.stopViolationsReport", null);
    }

}