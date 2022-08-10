package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class GetUsageAndQuotaResponse {

    /**
    * Storage usage (bytes).
    */
    private java.math.BigDecimal usage;

    /**
    * Storage quota (bytes).
    */
    private java.math.BigDecimal quota;

    /**
    * Whether or not the origin has an active storage quota override
    */
    private Boolean overrideActive;

    /**
    * Storage usage per type (bytes).
    */
    private java.util.List<jpuppeteer.cdp.client.entity.storage.UsageForType> usageBreakdown;

    public void setUsage (java.math.BigDecimal usage) {
        this.usage = usage;
    }

    public java.math.BigDecimal getUsage() {
        return this.usage;
    }

    public void setQuota (java.math.BigDecimal quota) {
        this.quota = quota;
    }

    public java.math.BigDecimal getQuota() {
        return this.quota;
    }

    public void setOverrideActive (Boolean overrideActive) {
        this.overrideActive = overrideActive;
    }

    public Boolean getOverrideActive() {
        return this.overrideActive;
    }

    public void setUsageBreakdown (java.util.List<jpuppeteer.cdp.client.entity.storage.UsageForType> usageBreakdown) {
        this.usageBreakdown = usageBreakdown;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.storage.UsageForType> getUsageBreakdown() {
        return this.usageBreakdown;
    }

    public GetUsageAndQuotaResponse(java.math.BigDecimal usage, java.math.BigDecimal quota, Boolean overrideActive, java.util.List<jpuppeteer.cdp.client.entity.storage.UsageForType> usageBreakdown) {
        this.usage = usage;
        this.quota = quota;
        this.overrideActive = overrideActive;
        this.usageBreakdown = usageBreakdown;
    }

    public GetUsageAndQuotaResponse() {
    }

}