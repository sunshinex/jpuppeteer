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
    public io.netty.util.concurrent.Future clearMessages() {
        return connection.send("Console.clearMessages", null);
    }


    /**
    * Disables console domain, prevents further console messages from being reported to the client.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Console.disable", null);
    }


    /**
    * Enables console domain, sends the messages collected so far to the client by means of the `messageAdded` notification.
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("Console.enable", null);
    }

}