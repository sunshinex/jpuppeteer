package jpuppeteer.cdp.client.entity.media;

/**
* Corresponds to kMediaEventTriggered
* experimental
*/
public class PlayerEvent {

    /**
    */
    private java.math.BigDecimal timestamp;

    /**
    */
    private String value;

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public PlayerEvent(java.math.BigDecimal timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public PlayerEvent() {
    }

}