package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GetHeapUsageResponse {

    /**
    * Used heap size in bytes.
    */
    public final java.math.BigDecimal usedSize;

    /**
    * Allocated heap size in bytes.
    */
    public final java.math.BigDecimal totalSize;

    public GetHeapUsageResponse(java.math.BigDecimal usedSize, java.math.BigDecimal totalSize) {
        this.usedSize = usedSize;
        this.totalSize = totalSize;
    }

}