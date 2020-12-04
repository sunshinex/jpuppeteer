package jpuppeteer.cdp.client.entity.network;

/**
*/
public class EnableRequest {

    /**
    * Buffer size in bytes to use when preserving network payloads (XHRs, etc).
    */
    public final Integer maxTotalBufferSize;

    /**
    * Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc).
    */
    public final Integer maxResourceBufferSize;

    /**
    * Longest post body size (in bytes) that would be included in requestWillBeSent notification
    */
    public final Integer maxPostDataSize;

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