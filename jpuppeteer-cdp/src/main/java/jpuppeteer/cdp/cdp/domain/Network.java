package jpuppeteer.cdp.cdp.domain;

/**
*/
public class Network {

    private jpuppeteer.cdp.CDPSession session;

    public Network(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Tells whether clearing browser cache is supported.
    */
    public jpuppeteer.cdp.cdp.entity.network.CanClearBrowserCacheResponse canClearBrowserCache(int timeout) throws Exception {
        return session.send("Network.canClearBrowserCache", null, jpuppeteer.cdp.cdp.entity.network.CanClearBrowserCacheResponse.class, timeout);
    }


    /**
    * Tells whether clearing browser cookies is supported.
    */
    public jpuppeteer.cdp.cdp.entity.network.CanClearBrowserCookiesResponse canClearBrowserCookies(int timeout) throws Exception {
        return session.send("Network.canClearBrowserCookies", null, jpuppeteer.cdp.cdp.entity.network.CanClearBrowserCookiesResponse.class, timeout);
    }


    /**
    * Tells whether emulation of network conditions is supported.
    */
    public jpuppeteer.cdp.cdp.entity.network.CanEmulateNetworkConditionsResponse canEmulateNetworkConditions(int timeout) throws Exception {
        return session.send("Network.canEmulateNetworkConditions", null, jpuppeteer.cdp.cdp.entity.network.CanEmulateNetworkConditionsResponse.class, timeout);
    }


    /**
    * Clears browser cache.
    */
    public void clearBrowserCache(int timeout) throws Exception {
        session.send("Network.clearBrowserCache", null, timeout);
    }


    /**
    * Clears browser cookies.
    */
    public void clearBrowserCookies(int timeout) throws Exception {
        session.send("Network.clearBrowserCookies", null, timeout);
    }


    /**
    * Response to Network.requestIntercepted which either modifies the request to continue with any modifications, or blocks it, or completes it with the provided response bytes. If a network fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted event will be sent with the same InterceptionId. Deprecated, use Fetch.continueRequest, Fetch.fulfillRequest and Fetch.failRequest instead.
    */
    public void continueInterceptedRequest(jpuppeteer.cdp.cdp.entity.network.ContinueInterceptedRequestRequest request, int timeout) throws Exception {
        session.send("Network.continueInterceptedRequest", request, timeout);
    }


    /**
    * Deletes browser cookies with matching name and url or domain/path pair.
    */
    public void deleteCookies(jpuppeteer.cdp.cdp.entity.network.DeleteCookiesRequest request, int timeout) throws Exception {
        session.send("Network.deleteCookies", request, timeout);
    }


    /**
    * Disables network tracking, prevents network events from being sent to the client.
    */
    public void disable(int timeout) throws Exception {
        session.send("Network.disable", null, timeout);
    }


    /**
    * Activates emulation of network conditions.
    */
    public void emulateNetworkConditions(jpuppeteer.cdp.cdp.entity.network.EmulateNetworkConditionsRequest request, int timeout) throws Exception {
        session.send("Network.emulateNetworkConditions", request, timeout);
    }


    /**
    * Enables network tracking, network events will now be delivered to the client.
    */
    public void enable(jpuppeteer.cdp.cdp.entity.network.EnableRequest request, int timeout) throws Exception {
        session.send("Network.enable", request, timeout);
    }


    /**
    * Returns all browser cookies. Depending on the backend support, will return detailed cookie information in the `cookies` field.
    */
    public jpuppeteer.cdp.cdp.entity.network.GetAllCookiesResponse getAllCookies(int timeout) throws Exception {
        return session.send("Network.getAllCookies", null, jpuppeteer.cdp.cdp.entity.network.GetAllCookiesResponse.class, timeout);
    }


    /**
    * Returns the DER-encoded certificate.
    */
    public jpuppeteer.cdp.cdp.entity.network.GetCertificateResponse getCertificate(jpuppeteer.cdp.cdp.entity.network.GetCertificateRequest request, int timeout) throws Exception {
        return session.send("Network.getCertificate", request, jpuppeteer.cdp.cdp.entity.network.GetCertificateResponse.class, timeout);
    }


    /**
    * Returns all browser cookies for the current URL. Depending on the backend support, will return detailed cookie information in the `cookies` field.
    */
    public jpuppeteer.cdp.cdp.entity.network.GetCookiesResponse getCookies(jpuppeteer.cdp.cdp.entity.network.GetCookiesRequest request, int timeout) throws Exception {
        return session.send("Network.getCookies", request, jpuppeteer.cdp.cdp.entity.network.GetCookiesResponse.class, timeout);
    }


    /**
    * Returns content served for the given request.
    */
    public jpuppeteer.cdp.cdp.entity.network.GetResponseBodyResponse getResponseBody(jpuppeteer.cdp.cdp.entity.network.GetResponseBodyRequest request, int timeout) throws Exception {
        return session.send("Network.getResponseBody", request, jpuppeteer.cdp.cdp.entity.network.GetResponseBodyResponse.class, timeout);
    }


    /**
    * Returns post data sent with the request. Returns an error when no data was sent with the request.
    */
    public jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataResponse getRequestPostData(jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataRequest request, int timeout) throws Exception {
        return session.send("Network.getRequestPostData", request, jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataResponse.class, timeout);
    }


    /**
    * Returns content served for the given currently intercepted request.
    */
    public jpuppeteer.cdp.cdp.entity.network.GetResponseBodyForInterceptionResponse getResponseBodyForInterception(jpuppeteer.cdp.cdp.entity.network.GetResponseBodyForInterceptionRequest request, int timeout) throws Exception {
        return session.send("Network.getResponseBodyForInterception", request, jpuppeteer.cdp.cdp.entity.network.GetResponseBodyForInterceptionResponse.class, timeout);
    }


    /**
    * Returns a handle to the stream representing the response body. Note that after this command, the intercepted request can't be continued as is -- you either need to cancel it or to provide the response body. The stream only supports sequential read, IO.read will fail if the position is specified.
    */
    public jpuppeteer.cdp.cdp.entity.network.TakeResponseBodyForInterceptionAsStreamResponse takeResponseBodyForInterceptionAsStream(jpuppeteer.cdp.cdp.entity.network.TakeResponseBodyForInterceptionAsStreamRequest request, int timeout) throws Exception {
        return session.send("Network.takeResponseBodyForInterceptionAsStream", request, jpuppeteer.cdp.cdp.entity.network.TakeResponseBodyForInterceptionAsStreamResponse.class, timeout);
    }


    /**
    * This method sends a new XMLHttpRequest which is identical to the original one. The following parameters should be identical: method, url, async, request body, extra headers, withCredentials attribute, user, password.
    */
    public void replayXHR(jpuppeteer.cdp.cdp.entity.network.ReplayXHRRequest request, int timeout) throws Exception {
        session.send("Network.replayXHR", request, timeout);
    }


    /**
    * Searches for given string in response content.
    */
    public jpuppeteer.cdp.cdp.entity.network.SearchInResponseBodyResponse searchInResponseBody(jpuppeteer.cdp.cdp.entity.network.SearchInResponseBodyRequest request, int timeout) throws Exception {
        return session.send("Network.searchInResponseBody", request, jpuppeteer.cdp.cdp.entity.network.SearchInResponseBodyResponse.class, timeout);
    }


    /**
    * Blocks URLs from loading.
    */
    public void setBlockedURLs(jpuppeteer.cdp.cdp.entity.network.SetBlockedURLsRequest request, int timeout) throws Exception {
        session.send("Network.setBlockedURLs", request, timeout);
    }


    /**
    * Toggles ignoring of service worker for each request.
    */
    public void setBypassServiceWorker(jpuppeteer.cdp.cdp.entity.network.SetBypassServiceWorkerRequest request, int timeout) throws Exception {
        session.send("Network.setBypassServiceWorker", request, timeout);
    }


    /**
    * Toggles ignoring cache for each request. If `true`, cache will not be used.
    */
    public void setCacheDisabled(jpuppeteer.cdp.cdp.entity.network.SetCacheDisabledRequest request, int timeout) throws Exception {
        session.send("Network.setCacheDisabled", request, timeout);
    }


    /**
    * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
    */
    public jpuppeteer.cdp.cdp.entity.network.SetCookieResponse setCookie(jpuppeteer.cdp.cdp.entity.network.SetCookieRequest request, int timeout) throws Exception {
        return session.send("Network.setCookie", request, jpuppeteer.cdp.cdp.entity.network.SetCookieResponse.class, timeout);
    }


    /**
    * Sets given cookies.
    */
    public void setCookies(jpuppeteer.cdp.cdp.entity.network.SetCookiesRequest request, int timeout) throws Exception {
        session.send("Network.setCookies", request, timeout);
    }


    /**
    * For testing.
    */
    public void setDataSizeLimitsForTest(jpuppeteer.cdp.cdp.entity.network.SetDataSizeLimitsForTestRequest request, int timeout) throws Exception {
        session.send("Network.setDataSizeLimitsForTest", request, timeout);
    }


    /**
    * Specifies whether to always send extra HTTP headers with the requests from this page.
    */
    public void setExtraHTTPHeaders(jpuppeteer.cdp.cdp.entity.network.SetExtraHTTPHeadersRequest request, int timeout) throws Exception {
        session.send("Network.setExtraHTTPHeaders", request, timeout);
    }


    /**
    * Sets the requests to intercept that match the provided patterns and optionally resource types. Deprecated, please use Fetch.enable instead.
    */
    public void setRequestInterception(jpuppeteer.cdp.cdp.entity.network.SetRequestInterceptionRequest request, int timeout) throws Exception {
        session.send("Network.setRequestInterception", request, timeout);
    }


    /**
    * Allows overriding user agent with the given string.
    */
    public void setUserAgentOverride(jpuppeteer.cdp.cdp.entity.network.SetUserAgentOverrideRequest request, int timeout) throws Exception {
        session.send("Network.setUserAgentOverride", request, timeout);
    }

}