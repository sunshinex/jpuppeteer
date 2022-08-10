package jpuppeteer.cdp.client.domain;

/**
*/
@java.lang.Deprecated
public class Console {

    private jpuppeteer.cdp.CDPConnection connection;

    public Console(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Does nothing.
    */
    public jpuppeteer.util.XFuture<?> clearMessages() {
        return connection.send("Console.clearMessages", null);
    }


    /**
    * Disables console domain, prevents further console messages from being reported to the client.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("Console.disable", null);
    }


    /**
    * Enables console domain, sends the messages collected so far to the client by means of the `messageAdded` notification.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("Console.enable", null);
    }

}