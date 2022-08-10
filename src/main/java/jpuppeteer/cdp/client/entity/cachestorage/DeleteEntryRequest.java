package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class DeleteEntryRequest {

    /**
    * Id of cache where the entry will be deleted.
    */
    private String cacheId;

    /**
    * URL spec of the request.
    */
    private String request;

    public void setCacheId (String cacheId) {
        this.cacheId = cacheId;
    }

    public String getCacheId() {
        return this.cacheId;
    }

    public void setRequest (String request) {
        this.request = request;
    }

    public String getRequest() {
        return this.request;
    }

    public DeleteEntryRequest(String cacheId, String request) {
        this.cacheId = cacheId;
        this.request = request;
    }

    public DeleteEntryRequest() {
    }

}