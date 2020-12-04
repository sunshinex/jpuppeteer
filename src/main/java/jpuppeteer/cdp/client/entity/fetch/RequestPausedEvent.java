package jpuppeteer.cdp.client.entity.fetch;

/**
* Issued when the domain is enabled and the request URL matches the specified filter. The request is paused until the client responds with one of continueRequest, failRequest or fulfillRequest. The stage of the request can be determined by presence of responseErrorReason and responseStatusCode -- the request is at the response stage if either of these fields is present and in the request stage otherwise.
* experimental
*/
public class RequestPausedEvent {

    /**
    * Each request the page makes will have a unique id.
    */
    public final String requestId;

    /**
    * The details of the request.
    */
    public final jpuppeteer.cdp.client.entity.network.Request request;

    /**
    * The id of the frame that initiated the request.
    */
    public final String frameId;

    /**
    * How the requested resource will be used.
    */
    public final String resourceType;

    /**
    * Response error if intercepted at response stage.
    */
    public final String responseErrorReason;

    /**
    * Response code if intercepted at response stage.
    */
    public final Integer responseStatusCode;

    /**
    * Response headers if intercepted at the response stage.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> responseHeaders;

    /**
    * If the intercepted request had a corresponding Network.requestWillBeSent event fired for it, then this networkId will be the same as the requestId present in the requestWillBeSent event.
    */
    public final String networkId;

    public RequestPausedEvent(String requestId, jpuppeteer.cdp.client.entity.network.Request request, String frameId, String resourceType, String responseErrorReason, Integer responseStatusCode, java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> responseHeaders, String networkId) {
        this.requestId = requestId;
        this.request = request;
        this.frameId = frameId;
        this.resourceType = resourceType;
        this.responseErrorReason = responseErrorReason;
        this.responseStatusCode = responseStatusCode;
        this.responseHeaders = responseHeaders;
        this.networkId = networkId;
    }

    public RequestPausedEvent(String requestId, jpuppeteer.cdp.client.entity.network.Request request, String frameId, String resourceType) {
        this.requestId = requestId;
        this.request = request;
        this.frameId = frameId;
        this.resourceType = resourceType;
        this.responseErrorReason = null;
        this.responseStatusCode = null;
        this.responseHeaders = null;
        this.networkId = null;
    }

}