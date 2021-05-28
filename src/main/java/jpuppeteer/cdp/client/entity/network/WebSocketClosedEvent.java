package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket is closed.
*/
public class WebSocketClosedEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    public WebSocketClosedEvent(String requestId, java.math.BigDecimal timestamp) {
        this.requestId = requestId;
        this.timestamp = timestamp;
    }

}