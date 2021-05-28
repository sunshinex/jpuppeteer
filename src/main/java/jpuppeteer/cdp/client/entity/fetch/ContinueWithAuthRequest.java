package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class ContinueWithAuthRequest {

    /**
    * An id the client received in authRequired event.
    */
    public final String requestId;

    /**
    * Response to  with an authChallenge.
    */
    public final jpuppeteer.cdp.client.entity.fetch.AuthChallengeResponse authChallengeResponse;

    public ContinueWithAuthRequest(String requestId, jpuppeteer.cdp.client.entity.fetch.AuthChallengeResponse authChallengeResponse) {
        this.requestId = requestId;
        this.authChallengeResponse = authChallengeResponse;
    }

}