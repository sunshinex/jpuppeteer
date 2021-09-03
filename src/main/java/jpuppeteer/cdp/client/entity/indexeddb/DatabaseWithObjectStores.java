package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Database with an array of object stores.
* experimental
*/
public class DatabaseWithObjectStores {

    /**
    * Database name.
    */
    public final String name;

    /**
    * Database version (type is not 'integer', as the standard requires the version number to be 'unsigned long long')
    */
    public final java.math.BigDecimal version;

    /**
    * Object stores in this database.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStore> objectStores;

    public DatabaseWithObjectStores(String name, java.math.BigDecimal version, java.util.List<jpuppeteer.cdp.client.entity.indexeddb.ObjectStore> objectStores) {
        this.name = name;
        this.version = version;
        this.objectStores = objectStores;
    }

}