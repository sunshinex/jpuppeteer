package jpuppeteer.cdp.client.entity.security;

/**
*/
public class HandleCertificateErrorRequest {

    /**
    * The ID of the event.
    */
    private Integer eventId;

    /**
    * The action to take on the certificate error.
    */
    private jpuppeteer.cdp.client.constant.security.CertificateErrorAction action;

    public void setEventId (Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return this.eventId;
    }

    public void setAction (jpuppeteer.cdp.client.constant.security.CertificateErrorAction action) {
        this.action = action;
    }

    public jpuppeteer.cdp.client.constant.security.CertificateErrorAction getAction() {
        return this.action;
    }

    public HandleCertificateErrorRequest(Integer eventId, jpuppeteer.cdp.client.constant.security.CertificateErrorAction action) {
        this.eventId = eventId;
        this.action = action;
    }

    public HandleCertificateErrorRequest() {
    }

}