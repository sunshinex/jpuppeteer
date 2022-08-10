package jpuppeteer.cdp.client.entity.network;

/**
*/
public class ContinueInterceptedRequestRequest {

    /**
    */
    private String interceptionId;

    /**
    * If set this causes the request to fail with the given reason. Passing `Aborted` for requests marked with `isNavigationRequest` also cancels the navigation. Must not be set in response to an authChallenge.
    */
    private jpuppeteer.cdp.client.constant.network.ErrorReason errorReason;

    /**
    * If set the requests completes using with the provided base64 encoded raw response, including HTTP status line and headers etc... Must not be set in response to an authChallenge. (Encoded as a base64 string when passed over JSON)
    */
    private String rawResponse;

    /**
    * If set the request url will be modified in a way that's not observable by page. Must not be set in response to an authChallenge.
    */
    private String url;

    /**
    * If set this allows the request method to be overridden. Must not be set in response to an authChallenge.
    */
    private String method;

    /**
    * If set this allows postData to be set. Must not be set in response to an authChallenge.
    */
    private String postData;

    /**
    * If set this allows the request headers to be changed. Must not be set in response to an authChallenge.
    */
    private java.util.Map<String, Object> headers;

    /**
    * Response to a requestIntercepted with an authChallenge. Must not be set otherwise.
    */
    private jpuppeteer.cdp.client.entity.network.AuthChallengeResponse authChallengeResponse;

    public void setInterceptionId (String interceptionId) {
        this.interceptionId = interceptionId;
    }

    public String getInterceptionId() {
        return this.interceptionId;
    }

    public void setErrorReason (jpuppeteer.cdp.client.constant.network.ErrorReason errorReason) {
        this.errorReason = errorReason;
    }

    public jpuppeteer.cdp.client.constant.network.ErrorReason getErrorReason() {
        return this.errorReason;
    }

    public void setRawResponse (String rawResponse) {
        this.rawResponse = rawResponse;
    }

    public String getRawResponse() {
        return this.rawResponse;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setMethod (String method) {
        this.method = method;
    }

    public String getMethod() {
        return this.method;
    }

    public void setPostData (String postData) {
        this.postData = postData;
    }

    public String getPostData() {
        return this.postData;
    }

    public void setHeaders (java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public java.util.Map<String, Object> getHeaders() {
        return this.headers;
    }

    public void setAuthChallengeResponse (jpuppeteer.cdp.client.entity.network.AuthChallengeResponse authChallengeResponse) {
        this.authChallengeResponse = authChallengeResponse;
    }

    public jpuppeteer.cdp.client.entity.network.AuthChallengeResponse getAuthChallengeResponse() {
        return this.authChallengeResponse;
    }

    public ContinueInterceptedRequestRequest(String interceptionId, jpuppeteer.cdp.client.constant.network.ErrorReason errorReason, String rawResponse, String url, String method, String postData, java.util.Map<String, Object> headers, jpuppeteer.cdp.client.entity.network.AuthChallengeResponse authChallengeResponse) {
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

    public ContinueInterceptedRequestRequest() {
    }

}