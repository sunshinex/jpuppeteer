package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class OverrideQuotaForOriginRequest {

    /**
    * Security origin.
    */
    private String origin;

    /**
    * The quota size (in bytes) to override the original quota with. If this is called multiple times, the overridden quota will be equal to the quotaSize provided in the final call. If this is called without specifying a quotaSize, the quota will be reset to the default value for the specified origin. If this is called multiple times with different origins, the override will be maintained for each origin until it is disabled (called without a quotaSize).
    */
    private java.math.BigDecimal quotaSize;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setQuotaSize (java.math.BigDecimal quotaSize) {
        this.quotaSize = quotaSize;
    }

    public java.math.BigDecimal getQuotaSize() {
        return this.quotaSize;
    }

    public OverrideQuotaForOriginRequest(String origin, java.math.BigDecimal quotaSize) {
        this.origin = origin;
        this.quotaSize = quotaSize;
    }

    public OverrideQuotaForOriginRequest(String origin) {
        this.origin = origin;
        this.quotaSize = null;
    }

    public OverrideQuotaForOriginRequest() {
    }

}