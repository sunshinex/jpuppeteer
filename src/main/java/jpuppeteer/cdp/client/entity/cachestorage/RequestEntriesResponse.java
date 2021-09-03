package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestEntriesResponse {

    /**
    * Array of object store data entries.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.cachestorage.DataEntry> cacheDataEntries;

    /**
    * Count of returned entries from this storage. If pathFilter is empty, it is the count of all entries from this storage.
    */
    public final java.math.BigDecimal returnCount;

    public RequestEntriesResponse(java.util.List<jpuppeteer.cdp.client.entity.cachestorage.DataEntry> cacheDataEntries, java.math.BigDecimal returnCount) {
        this.cacheDataEntries = cacheDataEntries;
        this.returnCount = returnCount;
    }

}