package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class FulfillRequestRequest {

    /**
    * An id the client received in requestPaused event.
    */
    private String requestId;

    /**
    * An HTTP response code.
    */
    private Integer responseCode;

    /**
    * Response headers.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> responseHeaders;

    /**
    * Alternative way of specifying response headers as a \0-separated series of name: value pairs. Prefer the above method unless you need to represent some non-UTF8 values that can't be transmitted over the protocol as text. (Encoded as a base64 string when passed over JSON)
    */
    private String binaryResponseHeaders;

    /**
    * A response body. (Encoded as a base64 string when passed over JSON)
    */
    private String body;

    /**
    * A textual representation of responseCode. If absent, a standard phrase matching responseCode is used.
    */
    private String responsePhrase;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setResponseCode (Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseHeaders (java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> getResponseHeaders() {
        return this.responseHeaders;
    }

    public void setBinaryResponseHeaders (String binaryResponseHeaders) {
        this.binaryResponseHeaders = binaryResponseHeaders;
    }

    public String getBinaryResponseHeaders() {
        return this.binaryResponseHeaders;
    }

    public void setBody (String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

    public void setResponsePhrase (String responsePhrase) {
        this.responsePhrase = responsePhrase;
    }

    public String getResponsePhrase() {
        return this.responsePhrase;
    }

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

    public FulfillRequestRequest() {
    }

}