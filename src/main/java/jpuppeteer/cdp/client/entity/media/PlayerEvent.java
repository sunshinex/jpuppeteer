package jpuppeteer.cdp.client.entity.media;

/**
* Corresponds to kMediaEventTriggered
* experimental
*/
public class PlayerEvent {

    /**
    */
    public final java.math.BigDecimal timestamp;

    /**
    */
    public final String value;

    public PlayerEvent(java.math.BigDecimal timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

}