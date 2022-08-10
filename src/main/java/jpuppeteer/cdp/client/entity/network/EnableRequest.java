package jpuppeteer.cdp.client.entity.network;

/**
*/
public class EnableRequest {

    /**
    * Buffer size in bytes to use when preserving network payloads (XHRs, etc).
    */
    private Integer maxTotalBufferSize;

    /**
    * Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc).
    */
    private Integer maxResourceBufferSize;

    /**
    * Longest post body size (in bytes) that would be included in requestWillBeSent notification
    */
    private Integer maxPostDataSize;

    public void setMaxTotalBufferSize (Integer maxTotalBufferSize) {
        this.maxTotalBufferSize = maxTotalBufferSize;
    }

    public Integer getMaxTotalBufferSize() {
        return this.maxTotalBufferSize;
    }

    public void setMaxResourceBufferSize (Integer maxResourceBufferSize) {
        this.maxResourceBufferSize = maxResourceBufferSize;
    }

    public Integer getMaxResourceBufferSize() {
        return this.maxResourceBufferSize;
    }

    public void setMaxPostDataSize (Integer maxPostDataSize) {
        this.maxPostDataSize = maxPostDataSize;
    }

    public Integer getMaxPostDataSize() {
        return this.maxPostDataSize;
    }

    public EnableRequest(Integer maxTotalBufferSize, Integer maxResourceBufferSize, Integer maxPostDataSize) {
        this.maxTotalBufferSize = maxTotalBufferSize;
        this.maxResourceBufferSize = maxResourceBufferSize;
        this.maxPostDataSize = maxPostDataSize;
    }

    public EnableRequest() {
        this.maxTotalBufferSize = null;
        this.maxResourceBufferSize = null;
        this.maxPostDataSize = null;
    }

}