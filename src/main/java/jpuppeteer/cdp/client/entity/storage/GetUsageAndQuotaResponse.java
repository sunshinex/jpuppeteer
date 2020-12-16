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
    * Storage usage per type (bytes).
    */
    public final java.util.List<UsageForType> usageBreakdown;

    public GetUsageAndQuotaResponse(java.math.BigDecimal usage, java.math.BigDecimal quota, java.util.List<UsageForType> usageBreakdown) {
        this.usage = usage;
        this.quota = quota;
        this.usageBreakdown = usageBreakdown;
    }

}