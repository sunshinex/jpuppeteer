package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Data entry.
* experimental
*/
public class DataEntry {

    /**
    * Key object.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject key;

    /**
    * Primary key object.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject primaryKey;

    /**
    * Value object.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject value;

    public void setKey (jpuppeteer.cdp.client.entity.runtime.RemoteObject key) {
        this.key = key;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getKey() {
        return this.key;
    }

    public void setPrimaryKey (jpuppeteer.cdp.client.entity.runtime.RemoteObject primaryKey) {
        this.primaryKey = primaryKey;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getPrimaryKey() {
        return this.primaryKey;
    }

    public void setValue (jpuppeteer.cdp.client.entity.runtime.RemoteObject value) {
        this.value = value;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getValue() {
        return this.value;
    }

    public DataEntry(jpuppeteer.cdp.client.entity.runtime.RemoteObject key, jpuppeteer.cdp.client.entity.runtime.RemoteObject primaryKey, jpuppeteer.cdp.client.entity.runtime.RemoteObject value) {
        this.key = key;
        this.primaryKey = primaryKey;
        this.value = value;
    }

    public DataEntry() {
    }

}