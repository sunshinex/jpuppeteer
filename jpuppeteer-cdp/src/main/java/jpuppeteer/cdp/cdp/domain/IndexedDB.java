package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void clearObjectStore(jpuppeteer.cdp.cdp.entity.indexeddb.ClearObjectStoreRequest request, int timeout) throws Exception {
        session.send("IndexedDB.clearObjectStore", request, timeout);
    }


    /**
    * Deletes a database.
    * experimental
    */
    public void deleteDatabase(jpuppeteer.cdp.cdp.entity.indexeddb.DeleteDatabaseRequest request, int timeout) throws Exception {
        session.send("IndexedDB.deleteDatabase", request, timeout);
    }


    /**
    * Delete a range of entries from an object store
    * experimental
    */
    public void deleteObjectStoreEntries(jpuppeteer.cdp.cdp.entity.indexeddb.DeleteObjectStoreEntriesRequest request, int timeout) throws Exception {
        session.send("IndexedDB.deleteObjectStoreEntries", request, timeout);
    }


    /**
    * Disables events from backend.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("IndexedDB.disable", null, timeout);
    }


    /**
    * Enables events from backend.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("IndexedDB.enable", null, timeout);
    }


    /**
    * Requests data from object store or index.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.indexeddb.RequestDataResponse requestData(jpuppeteer.cdp.cdp.entity.indexeddb.RequestDataRequest request, int timeout) throws Exception {
        return session.send("IndexedDB.requestData", request, jpuppeteer.cdp.cdp.entity.indexeddb.RequestDataResponse.class, timeout);
    }


    /**
    * Gets metadata of an object store
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.indexeddb.GetMetadataResponse getMetadata(jpuppeteer.cdp.cdp.entity.indexeddb.GetMetadataRequest request, int timeout) throws Exception {
        return session.send("IndexedDB.getMetadata", request, jpuppeteer.cdp.cdp.entity.indexeddb.GetMetadataResponse.class, timeout);
    }


    /**
    * Requests database with given name in given frame.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.indexeddb.RequestDatabaseResponse requestDatabase(jpuppeteer.cdp.cdp.entity.indexeddb.RequestDatabaseRequest request, int timeout) throws Exception {
        return session.send("IndexedDB.requestDatabase", request, jpuppeteer.cdp.cdp.entity.indexeddb.RequestDatabaseResponse.class, timeout);
    }


    /**
    * Requests database names for given security origin.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.indexeddb.RequestDatabaseNamesResponse requestDatabaseNames(jpuppeteer.cdp.cdp.entity.indexeddb.RequestDatabaseNamesRequest request, int timeout) throws Exception {
        return session.send("IndexedDB.requestDatabaseNames", request, jpuppeteer.cdp.cdp.entity.indexeddb.RequestDatabaseNamesResponse.class, timeout);
    }

}