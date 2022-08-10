package jpuppeteer.cdp.client.entity.network;

/**
* Fired when page is about to send HTTP request.
*/
public class RequestWillBeSentEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Loader identifier. Empty string if the request is fetched from worker.
    */
    private String loaderId;

    /**
    * URL of the document this request is loaded for.
    */
    private String documentURL;

    /**
    * Request data.
    */
    private jpuppeteer.cdp.client.entity.network.Request request;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal wallTime;

    /**
    * Request initiator.
    */
    private jpuppeteer.cdp.client.entity.network.Initiator initiator;

    /**
    * Redirect response data.
    */
    private jpuppeteer.cdp.client.entity.network.Response redirectResponse;

    /**
    * Type of this resource.
    */
    private jpuppeteer.cdp.client.constant.network.ResourceType type;

    /**
    * Frame identifier.
    */
    private String frameId;

    /**
    * Whether the request is initiated by a user gesture. Defaults to false.
    */
    private Boolean hasUserGesture;

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

    public void setDocumentURL (String documentURL) {
        this.documentURL = documentURL;
    }

    public String getDocumentURL() {
        return this.documentURL;
    }

    public void setRequest (jpuppeteer.cdp.client.entity.network.Request request) {
        this.request = request;
    }

    public jpuppeteer.cdp.client.entity.network.Request getRequest() {
        return this.request;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setWallTime (java.math.BigDecimal wallTime) {
        this.wallTime = wallTime;
    }

    public java.math.BigDecimal getWallTime() {
        return this.wallTime;
    }

    public void setInitiator (jpuppeteer.cdp.client.entity.network.Initiator initiator) {
        this.initiator = initiator;
    }

    public jpuppeteer.cdp.client.entity.network.Initiator getInitiator() {
        return this.initiator;
    }

    public void setRedirectResponse (jpuppeteer.cdp.client.entity.network.Response redirectResponse) {
        this.redirectResponse = redirectResponse;
    }

    public jpuppeteer.cdp.client.entity.network.Response getRedirectResponse() {
        return this.redirectResponse;
    }

    public void setType (jpuppeteer.cdp.client.constant.network.ResourceType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.network.ResourceType getType() {
        return this.type;
    }

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setHasUserGesture (Boolean hasUserGesture) {
        this.hasUserGesture = hasUserGesture;
    }

    public Boolean getHasUserGesture() {
        return this.hasUserGesture;
    }

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

    public RequestWillBeSentEvent() {
    }

}