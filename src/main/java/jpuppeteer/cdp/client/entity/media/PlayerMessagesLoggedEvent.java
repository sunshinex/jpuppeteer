package jpuppeteer.cdp.client.entity.media;

/**
* Send a list of any messages that need to be delivered.
* experimental
*/
public class PlayerMessagesLoggedEvent {

    /**
    */
    private String playerId;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.media.PlayerMessage> messages;

    public void setPlayerId (String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return this.playerId;
    }

    public void setMessages (java.util.List<jpuppeteer.cdp.client.entity.media.PlayerMessage> messages) {
        this.messages = messages;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.media.PlayerMessage> getMessages() {
        return this.messages;
    }

    public PlayerMessagesLoggedEvent(String playerId, java.util.List<jpuppeteer.cdp.client.entity.media.PlayerMessage> messages) {
        this.playerId = playerId;
        this.messages = messages;
    }

    public PlayerMessagesLoggedEvent() {
    }

}