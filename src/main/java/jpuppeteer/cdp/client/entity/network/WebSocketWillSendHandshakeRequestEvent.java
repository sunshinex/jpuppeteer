package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket is about to initiate handshake.
*/
public class WebSocketWillSendHandshakeRequestEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * UTC Timestamp.
    */
    private java.math.BigDecimal wallTime;

    /**
    * WebSocket request data.
    */
    private jpuppeteer.cdp.client.entity.network.WebSocketRequest request;

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

    public void setWallTime (java.math.BigDecimal wallTime) {
        this.wallTime = wallTime;
    }

    public java.math.BigDecimal getWallTime() {
        return this.wallTime;
    }

    public void setRequest (jpuppeteer.cdp.client.entity.network.WebSocketRequest request) {
        this.request = request;
    }

    public jpuppeteer.cdp.client.entity.network.WebSocketRequest getRequest() {
        return this.request;
    }

    public WebSocketWillSendHandshakeRequestEvent(String requestId, java.math.BigDecimal timestamp, java.math.BigDecimal wallTime, jpuppeteer.cdp.client.entity.network.WebSocketRequest request) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.wallTime = wallTime;
        this.request = request;
    }

    public WebSocketWillSendHandshakeRequestEvent() {
    }

}