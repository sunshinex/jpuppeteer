package jpuppeteer.cdp.client.entity.fetch;

/**
* Issued when the domain is enabled and the request URL matches the specified filter. The request is paused until the client responds with one of continueRequest, failRequest or fulfillRequest. The stage of the request can be determined by presence of responseErrorReason and responseStatusCode -- the request is at the response stage if either of these fields is present and in the request stage otherwise.
*/
public class RequestPausedEvent {

    /**
    * Each request the page makes will have a unique id.
    */
    private String requestId;

    /**
    * The details of the request.
    */
    private jpuppeteer.cdp.client.entity.network.Request request;

    /**
    * The id of the frame that initiated the request.
    */
    private String frameId;

    /**
    * How the requested resource will be used.
    */
    private jpuppeteer.cdp.client.constant.network.ResourceType resourceType;

    /**
    * Response error if intercepted at response stage.
    */
    private jpuppeteer.cdp.client.constant.network.ErrorReason responseErrorReason;

    /**
    * Response code if intercepted at response stage.
    */
    private Integer responseStatusCode;

    /**
    * Response headers if intercepted at the response stage.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> responseHeaders;

    /**
    * If the intercepted request had a corresponding Network.requestWillBeSent event fired for it, then this networkId will be the same as the requestId present in the requestWillBeSent event.
    */
    private String networkId;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequest (jpuppeteer.cdp.client.entity.network.Request request) {
        this.request = request;
    }

    public jpuppeteer.cdp.client.entity.network.Request getRequest() {
        return this.request;
    }

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setResourceType (jpuppeteer.cdp.client.constant.network.ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public jpuppeteer.cdp.client.constant.network.ResourceType getResourceType() {
        return this.resourceType;
    }

    public void setResponseErrorReason (jpuppeteer.cdp.client.constant.network.ErrorReason responseErrorReason) {
        this.responseErrorReason = responseErrorReason;
    }

    public jpuppeteer.cdp.client.constant.network.ErrorReason getResponseErrorReason() {
        return this.responseErrorReason;
    }

    public void setResponseStatusCode (Integer responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

    public Integer getResponseStatusCode() {
        return this.responseStatusCode;
    }

    public void setResponseHeaders (java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> getResponseHeaders() {
        return this.responseHeaders;
    }

    public void setNetworkId (String networkId) {
        this.networkId = networkId;
    }

    public String getNetworkId() {
        return this.networkId;
    }

    public RequestPausedEvent(String requestId, jpuppeteer.cdp.client.entity.network.Request request, String frameId, jpuppeteer.cdp.client.constant.network.ResourceType resourceType, jpuppeteer.cdp.client.constant.network.ErrorReason responseErrorReason, Integer responseStatusCode, java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> responseHeaders, String networkId) {
        this.requestId = requestId;
        this.request = request;
        this.frameId = frameId;
        this.resourceType = resourceType;
        this.responseErrorReason = responseErrorReason;
        this.responseStatusCode = responseStatusCode;
        this.responseHeaders = responseHeaders;
        this.networkId = networkId;
    }

    public RequestPausedEvent(String requestId, jpuppeteer.cdp.client.entity.network.Request request, String frameId, jpuppeteer.cdp.client.constant.network.ResourceType resourceType) {
        this.requestId = requestId;
        this.request = request;
        this.frameId = frameId;
        this.resourceType = resourceType;
        this.responseErrorReason = null;
        this.responseStatusCode = null;
        this.responseHeaders = null;
        this.networkId = null;
    }

    public RequestPausedEvent() {
    }

}