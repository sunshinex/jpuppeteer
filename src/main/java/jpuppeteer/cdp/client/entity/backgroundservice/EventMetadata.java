package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* A key-value pair for additional event information to pass along.
* experimental
*/
public class EventMetadata {

    /**
    */
    private String key;

    /**
    */
    private String value;

    public void setKey (String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public EventMetadata(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public EventMetadata() {
    }

}