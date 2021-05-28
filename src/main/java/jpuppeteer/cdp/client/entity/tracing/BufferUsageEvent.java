package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class BufferUsageEvent {

    /**
    * A number in range [0..1] that indicates the used size of event buffer as a fraction of its total size.
    */
    public final java.math.BigDecimal percentFull;

    /**
    * An approximate number of events in the trace log.
    */
    public final java.math.BigDecimal eventCount;

    /**
    * A number in range [0..1] that indicates the used size of event buffer as a fraction of its total size.
    */
    public final java.math.BigDecimal value;

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