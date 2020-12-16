package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestEntriesRequest {

    /**
    * ID of cache to get entries from.
    */
    public final String cacheId;

    /**
    * Number of records to skip.
    */
    public final Integer skipCount;

    /**
    * Number of records to fetch.
    */
    public final Integer pageSize;

    /**
    * If present, only return the entries containing this substring in the path
    */
    public final String pathFilter;

    public RequestEntriesRequest(String cacheId, Integer skipCount, Integer pageSize, String pathFilter) {
        this.cacheId = cacheId;
        this.skipCount = skipCount;
        this.pageSize = pageSize;
        this.pathFilter = pathFilter;
    }

    public RequestEntriesRequest(String cacheId) {
        this.cacheId = cacheId;
        this.skipCount = null;
        this.pageSize = null;
        this.pathFilter = null;
    }

}