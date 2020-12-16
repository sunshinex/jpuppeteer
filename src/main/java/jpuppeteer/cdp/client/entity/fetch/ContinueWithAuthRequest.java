package jpuppeteer.cdp.client.entity.fetch;

/**
* experimental
*/
public class ContinueWithAuthRequest {

    /**
    * An id the client received in authRequired event.
    */
    public final String requestId;

    /**
    * Response to  with an authChallenge.
    */
    public final AuthChallengeResponse authChallengeResponse;

    public ContinueWithAuthRequest(String requestId, AuthChallengeResponse authChallengeResponse) {
        this.requestId = requestId;
        this.authChallengeResponse = authChallengeResponse;
    }

}