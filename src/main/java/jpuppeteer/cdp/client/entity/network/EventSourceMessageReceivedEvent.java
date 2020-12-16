package jpuppeteer.cdp.client.entity.network;

/**
* Fired when EventSource message is received.
*/
public class EventSourceMessageReceivedEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Message type.
    */
    public final String eventName;

    /**
    * Message identifier.
    */
    public final String eventId;

    /**
    * Message content.
    */
    public final String data;

    public EventSourceMessageReceivedEvent(String requestId, java.math.BigDecimal timestamp, String eventName, String eventId, String data) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.eventName = eventName;
        this.eventId = eventId;
        this.data = data;
    }

}