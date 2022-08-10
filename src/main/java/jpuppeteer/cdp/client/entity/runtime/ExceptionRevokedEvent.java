package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when unhandled exception was revoked.
*/
public class ExceptionRevokedEvent {

    /**
    * Reason describing why exception was revoked.
    */
    private String reason;

    /**
    * The id of revoked exception, as reported in `exceptionThrown`.
    */
    private Integer exceptionId;

    public void setReason (String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public void setExceptionId (Integer exceptionId) {
        this.exceptionId = exceptionId;
    }

    public Integer getExceptionId() {
        return this.exceptionId;
    }

    public ExceptionRevokedEvent(String reason, Integer exceptionId) {
        this.reason = reason;
        this.exceptionId = exceptionId;
    }

    public ExceptionRevokedEvent() {
    }

}