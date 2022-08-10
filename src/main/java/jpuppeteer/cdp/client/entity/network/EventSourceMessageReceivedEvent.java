package jpuppeteer.cdp.client.entity.network;

/**
* Fired when EventSource message is received.
*/
public class EventSourceMessageReceivedEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Message type.
    */
    private String eventName;

    /**
    * Message identifier.
    */
    private String eventId;

    /**
    * Message content.
    */
    private String data;

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

    public void setEventName (String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventId (String eventId) {
        this.eventId = eventId;
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public EventSourceMessageReceivedEvent(String requestId, java.math.BigDecimal timestamp, String eventName, String eventId, String data) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.eventName = eventName;
        this.eventId = eventId;
        this.data = data;
    }

    public EventSourceMessageReceivedEvent() {
    }

}