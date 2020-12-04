package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket is about to initiate handshake.
*/
public class WebSocketWillSendHandshakeRequestEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * UTC Timestamp.
    */
    public final java.math.BigDecimal wallTime;

    /**
    * WebSocket request data.
    */
    public final jpuppeteer.cdp.client.entity.network.WebSocketRequest request;

    public WebSocketWillSendHandshakeRequestEvent(String requestId, java.math.BigDecimal timestamp, java.math.BigDecimal wallTime, jpuppeteer.cdp.client.entity.network.WebSocketRequest request) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.wallTime = wallTime;
        this.request = request;
    }

}