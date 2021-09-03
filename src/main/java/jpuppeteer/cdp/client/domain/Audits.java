package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Audits {

    private jpuppeteer.cdp.CDPSession session;

    public Audits(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Returns the response body and size if it were re-encoded with the specified settings. Only applies to images.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.audits.GetEncodedResponseResponse> getEncodedResponse(jpuppeteer.cdp.client.entity.audits.GetEncodedResponseRequest request) {
        return session.send("Audits.getEncodedResponse", request, jpuppeteer.cdp.client.entity.audits.GetEncodedResponseResponse.class);
    }


    /**
    * Disables issues domain, prevents further issues from being reported to the client.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Audits.disable", null);
    }


    /**
    * Enables issues domain, sends the issues collected so far to the client by means of the `issueAdded` event.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Audits.enable", null);
    }


    /**
    * Runs the contrast check for the target page. Found issues are reported using Audits.issueAdded event.
    */
    public io.netty.util.concurrent.Future checkContrast(jpuppeteer.cdp.client.entity.audits.CheckContrastRequest request) {
        return session.send("Audits.checkContrast", request);
    }

}