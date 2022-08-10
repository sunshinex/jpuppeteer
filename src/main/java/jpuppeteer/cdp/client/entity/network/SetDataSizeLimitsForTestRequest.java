package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetDataSizeLimitsForTestRequest {

    /**
    * Maximum total buffer size.
    */
    private Integer maxTotalSize;

    /**
    * Maximum per-resource size.
    */
    private Integer maxResourceSize;

    public void setMaxTotalSize (Integer maxTotalSize) {
        this.maxTotalSize = maxTotalSize;
    }

    public Integer getMaxTotalSize() {
        return this.maxTotalSize;
    }

    public void setMaxResourceSize (Integer maxResourceSize) {
        this.maxResourceSize = maxResourceSize;
    }

    public Integer getMaxResourceSize() {
        return this.maxResourceSize;
    }

    public SetDataSizeLimitsForTestRequest(Integer maxTotalSize, Integer maxResourceSize) {
        this.maxTotalSize = maxTotalSize;
        this.maxResourceSize = maxResourceSize;
    }

    public SetDataSizeLimitsForTestRequest() {
    }

}