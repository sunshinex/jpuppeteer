package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Object store index.
* experimental
*/
public class ObjectStoreIndex {

    /**
    * Index name.
    */
    private String name;

    /**
    * Index key path.
    */
    private jpuppeteer.cdp.client.entity.indexeddb.KeyPath keyPath;

    /**
    * If true, index is unique.
    */
    private Boolean unique;

    /**
    * If true, index allows multiple entries for a key.
    */
    private Boolean multiEntry;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setKeyPath (jpuppeteer.cdp.client.entity.indexeddb.KeyPath keyPath) {
        this.keyPath = keyPath;
    }

    public jpuppeteer.cdp.client.entity.indexeddb.KeyPath getKeyPath() {
        return this.keyPath;
    }

    public void setUnique (Boolean unique) {
        this.unique = unique;
    }

    public Boolean getUnique() {
        return this.unique;
    }

    public void setMultiEntry (Boolean multiEntry) {
        this.multiEntry = multiEntry;
    }

    public Boolean getMultiEntry() {
        return this.multiEntry;
    }

    public ObjectStoreIndex(String name, jpuppeteer.cdp.client.entity.indexeddb.KeyPath keyPath, Boolean unique, Boolean multiEntry) {
        this.name = name;
        this.keyPath = keyPath;
        this.unique = unique;
        this.multiEntry = multiEntry;
    }

    public ObjectStoreIndex() {
    }

}