package jpuppeteer.cdp.client.entity.page;

/**
*/
public class DomContentEventFiredEvent {

    /**
    */
    private java.math.BigDecimal timestamp;

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public DomContentEventFiredEvent(java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public DomContentEventFiredEvent() {
    }

}