package jpuppeteer.cdp.client.entity.network;

/**
* Fired when HTTP response is available.
*/
public class ResponseReceivedEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Loader identifier. Empty string if the request is fetched from worker.
    */
    private String loaderId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Resource type.
    */
    private jpuppeteer.cdp.client.constant.network.ResourceType type;

    /**
    * Response data.
    */
    private jpuppeteer.cdp.client.entity.network.Response response;

    /**
    * Frame identifier.
    */
    private String frameId;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setLoaderId (String loaderId) {
        this.loaderId = loaderId;
    }

    public String getLoaderId() {
        return this.loaderId;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setType (jpuppeteer.cdp.client.constant.network.ResourceType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.network.ResourceType getType() {
        return this.type;
    }

    public void setResponse (jpuppeteer.cdp.client.entity.network.Response response) {
        this.response = response;
    }

    public jpuppeteer.cdp.client.entity.network.Response getResponse() {
        return this.response;
    }

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public ResponseReceivedEvent(String requestId, String loaderId, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.constant.network.ResourceType type, jpuppeteer.cdp.client.entity.network.Response response, String frameId) {
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.timestamp = timestamp;
        this.type = type;
        this.response = response;
        this.frameId = frameId;
    }

    public ResponseReceivedEvent(String requestId, String loaderId, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.constant.network.ResourceType type, jpuppeteer.cdp.client.entity.network.Response response) {
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.timestamp = timestamp;
        this.type = type;
        this.response = response;
        this.frameId = null;
    }

    public ResponseReceivedEvent() {
    }

}