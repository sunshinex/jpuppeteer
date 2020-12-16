package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class DeleteEntryRequest {

    /**
    * Id of cache where the entry will be deleted.
    */
    public final String cacheId;

    /**
    * URL spec of the request.
    */
    public final String request;

    public DeleteEntryRequest(String cacheId, String request) {
        this.cacheId = cacheId;
        this.request = request;
    }

}