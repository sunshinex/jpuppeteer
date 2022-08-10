package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket message is sent.
*/
public class WebSocketFrameSentEvent {

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
    private jpuppeteer.cdp.client.entity.network.WebSocketFrame response;

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

    public void setResponse (jpuppeteer.cdp.client.entity.network.WebSocketFrame response) {
        this.response = response;
    }

    public jpuppeteer.cdp.client.entity.network.WebSocketFrame getResponse() {
        return this.response;
    }

    public WebSocketFrameSentEvent(String requestId, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.entity.network.WebSocketFrame response) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.response = response;
    }

    public WebSocketFrameSentEvent() {
    }

}