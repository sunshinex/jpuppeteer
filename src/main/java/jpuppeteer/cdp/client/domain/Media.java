package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Media {

    private jpuppeteer.cdp.CDPConnection connection;

    public Media(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Enables the Media domain
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("Media.enable", null);
    }


    /**
    * Disables the Media domain.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Media.disable", null);
    }

}