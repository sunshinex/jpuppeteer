package jpuppeteer.cdp.client.entity.fetch;

/**
* Issued when the domain is enabled with handleAuthRequests set to true. The request is paused until client responds with continueWithAuth.
*/
public class AuthRequiredEvent {

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
    * Details of the Authorization Challenge encountered. If this is set, client should respond with continueRequest that contains AuthChallengeResponse.
    */
    private jpuppeteer.cdp.client.entity.fetch.AuthChallenge authChallenge;

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

    public void setAuthChallenge (jpuppeteer.cdp.client.entity.fetch.AuthChallenge authChallenge) {
        this.authChallenge = authChallenge;
    }

    public jpuppeteer.cdp.client.entity.fetch.AuthChallenge getAuthChallenge() {
        return this.authChallenge;
    }

    public AuthRequiredEvent(String requestId, jpuppeteer.cdp.client.entity.network.Request request, String frameId, jpuppeteer.cdp.client.constant.network.ResourceType resourceType, jpuppeteer.cdp.client.entity.fetch.AuthChallenge authChallenge) {
        this.requestId = requestId;
        this.request = request;
        this.frameId = frameId;
        this.resourceType = resourceType;
        this.authChallenge = authChallenge;
    }

    public AuthRequiredEvent() {
    }

}