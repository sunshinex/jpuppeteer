package jpuppeteer.cdp.client.entity.network;

/**
* Fired exactly once for each Trust Token operation. Depending on the type of the operation and whether the operation succeeded or failed, the event is fired before the corresponding request was sent or after the response was received.
*/
public class TrustTokenOperationDoneEvent {

    /**
    * Detailed success or error status of the operation. 'AlreadyExists' also signifies a successful operation, as the result of the operation already exists und thus, the operation was abort preemptively (e.g. a cache hit).
    */
    private jpuppeteer.cdp.client.constant.network.TrustTokenOperationDoneEventStatus status;

    /**
    */
    private jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type;

    /**
    */
    private String requestId;

    /**
    * Top level origin. The context in which the operation was attempted.
    */
    private String topLevelOrigin;

    /**
    * Origin of the issuer in case of a "Issuance" or "Redemption" operation.
    */
    private String issuerOrigin;

    /**
    * The number of obtained Trust Tokens on a successful "Issuance" operation.
    */
    private Integer issuedTokenCount;

    public void setStatus (jpuppeteer.cdp.client.constant.network.TrustTokenOperationDoneEventStatus status) {
        this.status = status;
    }

    public jpuppeteer.cdp.client.constant.network.TrustTokenOperationDoneEventStatus getStatus() {
        return this.status;
    }

    public void setType (jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.network.TrustTokenOperationType getType() {
        return this.type;
    }

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setTopLevelOrigin (String topLevelOrigin) {
        this.topLevelOrigin = topLevelOrigin;
    }

    public String getTopLevelOrigin() {
        return this.topLevelOrigin;
    }

    public void setIssuerOrigin (String issuerOrigin) {
        this.issuerOrigin = issuerOrigin;
    }

    public String getIssuerOrigin() {
        return this.issuerOrigin;
    }

    public void setIssuedTokenCount (Integer issuedTokenCount) {
        this.issuedTokenCount = issuedTokenCount;
    }

    public Integer getIssuedTokenCount() {
        return this.issuedTokenCount;
    }

    public TrustTokenOperationDoneEvent(jpuppeteer.cdp.client.constant.network.TrustTokenOperationDoneEventStatus status, jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type, String requestId, String topLevelOrigin, String issuerOrigin, Integer issuedTokenCount) {
        this.status = status;
        this.type = type;
        this.requestId = requestId;
        this.topLevelOrigin = topLevelOrigin;
        this.issuerOrigin = issuerOrigin;
        this.issuedTokenCount = issuedTokenCount;
    }

    public TrustTokenOperationDoneEvent(jpuppeteer.cdp.client.constant.network.TrustTokenOperationDoneEventStatus status, jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type, String requestId) {
        this.status = status;
        this.type = type;
        this.requestId = requestId;
        this.topLevelOrigin = null;
        this.issuerOrigin = null;
        this.issuedTokenCount = null;
    }

    public TrustTokenOperationDoneEvent() {
    }

}