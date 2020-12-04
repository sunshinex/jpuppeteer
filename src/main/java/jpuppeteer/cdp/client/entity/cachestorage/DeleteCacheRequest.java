package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class DeleteCacheRequest {

    /**
    * Id of cache for deletion.
    */
    public final String cacheId;

    public DeleteCacheRequest(String cacheId) {
        this.cacheId = cacheId;
    }

}