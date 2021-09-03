package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class TakePreciseCoverageResponse {

    /**
    * Coverage data for the current isolate.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result;

    /**
    * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
    */
    public final java.math.BigDecimal timestamp;

    public TakePreciseCoverageResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result, java.math.BigDecimal timestamp) {
        this.result = result;
        this.timestamp = timestamp;
    }

}