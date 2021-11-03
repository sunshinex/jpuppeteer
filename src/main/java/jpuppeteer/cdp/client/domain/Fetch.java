package jpuppeteer.cdp.client.domain;

/**
*/
public class Fetch {

    private jpuppeteer.cdp.CDPConnection connection;

    public Fetch(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Disables the fetch domain.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Fetch.disable", null);
    }


    /**
    * Enables issuing of requestPaused events. A request will be paused until client calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.
    */
    public io.netty.util.concurrent.Future enable(jpuppeteer.cdp.client.entity.fetch.EnableRequest request) {
        return connection.send("Fetch.enable", request);
    }


    /**
    * Causes the request to fail with specified reason.
    */
    public io.netty.util.concurrent.Future failRequest(jpuppeteer.cdp.client.entity.fetch.FailRequestRequest request) {
        return connection.send("Fetch.failRequest", request);
    }


    /**
    * Provides response to the request.
    */
    public io.netty.util.concurrent.Future fulfillRequest(jpuppeteer.cdp.client.entity.fetch.FulfillRequestRequest request) {
        return connection.send("Fetch.fulfillRequest", request);
    }


    /**
    * Continues the request, optionally modifying some of its parameters.
    */
    public io.netty.util.concurrent.Future continueRequest(jpuppeteer.cdp.client.entity.fetch.ContinueRequestRequest request) {
        return connection.send("Fetch.continueRequest", request);
    }


    /**
    * Continues a request supplying authChallengeResponse following authRequired event.
    */
    public io.netty.util.concurrent.Future continueWithAuth(jpuppeteer.cdp.client.entity.fetch.ContinueWithAuthRequest request) {
        return connection.send("Fetch.continueWithAuth", request);
    }


    /**
    * Causes the body of the response to be received from the server and returned as a single string. May only be issued for a request that is paused in the Response stage and is mutually exclusive with takeResponseBodyForInterceptionAsStream. Calling other methods that affect the request or disabling fetch domain before body is received results in an undefined behavior.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.fetch.GetResponseBodyResponse> getResponseBody(jpuppeteer.cdp.client.entity.fetch.GetResponseBodyRequest request) {
        return connection.send("Fetch.getResponseBody", request, jpuppeteer.cdp.client.entity.fetch.GetResponseBodyResponse.class);
    }


    /**
    * Returns a handle to the stream representing the response body. The request must be paused in the HeadersReceived stage. Note that after this command the request can't be continued as is -- client either needs to cancel it or to provide the response body. The stream only supports sequential read, IO.read will fail if the position is specified. This method is mutually exclusive with getResponseBody. Calling other methods that affect the request or disabling fetch domain before body is received results in an undefined behavior.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.fetch.TakeResponseBodyAsStreamResponse> takeResponseBodyAsStream(jpuppeteer.cdp.client.entity.fetch.TakeResponseBodyAsStreamRequest request) {
        return connection.send("Fetch.takeResponseBodyAsStream", request, jpuppeteer.cdp.client.entity.fetch.TakeResponseBodyAsStreamResponse.class);
    }

}