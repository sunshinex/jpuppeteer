package jpuppeteer.cdp.client.entity.network;

/**
* Fired if request ended up loading from cache.
*/
public class RequestServedFromCacheEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RequestServedFromCacheEvent(String requestId) {
        this.requestId = requestId;
    }

    public RequestServedFromCacheEvent() {
    }

}