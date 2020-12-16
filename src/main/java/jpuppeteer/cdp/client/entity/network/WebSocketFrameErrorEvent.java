package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket message error occurs.
*/
public class WebSocketFrameErrorEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * WebSocket error message.
    */
    public final String errorMessage;

    public WebSocketFrameErrorEvent(String requestId, java.math.BigDecimal timestamp, String errorMessage) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
    }

}