package jpuppeteer.cdp.client.entity.network;

/**
* WebSocket response data.
*/
public class WebSocketResponse {

    /**
    * HTTP response status code.
    */
    public final Integer status;

    /**
    * HTTP response status text.
    */
    public final String statusText;

    /**
    * HTTP response headers.
    */
    public final java.util.Map<String, Object> headers;

    /**
    * HTTP response headers text.
    */
    public final String headersText;

    /**
    * HTTP request headers.
    */
    public final java.util.Map<String, Object> requestHeaders;

    /**
    * HTTP request headers text.
    */
    public final String requestHeadersText;

    public WebSocketResponse(Integer status, String statusText, java.util.Map<String, Object> headers, String headersText, java.util.Map<String, Object> requestHeaders, String requestHeadersText) {
        this.status = status;
        this.statusText = statusText;
        this.headers = headers;
        this.headersText = headersText;
        this.requestHeaders = requestHeaders;
        this.requestHeadersText = requestHeadersText;
    }

    public WebSocketResponse(Integer status, String statusText, java.util.Map<String, Object> headers) {
        this.status = status;
        this.statusText = statusText;
        this.headers = headers;
        this.headersText = null;
        this.requestHeaders = null;
        this.requestHeadersText = null;
    }

}