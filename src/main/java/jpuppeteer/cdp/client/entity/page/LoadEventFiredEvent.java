package jpuppeteer.cdp.client.entity.page;

/**
*/
public class LoadEventFiredEvent {

    /**
    */
    private java.math.BigDecimal timestamp;

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public LoadEventFiredEvent(java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public LoadEventFiredEvent() {
    }

}