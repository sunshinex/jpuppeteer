package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* A key-value pair for additional event information to pass along.
* experimental
*/
public class EventMetadata {

    /**
    */
    public final String key;

    /**
    */
    public final String value;

    public EventMetadata(String key, String value) {
        this.key = key;
        this.value = value;
    }

}