package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class DeleteCacheRequest {

    /**
    * Id of cache for deletion.
    */
    private String cacheId;

    public void setCacheId (String cacheId) {
        this.cacheId = cacheId;
    }

    public String getCacheId() {
        return this.cacheId;
    }

    public DeleteCacheRequest(String cacheId) {
        this.cacheId = cacheId;
    }

    public DeleteCacheRequest() {
    }

}