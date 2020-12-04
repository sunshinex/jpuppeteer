package jpuppeteer.cdp.client.entity.fetch;

/**
* experimental
*/
public class FulfillRequestRequest {

    /**
    * An id the client received in requestPaused event.
    */
    public final String requestId;

    /**
    * An HTTP response code.
    */
    public final Integer responseCode;

    /**
    * Response headers.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> responseHeaders;

    /**
    * Alternative way of specifying response headers as a \0-separated series of name: value pairs. Prefer the above method unless you need to represent some non-UTF8 values that can't be transmitted over the protocol as text.
    */
    public final String binaryResponseHeaders;

    /**
    * A response body.
    */
    public final String body;

    /**
    * A textual representation of responseCode. If absent, a standard phrase matching responseCode is used.
    */
    public final String responsePhrase;

    public FulfillRequestRequest(String requestId, Integer responseCode, java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> responseHeaders, String binaryResponseHeaders, String body, String responsePhrase) {
        this.requestId = requestId;
        this.responseCode = responseCode;
        this.responseHeaders = responseHeaders;
        this.binaryResponseHeaders = binaryResponseHeaders;
        this.body = body;
        this.responsePhrase = responsePhrase;
    }

    public FulfillRequestRequest(String requestId, Integer responseCode) {
        this.requestId = requestId;
        this.responseCode = responseCode;
        this.responseHeaders = null;
        this.binaryResponseHeaders = null;
        this.body = null;
        this.responsePhrase = null;
    }

}