package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket handshake response becomes available.
*/
public class WebSocketHandshakeResponseReceivedEvent {

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
    public final jpuppeteer.cdp.client.entity.network.WebSocketResponse response;

    public WebSocketHandshakeResponseReceivedEvent(String requestId, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.entity.network.WebSocketResponse response) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.response = response;
    }

}