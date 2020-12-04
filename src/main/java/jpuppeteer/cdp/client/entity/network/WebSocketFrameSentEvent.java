package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket message is sent.
*/
public class WebSocketFrameSentEvent {

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
    public final jpuppeteer.cdp.client.entity.network.WebSocketFrame response;

    public WebSocketFrameSentEvent(String requestId, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.entity.network.WebSocketFrame response) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.response = response;
    }

}