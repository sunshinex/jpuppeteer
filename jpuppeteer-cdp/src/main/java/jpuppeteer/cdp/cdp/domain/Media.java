package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("Media.enable", null, timeout);
    }


    /**
    * Disables the Media domain.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("Media.disable", null, timeout);
    }

}