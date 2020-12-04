package jpuppeteer.cdp.client.entity.fetch;

/**
* experimental
*/
public class FailRequestRequest {

    /**
    * An id the client received in requestPaused event.
    */
    public final String requestId;

    /**
    * Causes the request to fail with the given reason.
    */
    public final String errorReason;

    public FailRequestRequest(String requestId, String errorReason) {
        this.requestId = requestId;
        this.errorReason = errorReason;
    }

}