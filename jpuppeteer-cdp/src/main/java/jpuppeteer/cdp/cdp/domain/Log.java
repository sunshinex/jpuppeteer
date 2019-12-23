package jpuppeteer.cdp.cdp.domain;

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
    public void clear(int timeout) throws Exception {
        session.send("Log.clear", null, timeout);
    }


    /**
    * Disables log domain, prevents further log entries from being reported to the client.
    */
    public void disable(int timeout) throws Exception {
        session.send("Log.disable", null, timeout);
    }


    /**
    * Enables log domain, sends the entries collected so far to the client by means of the `entryAdded` notification.
    */
    public void enable(int timeout) throws Exception {
        session.send("Log.enable", null, timeout);
    }


    /**
    * start violation reporting.
    */
    public void startViolationsReport(jpuppeteer.cdp.cdp.entity.log.StartViolationsReportRequest request, int timeout) throws Exception {
        session.send("Log.startViolationsReport", request, timeout);
    }


    /**
    * Stop violation reporting.
    */
    public void stopViolationsReport(int timeout) throws Exception {
        session.send("Log.stopViolationsReport", null, timeout);
    }

}