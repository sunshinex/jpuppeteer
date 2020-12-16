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
    public final jpuppeteer.cdp.client.constant.network.ResourcePriority newPriority;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    public ResourceChangedPriorityEvent(String requestId, jpuppeteer.cdp.client.constant.network.ResourcePriority newPriority, java.math.BigDecimal timestamp) {
        this.requestId = requestId;
        this.newPriority = newPriority;
        this.timestamp = timestamp;
    }

}