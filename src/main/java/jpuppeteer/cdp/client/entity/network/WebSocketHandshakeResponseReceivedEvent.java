package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket handshake response becomes available.
*/
public class WebSocketHandshakeResponseReceivedEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * WebSocket response data.
    */
    private jpuppeteer.cdp.client.entity.network.WebSocketResponse response;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setResponse (jpuppeteer.cdp.client.entity.network.WebSocketResponse response) {
        this.response = response;
    }

    public jpuppeteer.cdp.client.entity.network.WebSocketResponse getResponse() {
        return this.response;
    }

    public WebSocketHandshakeResponseReceivedEvent(String requestId, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.entity.network.WebSocketResponse response) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.response = response;
    }

    public WebSocketHandshakeResponseReceivedEvent() {
    }

}