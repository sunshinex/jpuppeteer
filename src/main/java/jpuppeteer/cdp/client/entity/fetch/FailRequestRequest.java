package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class FailRequestRequest {

    /**
    * An id the client received in requestPaused event.
    */
    private String requestId;

    /**
    * Causes the request to fail with the given reason.
    */
    private jpuppeteer.cdp.client.constant.network.ErrorReason errorReason;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setErrorReason (jpuppeteer.cdp.client.constant.network.ErrorReason errorReason) {
        this.errorReason = errorReason;
    }

    public jpuppeteer.cdp.client.constant.network.ErrorReason getErrorReason() {
        return this.errorReason;
    }

    public FailRequestRequest(String requestId, jpuppeteer.cdp.client.constant.network.ErrorReason errorReason) {
        this.requestId = requestId;
        this.errorReason = errorReason;
    }

    public FailRequestRequest() {
    }

}