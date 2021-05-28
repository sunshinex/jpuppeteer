package jpuppeteer.cdp.client.entity.network;

/**
* Fired exactly once for each Trust Token operation. Depending on the type of the operation and whether the operation succeeded or failed, the event is fired before the corresponding request was sent or after the response was received.
*/
public class TrustTokenOperationDoneEvent {

    /**
    * Detailed success or error status of the operation. 'AlreadyExists' also signifies a successful operation, as the result of the operation already exists und thus, the operation was abort preemptively (e.g. a cache hit).
    */
    public final jpuppeteer.cdp.client.constant.network.TrustTokenOperationDoneEventStatus status;

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type;

    /**
    */
    public final String requestId;

    /**
    * Top level origin. The context in which the operation was attempted.
    */
    public final String topLevelOrigin;

    /**
    * Origin of the issuer in case of a "Issuance" or "Redemption" operation.
    */
    public final String issuerOrigin;

    /**
    * The number of obtained Trust Tokens on a successful "Issuance" operation.
    */
    public final Integer issuedTokenCount;

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

}