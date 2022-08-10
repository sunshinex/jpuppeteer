package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebSocket message error occurs.
*/
public class WebSocketFrameErrorEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * WebSocket error message.
    */
    private String errorMessage;

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

    public void setErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public WebSocketFrameErrorEvent(String requestId, java.math.BigDecimal timestamp, String errorMessage) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
    }

    public WebSocketFrameErrorEvent() {
    }

}