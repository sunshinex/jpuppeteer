package jpuppeteer.cdp.client.entity.media;

/**
* Send a list of any errors that need to be delivered.
* experimental
*/
public class PlayerErrorsRaisedEvent {

    /**
    */
    public final String playerId;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.media.PlayerError> errors;

    public PlayerErrorsRaisedEvent(String playerId, java.util.List<jpuppeteer.cdp.client.entity.media.PlayerError> errors) {
        this.playerId = playerId;
        this.errors = errors;
    }

}