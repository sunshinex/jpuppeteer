package jpuppeteer.cdp.client.entity.network;

/**
*/
public class ContinueInterceptedRequestRequest {

    /**
    */
    public final String interceptionId;

    /**
    * If set this causes the request to fail with the given reason. Passing `Aborted` for requests marked with `isNavigationRequest` also cancels the navigation. Must not be set in response to an authChallenge.
    */
    public final String errorReason;

    /**
    * If set the requests completes using with the provided base64 encoded raw response, including HTTP status line and headers etc... Must not be set in response to an authChallenge.
    */
    public final String rawResponse;

    /**
    * If set the request url will be modified in a way that's not observable by page. Must not be set in response to an authChallenge.
    */
    public final String url;

    /**
    * If set this allows the request method to be overridden. Must not be set in response to an authChallenge.
    */
    public final String method;

    /**
    * If set this allows postData to be set. Must not be set in response to an authChallenge.
    */
    public final String postData;

    /**
    * If set this allows the request headers to be changed. Must not be set in response to an authChallenge.
    */
    public final java.util.Map<String, Object> headers;

    /**
    * Response to a requestIntercepted with an authChallenge. Must not be set otherwise.
    */
    public final jpuppeteer.cdp.client.entity.network.AuthChallengeResponse authChallengeResponse;

    public ContinueInterceptedRequestRequest(String interceptionId, String errorReason, String rawResponse, String url, String method, String postData, java.util.Map<String, Object> headers, jpuppeteer.cdp.client.entity.network.AuthChallengeResponse authChallengeResponse) {
        this.interceptionId = interceptionId;
        this.errorReason = errorReason;
        this.rawResponse = rawResponse;
        this.url = url;
        this.method = method;
        this.postData = postData;
        this.headers = headers;
        this.authChallengeResponse = authChallengeResponse;
    }

    public ContinueInterceptedRequestRequest(String interceptionId) {
        this.interceptionId = interceptionId;
        this.errorReason = null;
        this.rawResponse = null;
        this.url = null;
        this.method = null;
        this.postData = null;
        this.headers = null;
        this.authChallengeResponse = null;
    }

}