package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDatabaseResponse {

    /**
    * Database with an array of object stores.
    */
    private jpuppeteer.cdp.client.entity.indexeddb.DatabaseWithObjectStores databaseWithObjectStores;

    public void setDatabaseWithObjectStores (jpuppeteer.cdp.client.entity.indexeddb.DatabaseWithObjectStores databaseWithObjectStores) {
        this.databaseWithObjectStores = databaseWithObjectStores;
    }

    public jpuppeteer.cdp.client.entity.indexeddb.DatabaseWithObjectStores getDatabaseWithObjectStores() {
        return this.databaseWithObjectStores;
    }

    public RequestDatabaseResponse(jpuppeteer.cdp.client.entity.indexeddb.DatabaseWithObjectStores databaseWithObjectStores) {
        this.databaseWithObjectStores = databaseWithObjectStores;
    }

    public RequestDatabaseResponse() {
    }

}