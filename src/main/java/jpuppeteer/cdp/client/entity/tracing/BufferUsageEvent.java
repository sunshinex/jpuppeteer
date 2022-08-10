package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class BufferUsageEvent {

    /**
    * A number in range [0..1] that indicates the used size of event buffer as a fraction of its total size.
    */
    private java.math.BigDecimal percentFull;

    /**
    * An approximate number of events in the trace log.
    */
    private java.math.BigDecimal eventCount;

    /**
    * A number in range [0..1] that indicates the used size of event buffer as a fraction of its total size.
    */
    private java.math.BigDecimal value;

    public void setPercentFull (java.math.BigDecimal percentFull) {
        this.percentFull = percentFull;
    }

    public java.math.BigDecimal getPercentFull() {
        return this.percentFull;
    }

    public void setEventCount (java.math.BigDecimal eventCount) {
        this.eventCount = eventCount;
    }

    public java.math.BigDecimal getEventCount() {
        return this.eventCount;
    }

    public void setValue (java.math.BigDecimal value) {
        this.value = value;
    }

    public java.math.BigDecimal getValue() {
        return this.value;
    }

    public BufferUsageEvent(java.math.BigDecimal percentFull, java.math.BigDecimal eventCount, java.math.BigDecimal value) {
        this.percentFull = percentFull;
        this.eventCount = eventCount;
        this.value = value;
    }

    public BufferUsageEvent() {
        this.percentFull = null;
        this.eventCount = null;
        this.value = null;
    }

}