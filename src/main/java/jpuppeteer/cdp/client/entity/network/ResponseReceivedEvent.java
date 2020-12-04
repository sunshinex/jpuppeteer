package jpuppeteer.cdp.client.entity.network;

/**
* Fired when HTTP response is available.
*/
public class ResponseReceivedEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Loader identifier. Empty string if the request is fetched from worker.
    */
    public final String loaderId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Resource type.
    */
    public final String type;

    /**
    * Response data.
    */
    public final jpuppeteer.cdp.client.entity.network.Response response;

    /**
    * Frame identifier.
    */
    public final String frameId;

    public ResponseReceivedEvent(String requestId, String loaderId, java.math.BigDecimal timestamp, String type, jpuppeteer.cdp.client.entity.network.Response response, String frameId) {
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.timestamp = timestamp;
        this.type = type;
        this.response = response;
        this.frameId = frameId;
    }

    public ResponseReceivedEvent(String requestId, String loaderId, java.math.BigDecimal timestamp, String type, jpuppeteer.cdp.client.entity.network.Response response) {
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.timestamp = timestamp;
        this.type = type;
        this.response = response;
        this.frameId = null;
    }

}