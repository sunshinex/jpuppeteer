package jpuppeteer.cdp.client.entity.network;

/**
* Fired when page is about to send HTTP request.
*/
public class RequestWillBeSentEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Loader identifier. Empty string if the request is fetched from worker.
    */
    public final String loaderId;

    /**
    * URL of the document this request is loaded for.
    */
    public final String documentURL;

    /**
    * Request data.
    */
    public final jpuppeteer.cdp.client.entity.network.Request request;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal wallTime;

    /**
    * Request initiator.
    */
    public final jpuppeteer.cdp.client.entity.network.Initiator initiator;

    /**
    * Redirect response data.
    */
    public final jpuppeteer.cdp.client.entity.network.Response redirectResponse;

    /**
    * Type of this resource.
    */
    public final jpuppeteer.cdp.client.constant.network.ResourceType type;

    /**
    * Frame identifier.
    */
    public final String frameId;

    /**
    * Whether the request is initiated by a user gesture. Defaults to false.
    */
    public final Boolean hasUserGesture;

    public RequestWillBeSentEvent(String requestId, String loaderId, String documentURL, jpuppeteer.cdp.client.entity.network.Request request, java.math.BigDecimal timestamp, java.math.BigDecimal wallTime, jpuppeteer.cdp.client.entity.network.Initiator initiator, jpuppeteer.cdp.client.entity.network.Response redirectResponse, jpuppeteer.cdp.client.constant.network.ResourceType type, String frameId, Boolean hasUserGesture) {
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.documentURL = documentURL;
        this.request = request;
        this.timestamp = timestamp;
        this.wallTime = wallTime;
        this.initiator = initiator;
        this.redirectResponse = redirectResponse;
        this.type = type;
        this.frameId = frameId;
        this.hasUserGesture = hasUserGesture;
    }

    public RequestWillBeSentEvent(String requestId, String loaderId, String documentURL, jpuppeteer.cdp.client.entity.network.Request request, java.math.BigDecimal timestamp, java.math.BigDecimal wallTime, jpuppeteer.cdp.client.entity.network.Initiator initiator) {
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.documentURL = documentURL;
        this.request = request;
        this.timestamp = timestamp;
        this.wallTime = wallTime;
        this.initiator = initiator;
        this.redirectResponse = null;
        this.type = null;
        this.frameId = null;
        this.hasUserGesture = null;
    }

}