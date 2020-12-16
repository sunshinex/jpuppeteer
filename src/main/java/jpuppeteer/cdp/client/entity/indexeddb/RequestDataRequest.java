package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class RequestDataRequest {

    /**
    * Security origin.
    */
    public final String securityOrigin;

    /**
    * Database name.
    */
    public final String databaseName;

    /**
    * Object store name.
    */
    public final String objectStoreName;

    /**
    * Index name, empty string for object store data requests.
    */
    public final String indexName;

    /**
    * Number of records to skip.
    */
    public final Integer skipCount;

    /**
    * Number of records to fetch.
    */
    public final Integer pageSize;

    /**
    * Key range.
    */
    public final KeyRange keyRange;

    public RequestDataRequest(String securityOrigin, String databaseName, String objectStoreName, String indexName, Integer skipCount, Integer pageSize, KeyRange keyRange) {
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

}