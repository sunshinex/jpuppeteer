package jpuppeteer.cdp.client.entity.profiler;

/**
* Reports coverage delta since the last poll (either from an event like this, or from `takePreciseCoverage` for the current isolate. May only be sent if precise code coverage has been started. This event can be trigged by the embedder to, for example, trigger collection of coverage data immediatelly at a certain point in time.
*/
public class PreciseCoverageDeltaUpdateEvent {

    /**
    * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Identifier for distinguishing coverage events.
    */
    public final String occassion;

    /**
    * Coverage data for the current isolate.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result;

    public PreciseCoverageDeltaUpdateEvent(java.math.BigDecimal timestamp, String occassion, java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result) {
        this.timestamp = timestamp;
        this.occassion = occassion;
        this.result = result;
    }

}