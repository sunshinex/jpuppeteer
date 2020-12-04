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
    public final String action;

    public HandleCertificateErrorRequest(Integer eventId, String action) {
        this.eventId = eventId;
        this.action = action;
    }

}