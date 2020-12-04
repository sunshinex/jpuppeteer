package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when exception was thrown and unhandled.
*/
public class ExceptionThrownEvent {

    /**
    * Timestamp of the exception.
    */
    public final java.math.BigDecimal timestamp;

    /**
    */
    public final jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public ExceptionThrownEvent(java.math.BigDecimal timestamp, jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.timestamp = timestamp;
        this.exceptionDetails = exceptionDetails;
    }

}