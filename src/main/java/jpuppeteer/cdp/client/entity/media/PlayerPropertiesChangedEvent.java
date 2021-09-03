package jpuppeteer.cdp.client.entity.media;

/**
* This can be called multiple times, and can be used to set / override / remove player properties. A null propValue indicates removal.
* experimental
*/
public class PlayerPropertiesChangedEvent {

    /**
    */
    public final String playerId;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.media.PlayerProperty> properties;

    public PlayerPropertiesChangedEvent(String playerId, java.util.List<jpuppeteer.cdp.client.entity.media.PlayerProperty> properties) {
        this.playerId = playerId;
        this.properties = properties;
    }

}