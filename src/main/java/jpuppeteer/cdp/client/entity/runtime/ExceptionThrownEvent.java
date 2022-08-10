package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when exception was thrown and unhandled.
*/
public class ExceptionThrownEvent {

    /**
    * Timestamp of the exception.
    */
    private java.math.BigDecimal timestamp;

    /**
    */
    private jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setExceptionDetails (jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.exceptionDetails = exceptionDetails;
    }

    public jpuppeteer.cdp.client.entity.runtime.ExceptionDetails getExceptionDetails() {
        return this.exceptionDetails;
    }

    public ExceptionThrownEvent(java.math.BigDecimal timestamp, jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.timestamp = timestamp;
        this.exceptionDetails = exceptionDetails;
    }

    public ExceptionThrownEvent() {
    }

}