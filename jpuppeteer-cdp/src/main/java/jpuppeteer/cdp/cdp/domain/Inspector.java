package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("Inspector.disable", null, timeout);
    }


    /**
    * Enables inspector domain notifications.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("Inspector.enable", null, timeout);
    }

}