package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Data entry.
* experimental
*/
public class DataEntry {

    /**
    * Key object.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject key;

    /**
    * Primary key object.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject primaryKey;

    /**
    * Value object.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject value;

    public DataEntry(jpuppeteer.cdp.client.entity.runtime.RemoteObject key, jpuppeteer.cdp.client.entity.runtime.RemoteObject primaryKey, jpuppeteer.cdp.client.entity.runtime.RemoteObject value) {
        this.key = key;
        this.primaryKey = primaryKey;
        this.value = value;
    }

}