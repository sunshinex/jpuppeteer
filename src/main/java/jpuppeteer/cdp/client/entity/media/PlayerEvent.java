package jpuppeteer.cdp.client.entity.media;

/**
* experimental
*/
public class PlayerEvent {

    /**
    */
    public final jpuppeteer.cdp.client.constant.media.PlayerEventType type;

    /**
    * Events are timestamped relative to the start of the player creation not relative to the start of playback.
    */
    public final java.math.BigDecimal timestamp;

    /**
    */
    public final String name;

    /**
    */
    public final String value;

    public PlayerEvent(jpuppeteer.cdp.client.constant.media.PlayerEventType type, java.math.BigDecimal timestamp, String name, String value) {
        this.type = type;
        this.timestamp = timestamp;
        this.name = name;
        this.value = value;
    }

}