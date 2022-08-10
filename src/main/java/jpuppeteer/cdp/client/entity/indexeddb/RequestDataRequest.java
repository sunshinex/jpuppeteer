package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDataRequest {

    /**
    * Security origin.
    */
    private String securityOrigin;

    /**
    * Database name.
    */
    private String databaseName;

    /**
    * Object store name.
    */
    private String objectStoreName;

    /**
    * Index name, empty string for object store data requests.
    */
    private String indexName;

    /**
    * Number of records to skip.
    */
    private Integer skipCount;

    /**
    * Number of records to fetch.
    */
    private Integer pageSize;

    /**
    * Key range.
    */
    private jpuppeteer.cdp.client.entity.indexeddb.KeyRange keyRange;

    public void setSecurityOrigin (String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

    public String getSecurityOrigin() {
        return this.securityOrigin;
    }

    public void setDatabaseName (String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setObjectStoreName (String objectStoreName) {
        this.objectStoreName = objectStoreName;
    }

    public String getObjectStoreName() {
        return this.objectStoreName;
    }

    public void setIndexName (String indexName) {
        this.indexName = indexName;
    }

    public String getIndexName() {
        return this.indexName;
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

    public void setKeyRange (jpuppeteer.cdp.client.entity.indexeddb.KeyRange keyRange) {
        this.keyRange = keyRange;
    }

    public jpuppeteer.cdp.client.entity.indexeddb.KeyRange getKeyRange() {
        return this.keyRange;
    }

    public RequestDataRequest(String securityOrigin, String databaseName, String objectStoreName, String indexName, Integer skipCount, Integer pageSize, jpuppeteer.cdp.client.entity.indexeddb.KeyRange keyRange) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
        this.objectStoreName = objectStoreName;
        this.indexName = indexName;
        this.skipCount = skipCount;
        this.pageSize = pageSize;
        this.keyRange = keyRange;
    }

    public RequestDataRequest(String securityOrigin, String databaseName, String objectStoreName, String indexName, Integer skipCount, Integer pageSize) {
        this.securityOrigin = securityOrigin;
        this.databaseName = databaseName;
        this.objectStoreName = objectStoreName;
        this.indexName = indexName;
        this.skipCount = skipCount;
        this.pageSize = pageSize;
        this.keyRange = null;
    }

    public RequestDataRequest() {
    }

}