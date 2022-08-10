package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Object store.
* experimental
*/
public class ObjectStore {

    /**
    * Object store name.
    */
    private String name;

    /**
    * Object store key path.
    */
    private jpuppeteer.cdp.client.entity.indexeddb.KeyPath keyPath;

    /**
    * If true, object store has auto increment flag set.
    */
    private Boolean autoIncrement;

    /**
    * Indexes in this object store.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStoreIndex> indexes;

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

    public void setAutoIncrement (Boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public Boolean getAutoIncrement() {
        return this.autoIncrement;
    }

    public void setIndexes (java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStoreIndex> indexes) {
        this.indexes = indexes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStoreIndex> getIndexes() {
        return this.indexes;
    }

    public ObjectStore(String name, jpuppeteer.cdp.client.entity.indexeddb.KeyPath keyPath, Boolean autoIncrement, java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStoreIndex> indexes) {
        this.name = name;
        this.keyPath = keyPath;
        this.autoIncrement = autoIncrement;
        this.indexes = indexes;
    }

    public ObjectStore() {
    }

}