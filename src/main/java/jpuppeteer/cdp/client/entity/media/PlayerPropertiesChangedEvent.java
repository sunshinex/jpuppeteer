package jpuppeteer.cdp.client.entity.media;

/**
* This can be called multiple times, and can be used to set / override / remove player properties. A null propValue indicates removal.
* experimental
*/
public class PlayerPropertiesChangedEvent {

    /**
    */
    private String playerId;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.media.PlayerProperty> properties;

    public void setPlayerId (String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return this.playerId;
    }

    public void setProperties (java.util.List<jpuppeteer.cdp.client.entity.media.PlayerProperty> properties) {
        this.properties = properties;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.media.PlayerProperty> getProperties() {
        return this.properties;
    }

    public PlayerPropertiesChangedEvent(String playerId, java.util.List<jpuppeteer.cdp.client.entity.media.PlayerProperty> properties) {
        this.playerId = playerId;
        this.properties = properties;
    }

    public PlayerPropertiesChangedEvent() {
    }

}