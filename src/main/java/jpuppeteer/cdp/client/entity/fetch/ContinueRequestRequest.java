package jpuppeteer.cdp.client.entity.fetch;

/**
* experimental
*/
public class ContinueRequestRequest {

    /**
    * An id the client received in requestPaused event.
    */
    public final String requestId;

    /**
    * If set, the request url will be modified in a way that's not observable by page.
    */
    public final String url;

    /**
    * If set, the request method is overridden.
    */
    public final String method;

    /**
    * If set, overrides the post data in the request.
    */
    public final String postData;

    /**
    * If set, overrides the request headrts.
    */
    public final java.util.List<HeaderEntry> headers;

    public ContinueRequestRequest(String requestId, String url, String method, String postData, java.util.List<HeaderEntry> headers) {
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

}