package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestEntriesResponse {

    /**
    * Array of object store data entries.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.cachestorage.DataEntry> cacheDataEntries;

    /**
    * Count of returned entries from this storage. If pathFilter is empty, it is the count of all entries from this storage.
    */
    private java.math.BigDecimal returnCount;

    public void setCacheDataEntries (java.util.List<jpuppeteer.cdp.client.entity.cachestorage.DataEntry> cacheDataEntries) {
        this.cacheDataEntries = cacheDataEntries;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.cachestorage.DataEntry> getCacheDataEntries() {
        return this.cacheDataEntries;
    }

    public void setReturnCount (java.math.BigDecimal returnCount) {
        this.returnCount = returnCount;
    }

    public java.math.BigDecimal getReturnCount() {
        return this.returnCount;
    }

    public RequestEntriesResponse(java.util.List<jpuppeteer.cdp.client.entity.cachestorage.DataEntry> cacheDataEntries, java.math.BigDecimal returnCount) {
        this.cacheDataEntries = cacheDataEntries;
        this.returnCount = returnCount;
    }

    public RequestEntriesResponse() {
    }

}