package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket is closed.
*/
public class WebSocketClosedEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

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

    public WebSocketClosedEvent(String requestId, java.math.BigDecimal timestamp) {
        this.requestId = requestId;
        this.timestamp = timestamp;
    }

    public WebSocketClosedEvent() {
    }

}