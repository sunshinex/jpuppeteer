package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class TakeCoverageDeltaResponse {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> coverage;

    /**
    * Monotonically increasing time, in seconds.
    */
    private java.math.BigDecimal timestamp;

    public void setCoverage (java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> coverage) {
        this.coverage = coverage;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> getCoverage() {
        return this.coverage;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public TakeCoverageDeltaResponse(java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> coverage, java.math.BigDecimal timestamp) {
        this.coverage = coverage;
        this.timestamp = timestamp;
    }

    public TakeCoverageDeltaResponse() {
    }

}