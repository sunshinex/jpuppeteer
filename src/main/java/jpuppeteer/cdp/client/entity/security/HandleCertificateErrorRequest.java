package jpuppeteer.cdp.client.entity.security;

/**
*/
public class HandleCertificateErrorRequest {

    /**
    * The ID of the event.
    */
    public final Integer eventId;

    /**
    * The action to take on the certificate error.
    */
    public final jpuppeteer.cdp.client.constant.security.CertificateErrorAction action;

    public HandleCertificateErrorRequest(Integer eventId, jpuppeteer.cdp.client.constant.security.CertificateErrorAction action) {
        this.eventId = eventId;
        this.action = action;
    }

}