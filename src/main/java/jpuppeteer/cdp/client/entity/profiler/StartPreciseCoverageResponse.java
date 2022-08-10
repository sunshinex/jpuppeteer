package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class StartPreciseCoverageResponse {

    /**
    * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
    */
    private java.math.BigDecimal timestamp;

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public StartPreciseCoverageResponse(java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public StartPreciseCoverageResponse() {
    }

}