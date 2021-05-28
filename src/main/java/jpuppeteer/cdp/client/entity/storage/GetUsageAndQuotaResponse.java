package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class GetUsageAndQuotaResponse {

    /**
    * Storage usage (bytes).
    */
    public final java.math.BigDecimal usage;

    /**
    * Storage quota (bytes).
    */
    public final java.math.BigDecimal quota;

    /**
    * Whether or not the origin has an active storage quota override
    */
    public final Boolean overrideActive;

    /**
    * Storage usage per type (bytes).
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.storage.UsageForType> usageBreakdown;

    public GetUsageAndQuotaResponse(java.math.BigDecimal usage, java.math.BigDecimal quota, Boolean overrideActive, java.util.List<jpuppeteer.cdp.client.entity.storage.UsageForType> usageBreakdown) {
        this.usage = usage;
        this.quota = quota;
        this.overrideActive = overrideActive;
        this.usageBreakdown = usageBreakdown;
    }

}