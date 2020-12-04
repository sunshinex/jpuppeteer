package jpuppeteer.cdp.client.entity.fetch;

/**
* Issued when the domain is enabled with handleAuthRequests set to true. The request is paused until client responds with continueWithAuth.
* experimental
*/
public class AuthRequiredEvent {

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
    * Details of the Authorization Challenge encountered. If this is set, client should respond with continueRequest that contains AuthChallengeResponse.
    */
    public final jpuppeteer.cdp.client.entity.fetch.AuthChallenge authChallenge;

    public AuthRequiredEvent(String requestId, jpuppeteer.cdp.client.entity.network.Request request, String frameId, String resourceType, jpuppeteer.cdp.client.entity.fetch.AuthChallenge authChallenge) {
        this.requestId = requestId;
        this.request = request;
        this.frameId = frameId;
        this.resourceType = resourceType;
        this.authChallenge = authChallenge;
    }

}