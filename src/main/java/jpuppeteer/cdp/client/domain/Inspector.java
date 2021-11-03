package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Inspector {

    private jpuppeteer.cdp.CDPConnection connection;

    public Inspector(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Disables inspector domain notifications.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Inspector.disable", null);
    }


    /**
    * Enables inspector domain notifications.
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("Inspector.enable", null);
    }

}