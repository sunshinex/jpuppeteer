package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetDataSizeLimitsForTestRequest {

    /**
    * Maximum total buffer size.
    */
    public final Integer maxTotalSize;

    /**
    * Maximum per-resource size.
    */
    public final Integer maxResourceSize;

    public SetDataSizeLimitsForTestRequest(Integer maxTotalSize, Integer maxResourceSize) {
        this.maxTotalSize = maxTotalSize;
        this.maxResourceSize = maxResourceSize;
    }

}