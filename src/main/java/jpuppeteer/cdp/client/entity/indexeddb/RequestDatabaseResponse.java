package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDatabaseResponse {

    /**
    * Database with an array of object stores.
    */
    public final jpuppeteer.cdp.client.entity.indexeddb.DatabaseWithObjectStores databaseWithObjectStores;

    public RequestDatabaseResponse(jpuppeteer.cdp.client.entity.indexeddb.DatabaseWithObjectStores databaseWithObjectStores) {
        this.databaseWithObjectStores = databaseWithObjectStores;
    }

}