package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class ContinueRequestRequest {

    /**
    * An id the client received in requestPaused event.
    */
    private String requestId;

    /**
    * If set, the request url will be modified in a way that's not observable by page.
    */
    private String url;

    /**
    * If set, the request method is overridden.
    */
    private String method;

    /**
    * If set, overrides the post data in the request. (Encoded as a base64 string when passed over JSON)
    */
    private String postData;

    /**
    * If set, overrides the request headers.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> headers;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
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

    public void setHeaders (java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> headers) {
        this.headers = headers;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> getHeaders() {
        return this.headers;
    }

    public ContinueRequestRequest(String requestId, String url, String method, String postData, java.util.List<jpuppeteer.cdp.client.entity.fetch.HeaderEntry> headers) {
        this.requestId = requestId;
        this.url = url;
        this.method = method;
        this.postData = postData;
        this.headers = headers;
    }

    public ContinueRequestRequest(String requestId) {
        this.requestId = requestId;
        this.url = null;
        this.method = null;
        this.postData = null;
        this.headers = null;
    }

    public ContinueRequestRequest() {
    }

}