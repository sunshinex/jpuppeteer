package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDatabaseResponse {

    /**
    * Database with an array of object stores.
    */
    public final DatabaseWithObjectStores databaseWithObjectStores;

    public RequestDatabaseResponse(DatabaseWithObjectStores databaseWithObjectStores) {
        this.databaseWithObjectStores = databaseWithObjectStores;
    }

}