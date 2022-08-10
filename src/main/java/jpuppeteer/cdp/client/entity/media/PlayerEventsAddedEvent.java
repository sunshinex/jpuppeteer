package jpuppeteer.cdp.client.entity.media;

/**
* Send events as a list, allowing them to be batched on the browser for less congestion. If batched, events must ALWAYS be in chronological order.
* experimental
*/
public class PlayerEventsAddedEvent {

    /**
    */
    private String playerId;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.media.PlayerEvent> events;

    public void setPlayerId (String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return this.playerId;
    }

    public void setEvents (java.util.List<jpuppeteer.cdp.client.entity.media.PlayerEvent> events) {
        this.events = events;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.media.PlayerEvent> getEvents() {
        return this.events;
    }

    public PlayerEventsAddedEvent(String playerId, java.util.List<jpuppeteer.cdp.client.entity.media.PlayerEvent> events) {
        this.playerId = playerId;
        this.events = events;
    }

    public PlayerEventsAddedEvent() {
    }

}