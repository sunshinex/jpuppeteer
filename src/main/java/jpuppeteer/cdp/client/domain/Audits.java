package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Audits {

    private jpuppeteer.cdp.CDPConnection connection;

    public Audits(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Returns the response body and size if it were re-encoded with the specified settings. Only applies to images.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.audits.GetEncodedResponseResponse> getEncodedResponse(jpuppeteer.cdp.client.entity.audits.GetEncodedResponseRequest request) {
        return connection.send("Audits.getEncodedResponse", request, jpuppeteer.cdp.client.entity.audits.GetEncodedResponseResponse.class);
    }


    /**
    * Disables issues domain, prevents further issues from being reported to the client.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("Audits.disable", null);
    }


    /**
    * Enables issues domain, sends the issues collected so far to the client by means of the `issueAdded` event.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("Audits.enable", null);
    }


    /**
    * Runs the contrast check for the target page. Found issues are reported using Audits.issueAdded event.
    */
    public jpuppeteer.util.XFuture<?> checkContrast(jpuppeteer.cdp.client.entity.audits.CheckContrastRequest request) {
        return connection.send("Audits.checkContrast", request);
    }

}