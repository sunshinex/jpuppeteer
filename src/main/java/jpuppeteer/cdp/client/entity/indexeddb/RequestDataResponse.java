package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDataResponse {

    /**
    * Array of object store data entries.
    */
    public final java.util.List<DataEntry> objectStoreDataEntries;

    /**
    * If true, there are more entries to fetch in the given range.
    */
    public final Boolean hasMore;

    public RequestDataResponse(java.util.List<DataEntry> objectStoreDataEntries, Boolean hasMore) {
        this.objectStoreDataEntries = objectStoreDataEntries;
        this.hasMore = hasMore;
    }

}