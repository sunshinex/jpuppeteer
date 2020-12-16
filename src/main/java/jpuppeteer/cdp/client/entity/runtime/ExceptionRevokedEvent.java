package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when unhandled exception was revoked.
*/
public class ExceptionRevokedEvent {

    /**
    * Reason describing why exception was revoked.
    */
    public final String reason;

    /**
    * The id of revoked exception, as reported in `exceptionThrown`.
    */
    public final Integer exceptionId;

    public ExceptionRevokedEvent(String reason, Integer exceptionId) {
        this.reason = reason;
        this.exceptionId = exceptionId;
    }

}