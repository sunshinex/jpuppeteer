package jpuppeteer.cdp.client.entity.network;

/**
* Details of an intercepted HTTP request, which must be either allowed, blocked, modified or mocked. Deprecated, use Fetch.requestPaused instead.
*/
public class RequestInterceptedEvent {

    /**
    * Each request the page makes will have a unique id, however if any redirects are encountered while processing that fetch, they will be reported with the same id as the original fetch. Likewise if HTTP authentication is needed then the same fetch id will be used.
    */
    private String interceptionId;

    /**
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
    * Whether this is a navigation request, which can abort the navigation completely.
    */
    private Boolean isNavigationRequest;

    /**
    * Set if the request is a navigation that will result in a download. Only present after response is received from the server (i.e. HeadersReceived stage).
    */
    private Boolean isDownload;

    /**
    * Redirect location, only sent if a redirect was intercepted.
    */
    private String redirectUrl;

    /**
    * Details of the Authorization Challenge encountered. If this is set then continueInterceptedRequest must contain an authChallengeResponse.
    */
    private jpuppeteer.cdp.client.entity.network.AuthChallenge authChallenge;

    /**
    * Response error if intercepted at response stage or if redirect occurred while intercepting request.
    */
    private jpuppeteer.cdp.client.constant.network.ErrorReason responseErrorReason;

    /**
    * Response code if intercepted at response stage or if redirect occurred while intercepting request or auth retry occurred.
    */
    private Integer responseStatusCode;

    /**
    * Response headers if intercepted at the response stage or if redirect occurred while intercepting request or auth retry occurred.
    */
    private java.util.Map<String, Object> responseHeaders;

    /**
    * If the intercepted request had a corresponding requestWillBeSent event fired for it, then this requestId will be the same as the requestId present in the requestWillBeSent event.
    */
    private String requestId;

    public void setInterceptionId (String interceptionId) {
        this.interceptionId = interceptionId;
    }

    public String getInterceptionId() {
        return this.interceptionId;
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

    public void setIsNavigationRequest (Boolean isNavigationRequest) {
        this.isNavigationRequest = isNavigationRequest;
    }

    public Boolean getIsNavigationRequest() {
        return this.isNavigationRequest;
    }

    public void setIsDownload (Boolean isDownload) {
        this.isDownload = isDownload;
    }

    public Boolean getIsDownload() {
        return this.isDownload;
    }

    public void setRedirectUrl (String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setAuthChallenge (jpuppeteer.cdp.client.entity.network.AuthChallenge authChallenge) {
        this.authChallenge = authChallenge;
    }

    public jpuppeteer.cdp.client.entity.network.AuthChallenge getAuthChallenge() {
        return this.authChallenge;
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

    public void setResponseHeaders (java.util.Map<String, Object> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public java.util.Map<String, Object> getResponseHeaders() {
        return this.responseHeaders;
    }

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RequestInterceptedEvent(String interceptionId, jpuppeteer.cdp.client.entity.network.Request request, String frameId, jpuppeteer.cdp.client.constant.network.ResourceType resourceType, Boolean isNavigationRequest, Boolean isDownload, String redirectUrl, jpuppeteer.cdp.client.entity.network.AuthChallenge authChallenge, jpuppeteer.cdp.client.constant.network.ErrorReason responseErrorReason, Integer responseStatusCode, java.util.Map<String, Object> responseHeaders, String requestId) {
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

    public RequestInterceptedEvent(String interceptionId, jpuppeteer.cdp.client.entity.network.Request request, String frameId, jpuppeteer.cdp.client.constant.network.ResourceType resourceType, Boolean isNavigationRequest) {
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

    public RequestInterceptedEvent() {
    }

}