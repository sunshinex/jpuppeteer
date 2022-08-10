package jpuppeteer.cdp.client.entity.media;

/**
* Corresponds to kMediaPropertyChange
* experimental
*/
public class PlayerProperty {

    /**
    */
    private String name;

    /**
    */
    private String value;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public PlayerProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public PlayerProperty() {
    }

}