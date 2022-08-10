package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDataResponse {

    /**
    * Array of object store data entries.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.indexeddb.DataEntry> objectStoreDataEntries;

    /**
    * If true, there are more entries to fetch in the given range.
    */
    private Boolean hasMore;

    public void setObjectStoreDataEntries (java.util.List<jpuppeteer.cdp.client.entity.indexeddb.DataEntry> objectStoreDataEntries) {
        this.objectStoreDataEntries = objectStoreDataEntries;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.indexeddb.DataEntry> getObjectStoreDataEntries() {
        return this.objectStoreDataEntries;
    }

    public void setHasMore (Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Boolean getHasMore() {
        return this.hasMore;
    }

    public RequestDataResponse(java.util.List<jpuppeteer.cdp.client.entity.indexeddb.DataEntry> objectStoreDataEntries, Boolean hasMore) {
        this.objectStoreDataEntries = objectStoreDataEntries;
        this.hasMore = hasMore;
    }

    public RequestDataResponse() {
    }

}