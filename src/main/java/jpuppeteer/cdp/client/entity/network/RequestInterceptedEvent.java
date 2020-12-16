package jpuppeteer.cdp.client.entity.network;

/**
* Details of an intercepted HTTP request, which must be either allowed, blocked, modified or mocked. Deprecated, use Fetch.requestPaused instead.
*/
public class RequestInterceptedEvent {

    /**
    * Each request the page makes will have a unique id, however if any redirects are encountered while processing that fetch, they will be reported with the same id as the original fetch. Likewise if HTTP authentication is needed then the same fetch id will be used.
    */
    public final String interceptionId;

    /**
    */
    public final Request request;

    /**
    * The id of the frame that initiated the request.
    */
    public final String frameId;

    /**
    * How the requested resource will be used.
    */
    public final jpuppeteer.cdp.client.constant.network.ResourceType resourceType;

    /**
    * Whether this is a navigation request, which can abort the navigation completely.
    */
    public final Boolean isNavigationRequest;

    /**
    * Set if the request is a navigation that will result in a download. Only present after response is received from the server (i.e. HeadersReceived stage).
    */
    public final Boolean isDownload;

    /**
    * Redirect location, only sent if a redirect was intercepted.
    */
    public final String redirectUrl;

    /**
    * Details of the Authorization Challenge encountered. If this is set then continueInterceptedRequest must contain an authChallengeResponse.
    */
    public final AuthChallenge authChallenge;

    /**
    * Response error if intercepted at response stage or if redirect occurred while intercepting request.
    */
    public final jpuppeteer.cdp.client.constant.network.ErrorReason responseErrorReason;

    /**
    * Response code if intercepted at response stage or if redirect occurred while intercepting request or auth retry occurred.
    */
    public final Integer responseStatusCode;

    /**
    * Response headers if intercepted at the response stage or if redirect occurred while intercepting request or auth retry occurred.
    */
    public final java.util.Map<String, Object> responseHeaders;

    /**
    * If the intercepted request had a corresponding requestWillBeSent event fired for it, then this requestId will be the same as the requestId present in the requestWillBeSent event.
    */
    public final String requestId;

    public RequestInterceptedEvent(String interceptionId, Request request, String frameId, jpuppeteer.cdp.client.constant.network.ResourceType resourceType, Boolean isNavigationRequest, Boolean isDownload, String redirectUrl, AuthChallenge authChallenge, jpuppeteer.cdp.client.constant.network.ErrorReason responseErrorReason, Integer responseStatusCode, java.util.Map<String, Object> responseHeaders, String requestId) {
        this.interceptionId = interceptionId;
        this.request = request;
        this.frameId = frameId;
        this.resourceType = resourceType;
        this.isNavigationRequest = isNavigationRequest;
        this.isDownload = isDownload;
        this.redirectUrl = redirectUrl;
        this.authChallenge = authChallenge;
        this.responseErrorReason = responseErrorReason;
        this.responseStatusCode = responseStatusCode;
        this.responseHeaders = responseHeaders;
        this.requestId = requestId;
    }

    public RequestInterceptedEvent(String interceptionId, Request request, String frameId, jpuppeteer.cdp.client.constant.network.ResourceType resourceType, Boolean isNavigationRequest) {
        this.interceptionId = interceptionId;
        this.request = request;
        this.frameId = frameId;
        this.resourceType = resourceType;
        this.isNavigationRequest = isNavigationRequest;
        this.isDownload = null;
        this.redirectUrl = null;
        this.authChallenge = null;
        this.responseErrorReason = null;
        this.responseStatusCode = null;
        this.responseHeaders = null;
        this.requestId = null;
    }

}