package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Object store index.
* experimental
*/
public class ObjectStoreIndex {

    /**
    * Index name.
    */
    public final String name;

    /**
    * Index key path.
    */
    public final jpuppeteer.cdp.client.entity.indexeddb.KeyPath keyPath;

    /**
    * If true, index is unique.
    */
    public final Boolean unique;

    /**
    * If true, index allows multiple entries for a key.
    */
    public final Boolean multiEntry;

    public ObjectStoreIndex(String name, jpuppeteer.cdp.client.entity.indexeddb.KeyPath keyPath, Boolean unique, Boolean multiEntry) {
        this.name = name;
        this.keyPath = keyPath;
        this.unique = unique;
        this.multiEntry = multiEntry;
    }

}