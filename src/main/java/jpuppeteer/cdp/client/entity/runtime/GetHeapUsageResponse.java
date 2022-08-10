package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GetHeapUsageResponse {

    /**
    * Used heap size in bytes.
    */
    private java.math.BigDecimal usedSize;

    /**
    * Allocated heap size in bytes.
    */
    private java.math.BigDecimal totalSize;

    public void setUsedSize (java.math.BigDecimal usedSize) {
        this.usedSize = usedSize;
    }

    public java.math.BigDecimal getUsedSize() {
        return this.usedSize;
    }

    public void setTotalSize (java.math.BigDecimal totalSize) {
        this.totalSize = totalSize;
    }

    public java.math.BigDecimal getTotalSize() {
        return this.totalSize;
    }

    public GetHeapUsageResponse(java.math.BigDecimal usedSize, java.math.BigDecimal totalSize) {
        this.usedSize = usedSize;
        this.totalSize = totalSize;
    }

    public GetHeapUsageResponse() {
    }

}