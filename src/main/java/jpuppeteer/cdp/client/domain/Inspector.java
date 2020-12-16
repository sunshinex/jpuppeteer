package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Inspector {

    private jpuppeteer.cdp.CDPSession session;

    public Inspector(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Disables inspector domain notifications.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Inspector.disable", null);
    }


    /**
    * Enables inspector domain notifications.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Inspector.enable", null);
    }

}