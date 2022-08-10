package jpuppeteer.cdp.client.entity.network;

/**
* Fired when resource loading priority is changed
*/
public class ResourceChangedPriorityEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * New priority
    */
    private jpuppeteer.cdp.client.constant.network.ResourcePriority newPriority;

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

    public void setNewPriority (jpuppeteer.cdp.client.constant.network.ResourcePriority newPriority) {
        this.newPriority = newPriority;
    }

    public jpuppeteer.cdp.client.constant.network.ResourcePriority getNewPriority() {
        return this.newPriority;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public ResourceChangedPriorityEvent(String requestId, jpuppeteer.cdp.client.constant.network.ResourcePriority newPriority, java.math.BigDecimal timestamp) {
        this.requestId = requestId;
        this.newPriority = newPriority;
        this.timestamp = timestamp;
    }

    public ResourceChangedPriorityEvent() {
    }

}