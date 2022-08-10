package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Database with an array of object stores.
* experimental
*/
public class DatabaseWithObjectStores {

    /**
    * Database name.
    */
    private String name;

    /**
    * Database version (type is not 'integer', as the standard requires the version number to be 'unsigned long long')
    */
    private java.math.BigDecimal version;

    /**
    * Object stores in this database.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStore> objectStores;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setVersion (java.math.BigDecimal version) {
        this.version = version;
    }

    public java.math.BigDecimal getVersion() {
        return this.version;
    }

    public void setObjectStores (java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStore> objectStores) {
        this.objectStores = objectStores;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStore> getObjectStores() {
        return this.objectStores;
    }

    public DatabaseWithObjectStores(String name, java.math.BigDecimal version, java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStore> objectStores) {
        this.name = name;
        this.version = version;
        this.objectStores = objectStores;
    }

    public DatabaseWithObjectStores() {
    }

}