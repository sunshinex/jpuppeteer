package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket message is received.
*/
public class WebSocketFrameReceivedEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * WebSocket response data.
    */
    public final WebSocketFrame response;

    public WebSocketFrameReceivedEvent(String requestId, java.math.BigDecimal timestamp, WebSocketFrame response) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.response = response;
    }

}