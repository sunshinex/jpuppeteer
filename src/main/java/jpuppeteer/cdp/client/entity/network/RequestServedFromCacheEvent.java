package jpuppeteer.cdp.client.entity.network;

/**
* Fired if request ended up loading from cache.
*/
public class RequestServedFromCacheEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    public RequestServedFromCacheEvent(String requestId) {
        this.requestId = requestId;
    }

}