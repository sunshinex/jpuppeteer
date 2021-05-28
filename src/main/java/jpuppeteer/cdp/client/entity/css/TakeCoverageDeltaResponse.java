package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class TakeCoverageDeltaResponse {

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> coverage;

    /**
    * Monotonically increasing time, in seconds.
    */
    public final java.math.BigDecimal timestamp;

    public TakeCoverageDeltaResponse(java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> coverage, java.math.BigDecimal timestamp) {
        this.coverage = coverage;
        this.timestamp = timestamp;
    }

}