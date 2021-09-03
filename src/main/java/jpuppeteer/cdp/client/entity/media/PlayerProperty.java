package jpuppeteer.cdp.client.entity.media;

/**
* Corresponds to kMediaPropertyChange
* experimental
*/
public class PlayerProperty {

    /**
    */
    public final String name;

    /**
    */
    public final String value;

    public PlayerProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

}