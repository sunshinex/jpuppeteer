package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class IndexedDB {

    private jpuppeteer.cdp.CDPConnection connection;

    public IndexedDB(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Clears all entries from an object store.
    */
    public jpuppeteer.util.XFuture<?> clearObjectStore(jpuppeteer.cdp.client.entity.indexeddb.ClearObjectStoreRequest request) {
        return connection.send("IndexedDB.clearObjectStore", request);
    }


    /**
    * Deletes a database.
    */
    public jpuppeteer.util.XFuture<?> deleteDatabase(jpuppeteer.cdp.client.entity.indexeddb.DeleteDatabaseRequest request) {
        return connection.send("IndexedDB.deleteDatabase", request);
    }


    /**
    * Delete a range of entries from an object store
    */
    public jpuppeteer.util.XFuture<?> deleteObjectStoreEntries(jpuppeteer.cdp.client.entity.indexeddb.DeleteObjectStoreEntriesRequest request) {
        return connection.send("IndexedDB.deleteObjectStoreEntries", request);
    }


    /**
    * Disables events from backend.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("IndexedDB.disable", null);
    }


    /**
    * Enables events from backend.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("IndexedDB.enable", null);
    }


    /**
    * Requests data from object store or index.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.indexeddb.RequestDataResponse> requestData(jpuppeteer.cdp.client.entity.indexeddb.RequestDataRequest request) {
        return connection.send("IndexedDB.requestData", request, jpuppeteer.cdp.client.entity.indexeddb.RequestDataResponse.class);
    }


    /**
    * Gets metadata of an object store
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.indexeddb.GetMetadataResponse> getMetadata(jpuppeteer.cdp.client.entity.indexeddb.GetMetadataRequest request) {
        return connection.send("IndexedDB.getMetadata", request, jpuppeteer.cdp.client.entity.indexeddb.GetMetadataResponse.class);
    }


    /**
    * Requests database with given name in given frame.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseResponse> requestDatabase(jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseRequest request) {
        return connection.send("IndexedDB.requestDatabase", request, jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseResponse.class);
    }


    /**
    * Requests database names for given security origin.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseNamesResponse> requestDatabaseNames(jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseNamesRequest request) {
        return connection.send("IndexedDB.requestDatabaseNames", request, jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseNamesResponse.class);
    }

}