package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Object store.
* experimental
*/
public class ObjectStore {

    /**
    * Object store name.
    */
    public final String name;

    /**
    * Object store key path.
    */
    public final jpuppeteer.cdp.client.entity.indexeddb.KeyPath keyPath;

    /**
    * If true, object store has auto increment flag set.
    */
    public final Boolean autoIncrement;

    /**
    * Indexes in this object store.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStoreIndex> indexes;

    public ObjectStore(String name, jpuppeteer.cdp.client.entity.indexeddb.KeyPath keyPath, Boolean autoIncrement, java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStoreIndex> indexes) {
        this.name = name;
        this.keyPath = keyPath;
        this.autoIncrement = autoIncrement;
        this.indexes = indexes;
    }

}