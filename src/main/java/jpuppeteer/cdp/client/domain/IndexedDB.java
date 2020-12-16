package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class IndexedDB {

    private jpuppeteer.cdp.CDPSession session;

    public IndexedDB(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Clears all entries from an object store.
    */
    public io.netty.util.concurrent.Future clearObjectStore(jpuppeteer.cdp.client.entity.indexeddb.ClearObjectStoreRequest request) {
        return session.send("IndexedDB.clearObjectStore", request);
    }


    /**
    * Deletes a database.
    */
    public io.netty.util.concurrent.Future deleteDatabase(jpuppeteer.cdp.client.entity.indexeddb.DeleteDatabaseRequest request) {
        return session.send("IndexedDB.deleteDatabase", request);
    }


    /**
    * Delete a range of entries from an object store
    */
    public io.netty.util.concurrent.Future deleteObjectStoreEntries(jpuppeteer.cdp.client.entity.indexeddb.DeleteObjectStoreEntriesRequest request) {
        return session.send("IndexedDB.deleteObjectStoreEntries", request);
    }


    /**
    * Disables events from backend.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("IndexedDB.disable", null);
    }


    /**
    * Enables events from backend.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("IndexedDB.enable", null);
    }


    /**
    * Requests data from object store or index.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.indexeddb.RequestDataResponse> requestData(jpuppeteer.cdp.client.entity.indexeddb.RequestDataRequest request) {
        return session.send("IndexedDB.requestData", request, jpuppeteer.cdp.client.entity.indexeddb.RequestDataResponse.class);
    }


    /**
    * Gets metadata of an object store
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.indexeddb.GetMetadataResponse> getMetadata(jpuppeteer.cdp.client.entity.indexeddb.GetMetadataRequest request) {
        return session.send("IndexedDB.getMetadata", request, jpuppeteer.cdp.client.entity.indexeddb.GetMetadataResponse.class);
    }


    /**
    * Requests database with given name in given frame.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseResponse> requestDatabase(jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseRequest request) {
        return session.send("IndexedDB.requestDatabase", request, jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseResponse.class);
    }


    /**
    * Requests database names for given security origin.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseNamesResponse> requestDatabaseNames(jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseNamesRequest request) {
        return session.send("IndexedDB.requestDatabaseNames", request, jpuppeteer.cdp.client.entity.indexeddb.RequestDatabaseNamesResponse.class);
    }

}