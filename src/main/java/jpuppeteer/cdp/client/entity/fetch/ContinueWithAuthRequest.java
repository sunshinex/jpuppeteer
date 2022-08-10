package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class ContinueWithAuthRequest {

    /**
    * An id the client received in authRequired event.
    */
    private String requestId;

    /**
    * Response to  with an authChallenge.
    */
    private jpuppeteer.cdp.client.entity.fetch.AuthChallengeResponse authChallengeResponse;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setAuthChallengeResponse (jpuppeteer.cdp.client.entity.fetch.AuthChallengeResponse authChallengeResponse) {
        this.authChallengeResponse = authChallengeResponse;
    }

    public jpuppeteer.cdp.client.entity.fetch.AuthChallengeResponse getAuthChallengeResponse() {
        return this.authChallengeResponse;
    }

    public ContinueWithAuthRequest(String requestId, jpuppeteer.cdp.client.entity.fetch.AuthChallengeResponse authChallengeResponse) {
        this.requestId = requestId;
        this.authChallengeResponse = authChallengeResponse;
    }

    public ContinueWithAuthRequest() {
    }

}