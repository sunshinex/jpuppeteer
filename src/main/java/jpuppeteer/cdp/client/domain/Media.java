package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Media {

    private jpuppeteer.cdp.CDPSession session;

    public Media(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Enables the Media domain
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Media.enable", null);
    }


    /**
    * Disables the Media domain.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Media.disable", null);
    }

}