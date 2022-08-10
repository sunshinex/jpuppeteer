package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class TakePreciseCoverageResponse {

    /**
    * Coverage data for the current isolate.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result;

    /**
    * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
    */
    private java.math.BigDecimal timestamp;

    public void setResult (java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result) {
        this.result = result;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> getResult() {
        return this.result;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public TakePreciseCoverageResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result, java.math.BigDecimal timestamp) {
        this.result = result;
        this.timestamp = timestamp;
    }

    public TakePreciseCoverageResponse() {
    }

}