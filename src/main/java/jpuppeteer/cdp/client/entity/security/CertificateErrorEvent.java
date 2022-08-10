package jpuppeteer.cdp.client.entity.security;

/**
* There is a certificate error. If overriding certificate errors is enabled, then it should be handled with the `handleCertificateError` command. Note: this event does not fire if the certificate error has been allowed internally. Only one client per target should override certificate errors at the same time.
*/
public class CertificateErrorEvent {

    /**
    * The ID of the event.
    */
    private Integer eventId;

    /**
    * The type of the error.
    */
    private String errorType;

    /**
    * The url that was requested.
    */
    private String requestURL;

    public void setEventId (Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return this.eventId;
    }

    public void setErrorType (String errorType) {
        this.errorType = errorType;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public void setRequestURL (String requestURL) {
        this.requestURL = requestURL;
    }

    public String getRequestURL() {
        return this.requestURL;
    }

    public CertificateErrorEvent(Integer eventId, String errorType, String requestURL) {
        this.eventId = eventId;
        this.errorType = errorType;
        this.requestURL = requestURL;
    }

    public CertificateErrorEvent() {
    }

}