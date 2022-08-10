package jpuppeteer.cdp.client.entity.media;

/**
* Send a list of any errors that need to be delivered.
* experimental
*/
public class PlayerErrorsRaisedEvent {

    /**
    */
    private String playerId;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.media.PlayerError> errors;

    public void setPlayerId (String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return this.playerId;
    }

    public void setErrors (java.util.List<jpuppeteer.cdp.client.entity.media.PlayerError> errors) {
        this.errors = errors;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.media.PlayerError> getErrors() {
        return this.errors;
    }

    public PlayerErrorsRaisedEvent(String playerId, java.util.List<jpuppeteer.cdp.client.entity.media.PlayerError> errors) {
        this.playerId = playerId;
        this.errors = errors;
    }

    public PlayerErrorsRaisedEvent() {
    }

}