package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class FailRequestRequest {

    /**
    * An id the client received in requestPaused event.
    */
    public final String requestId;

    /**
    * Causes the request to fail with the given reason.
    */
    public final jpuppeteer.cdp.client.constant.network.ErrorReason errorReason;

    public FailRequestRequest(String requestId, jpuppeteer.cdp.client.constant.network.ErrorReason errorReason) {
        this.requestId = requestId;
        this.errorReason = errorReason;
    }

}