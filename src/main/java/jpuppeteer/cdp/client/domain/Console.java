package jpuppeteer.cdp.client.domain;

/**
*/
@Deprecated
public class Console {

    private jpuppeteer.cdp.CDPSession session;

    public Console(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Does nothing.
    */
    public io.netty.util.concurrent.Future clearMessages() {
        return session.send("Console.clearMessages", null);
    }


    /**
    * Disables console domain, prevents further console messages from being reported to the client.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Console.disable", null);
    }


    /**
    * Enables console domain, sends the messages collected so far to the client by means of the `messageAdded` notification.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Console.enable", null);
    }

}