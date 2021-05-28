package jpuppeteer.cdp.client.entity.security;

/**
* There is a certificate error. If overriding certificate errors is enabled, then it should be handled with the `handleCertificateError` command. Note: this event does not fire if the certificate error has been allowed internally. Only one client per target should override certificate errors at the same time.
*/
public class CertificateErrorEvent {

    /**
    * The ID of the event.
    */
    public final Integer eventId;

    /**
    * The type of the error.
    */
    public final String errorType;

    /**
    * The url that was requested.
    */
    public final String requestURL;

    public CertificateErrorEvent(Integer eventId, String errorType, String requestURL) {
        this.eventId = eventId;
        this.errorType = errorType;
        this.requestURL = requestURL;
    }

}