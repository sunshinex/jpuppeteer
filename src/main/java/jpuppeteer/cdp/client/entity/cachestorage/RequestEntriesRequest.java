package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestEntriesRequest {

    /**
    * ID of cache to get entries from.
    */
    private String cacheId;

    /**
    * Number of records to skip.
    */
    private Integer skipCount;

    /**
    * Number of records to fetch.
    */
    private Integer pageSize;

    /**
    * If present, only return the entries containing this substring in the path
    */
    private String pathFilter;

    public void setCacheId (String cacheId) {
        this.cacheId = cacheId;
    }

    public String getCacheId() {
        return this.cacheId;
    }

    public void setSkipCount (Integer skipCount) {
        this.skipCount = skipCount;
    }

    public Integer getSkipCount() {
        return this.skipCount;
    }

    public void setPageSize (Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPathFilter (String pathFilter) {
        this.pathFilter = pathFilter;
    }

    public String getPathFilter() {
        return this.pathFilter;
    }

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

    public RequestEntriesRequest() {
    }

}