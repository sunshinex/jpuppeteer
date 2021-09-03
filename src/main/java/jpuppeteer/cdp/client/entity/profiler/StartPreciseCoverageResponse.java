package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class StartPreciseCoverageResponse {

    /**
    * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
    */
    public final java.math.BigDecimal timestamp;

    public StartPreciseCoverageResponse(java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

}