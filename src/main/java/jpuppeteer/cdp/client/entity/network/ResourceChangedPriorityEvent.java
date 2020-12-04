package jpuppeteer.cdp.client.entity.network;

/**
* Fired when resource loading priority is changed
*/
public class ResourceChangedPriorityEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * New priority
    */
    public final String newPriority;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    public ResourceChangedPriorityEvent(String requestId, String newPriority, java.math.BigDecimal timestamp) {
        this.requestId = requestId;
        this.newPriority = newPriority;
        this.timestamp = timestamp;
    }

}