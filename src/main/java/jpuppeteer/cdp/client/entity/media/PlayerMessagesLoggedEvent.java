package jpuppeteer.cdp.client.entity.media;

/**
* Send a list of any messages that need to be delivered.
* experimental
*/
public class PlayerMessagesLoggedEvent {

    /**
    */
    public final String playerId;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.media.PlayerMessage> messages;

    public PlayerMessagesLoggedEvent(String playerId, java.util.List<jpuppeteer.cdp.client.entity.media.PlayerMessage> messages) {
        this.playerId = playerId;
        this.messages = messages;
    }

}