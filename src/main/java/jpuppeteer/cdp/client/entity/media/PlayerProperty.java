package jpuppeteer.cdp.client.entity.media;

/**
* Player Property type
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

    public PlayerProperty(String name) {
        this.name = name;
        this.value = null;
    }

}