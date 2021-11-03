package jpuppeteer.cdp.client.domain;

/**
*/
public class Network {

    private jpuppeteer.cdp.CDPConnection connection;

    public Network(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Sets a list of content encodings that will be accepted. Empty list means no encoding is accepted.
    * experimental
    */
    public io.netty.util.concurrent.Future setAcceptedEncodings(jpuppeteer.cdp.client.entity.network.SetAcceptedEncodingsRequest request) {
        return connection.send("Network.setAcceptedEncodings", request);
    }


    /**
    * Clears accepted encodings set by setAcceptedEncodings
    * experimental
    */
    public io.netty.util.concurrent.Future clearAcceptedEncodingsOverride() {
        return connection.send("Network.clearAcceptedEncodingsOverride", null);
    }


    /**
    * Tells whether clearing browser cache is supported.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.CanClearBrowserCacheResponse> canClearBrowserCache() {
        return connection.send("Network.canClearBrowserCache", null, jpuppeteer.cdp.client.entity.network.CanClearBrowserCacheResponse.class);
    }


    /**
    * Tells whether clearing browser cookies is supported.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.CanClearBrowserCookiesResponse> canClearBrowserCookies() {
        return connection.send("Network.canClearBrowserCookies", null, jpuppeteer.cdp.client.entity.network.CanClearBrowserCookiesResponse.class);
    }


    /**
    * Tells whether emulation of network conditions is supported.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.CanEmulateNetworkConditionsResponse> canEmulateNetworkConditions() {
        return connection.send("Network.canEmulateNetworkConditions", null, jpuppeteer.cdp.client.entity.network.CanEmulateNetworkConditionsResponse.class);
    }


    /**
    * Clears browser cache.
    */
    public io.netty.util.concurrent.Future clearBrowserCache() {
        return connection.send("Network.clearBrowserCache", null);
    }


    /**
    * Clears browser cookies.
    */
    public io.netty.util.concurrent.Future clearBrowserCookies() {
        return connection.send("Network.clearBrowserCookies", null);
    }


    /**
    * Response to Network.requestIntercepted which either modifies the request to continue with any modifications, or blocks it, or completes it with the provided response bytes. If a network fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted event will be sent with the same InterceptionId. Deprecated, use Fetch.continueRequest, Fetch.fulfillRequest and Fetch.failRequest instead.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future continueInterceptedRequest(jpuppeteer.cdp.client.entity.network.ContinueInterceptedRequestRequest request) {
        return connection.send("Network.continueInterceptedRequest", request);
    }


    /**
    * Deletes browser cookies with matching name and url or domain/path pair.
    */
    public io.netty.util.concurrent.Future deleteCookies(jpuppeteer.cdp.client.entity.network.DeleteCookiesRequest request) {
        return connection.send("Network.deleteCookies", request);
    }


    /**
    * Disables network tracking, prevents network events from being sent to the client.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Network.disable", null);
    }


    /**
    * Activates emulation of network conditions.
    */
    public io.netty.util.concurrent.Future emulateNetworkConditions(jpuppeteer.cdp.client.entity.network.EmulateNetworkConditionsRequest request) {
        return connection.send("Network.emulateNetworkConditions", request);
    }


    /**
    * Enables network tracking, network events will now be delivered to the client.
    */
    public io.netty.util.concurrent.Future enable(jpuppeteer.cdp.client.entity.network.EnableRequest request) {
        return connection.send("Network.enable", request);
    }


    /**
    * Returns all browser cookies. Depending on the backend support, will return detailed cookie information in the `cookies` field.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.GetAllCookiesResponse> getAllCookies() {
        return connection.send("Network.getAllCookies", null, jpuppeteer.cdp.client.entity.network.GetAllCookiesResponse.class);
    }


    /**
    * Returns the DER-encoded certificate.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.GetCertificateResponse> getCertificate(jpuppeteer.cdp.client.entity.network.GetCertificateRequest request) {
        return connection.send("Network.getCertificate", request, jpuppeteer.cdp.client.entity.network.GetCertificateResponse.class);
    }


    /**
    * Returns all browser cookies for the current URL. Depending on the backend support, will return detailed cookie information in the `cookies` field.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.GetCookiesResponse> getCookies(jpuppeteer.cdp.client.entity.network.GetCookiesRequest request) {
        return connection.send("Network.getCookies", request, jpuppeteer.cdp.client.entity.network.GetCookiesResponse.class);
    }


    /**
    * Returns content served for the given request.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.GetResponseBodyResponse> getResponseBody(jpuppeteer.cdp.client.entity.network.GetResponseBodyRequest request) {
        return connection.send("Network.getResponseBody", request, jpuppeteer.cdp.client.entity.network.GetResponseBodyResponse.class);
    }


    /**
    * Returns post data sent with the request. Returns an error when no data was sent with the request.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.GetRequestPostDataResponse> getRequestPostData(jpuppeteer.cdp.client.entity.network.GetRequestPostDataRequest request) {
        return connection.send("Network.getRequestPostData", request, jpuppeteer.cdp.client.entity.network.GetRequestPostDataResponse.class);
    }


    /**
    * Returns content served for the given currently intercepted request.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.GetResponseBodyForInterceptionResponse> getResponseBodyForInterception(jpuppeteer.cdp.client.entity.network.GetResponseBodyForInterceptionRequest request) {
        return connection.send("Network.getResponseBodyForInterception", request, jpuppeteer.cdp.client.entity.network.GetResponseBodyForInterceptionResponse.class);
    }


    /**
    * Returns a handle to the stream representing the response body. Note that after this command, the intercepted request can't be continued as is -- you either need to cancel it or to provide the response body. The stream only supports sequential read, IO.read will fail if the position is specified.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.TakeResponseBodyForInterceptionAsStreamResponse> takeResponseBodyForInterceptionAsStream(jpuppeteer.cdp.client.entity.network.TakeResponseBodyForInterceptionAsStreamRequest request) {
        return connection.send("Network.takeResponseBodyForInterceptionAsStream", request, jpuppeteer.cdp.client.entity.network.TakeResponseBodyForInterceptionAsStreamResponse.class);
    }


    /**
    * This method sends a new XMLHttpRequest which is identical to the original one. The following parameters should be identical: method, url, async, request body, extra headers, withCredentials attribute, user, password.
    * experimental
    */
    public io.netty.util.concurrent.Future replayXHR(jpuppeteer.cdp.client.entity.network.ReplayXHRRequest request) {
        return connection.send("Network.replayXHR", request);
    }


    /**
    * Searches for given string in response content.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.SearchInResponseBodyResponse> searchInResponseBody(jpuppeteer.cdp.client.entity.network.SearchInResponseBodyRequest request) {
        return connection.send("Network.searchInResponseBody", request, jpuppeteer.cdp.client.entity.network.SearchInResponseBodyResponse.class);
    }


    /**
    * Blocks URLs from loading.
    * experimental
    */
    public io.netty.util.concurrent.Future setBlockedURLs(jpuppeteer.cdp.client.entity.network.SetBlockedURLsRequest request) {
        return connection.send("Network.setBlockedURLs", request);
    }


    /**
    * Toggles ignoring of service worker for each request.
    * experimental
    */
    public io.netty.util.concurrent.Future setBypassServiceWorker(jpuppeteer.cdp.client.entity.network.SetBypassServiceWorkerRequest request) {
        return connection.send("Network.setBypassServiceWorker", request);
    }


    /**
    * Toggles ignoring cache for each request. If `true`, cache will not be used.
    */
    public io.netty.util.concurrent.Future setCacheDisabled(jpuppeteer.cdp.client.entity.network.SetCacheDisabledRequest request) {
        return connection.send("Network.setCacheDisabled", request);
    }


    /**
    * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.SetCookieResponse> setCookie(jpuppeteer.cdp.client.entity.network.SetCookieRequest request) {
        return connection.send("Network.setCookie", request, jpuppeteer.cdp.client.entity.network.SetCookieResponse.class);
    }


    /**
    * Sets given cookies.
    */
    public io.netty.util.concurrent.Future setCookies(jpuppeteer.cdp.client.entity.network.SetCookiesRequest request) {
        return connection.send("Network.setCookies", request);
    }


    /**
    * For testing.
    * experimental
    */
    public io.netty.util.concurrent.Future setDataSizeLimitsForTest(jpuppeteer.cdp.client.entity.network.SetDataSizeLimitsForTestRequest request) {
        return connection.send("Network.setDataSizeLimitsForTest", request);
    }


    /**
    * Specifies whether to always send extra HTTP headers with the requests from this page.
    */
    public io.netty.util.concurrent.Future setExtraHTTPHeaders(jpuppeteer.cdp.client.entity.network.SetExtraHTTPHeadersRequest request) {
        return connection.send("Network.setExtraHTTPHeaders", request);
    }


    /**
    * Specifies whether to attach a page script stack id in requests
    * experimental
    */
    public io.netty.util.concurrent.Future setAttachDebugStack(jpuppeteer.cdp.client.entity.network.SetAttachDebugStackRequest request) {
        return connection.send("Network.setAttachDebugStack", request);
    }


    /**
    * Sets the requests to intercept that match the provided patterns and optionally resource types. Deprecated, please use Fetch.enable instead.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setRequestInterception(jpuppeteer.cdp.client.entity.network.SetRequestInterceptionRequest request) {
        return connection.send("Network.setRequestInterception", request);
    }


    /**
    * Allows overriding user agent with the given string.
    */
    public io.netty.util.concurrent.Future setUserAgentOverride(jpuppeteer.cdp.client.entity.network.SetUserAgentOverrideRequest request) {
        return connection.send("Network.setUserAgentOverride", request);
    }


    /**
    * Returns information about the COEP/COOP isolation status.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.GetSecurityIsolationStatusResponse> getSecurityIsolationStatus(jpuppeteer.cdp.client.entity.network.GetSecurityIsolationStatusRequest request) {
        return connection.send("Network.getSecurityIsolationStatus", request, jpuppeteer.cdp.client.entity.network.GetSecurityIsolationStatusResponse.class);
    }


    /**
    * Fetches the resource and returns the content.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.network.LoadNetworkResourceResponse> loadNetworkResource(jpuppeteer.cdp.client.entity.network.LoadNetworkResourceRequest request) {
        return connection.send("Network.loadNetworkResource", request, jpuppeteer.cdp.client.entity.network.LoadNetworkResourceResponse.class);
    }

}