package jpuppeteer.cdp.client.entity.profiler;

/**
* Reports coverage delta since the last poll (either from an event like this, or from `takePreciseCoverage` for the current isolate. May only be sent if precise code coverage has been started. This event can be trigged by the embedder to, for example, trigger collection of coverage data immediatelly at a certain point in time.
*/
public class PreciseCoverageDeltaUpdateEvent {

    /**
    * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Identifier for distinguishing coverage events.
    */
    private String occassion;

    /**
    * Coverage data for the current isolate.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result;

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setOccassion (String occassion) {
        this.occassion = occassion;
    }

    public String getOccassion() {
        return this.occassion;
    }

    public void setResult (java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result) {
        this.result = result;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> getResult() {
        return this.result;
    }

    public PreciseCoverageDeltaUpdateEvent(java.math.BigDecimal timestamp, String occassion, java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result) {
        this.timestamp = timestamp;
        this.occassion = occassion;
        this.result = result;
    }

    public PreciseCoverageDeltaUpdateEvent() {
    }

}