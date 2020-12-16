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

}