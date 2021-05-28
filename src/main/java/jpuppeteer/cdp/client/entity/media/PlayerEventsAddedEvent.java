package jpuppeteer.cdp.client.entity.media;

/**
* Send events as a list, allowing them to be batched on the browser for less congestion. If batched, events must ALWAYS be in chronological order.
* experimental
*/
public class PlayerEventsAddedEvent {

    /**
    */
    public final String playerId;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.media.PlayerEvent> events;

    public PlayerEventsAddedEvent(String playerId, java.util.List<jpuppeteer.cdp.client.entity.media.PlayerEvent> events) {
        this.playerId = playerId;
        this.events = events;
    }

}