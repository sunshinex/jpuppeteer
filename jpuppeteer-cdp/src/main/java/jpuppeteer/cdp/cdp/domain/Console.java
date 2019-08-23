package jpuppeteer.cdp.cdp.domain;

/**
*/
public class Console {

    private jpuppeteer.cdp.CDPSession session;

    public Console(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Does nothing.
    */
    public void clearMessages(int timeout) throws Exception {
        session.send("Console.clearMessages", null, timeout);
    }


    /**
    * Disables console domain, prevents further console messages from being reported to the client.
    */
    public void disable(int timeout) throws Exception {
        session.send("Console.disable", null, timeout);
    }


    /**
    * Enables console domain, sends the messages collected so far to the client by means of the `messageAdded` notification.
    */
    public void enable(int timeout) throws Exception {
        session.send("Console.enable", null, timeout);
    }

}