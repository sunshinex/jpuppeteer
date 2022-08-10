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
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("Inspector.disable", null);
    }


    /**
    * Enables inspector domain notifications.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("Inspector.enable", null);
    }

}