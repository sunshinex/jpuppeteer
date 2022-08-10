package jpuppeteer.cdp.client.entity.network;

/**
* WebSocket response data.
*/
public class WebSocketResponse {

    /**
    * HTTP response status code.
    */
    private Integer status;

    /**
    * HTTP response status text.
    */
    private String statusText;

    /**
    * HTTP response headers.
    */
    private java.util.Map<String, Object> headers;

    /**
    * HTTP response headers text.
    */
    private String headersText;

    /**
    * HTTP request headers.
    */
    private java.util.Map<String, Object> requestHeaders;

    /**
    * HTTP request headers text.
    */
    private String requestHeadersText;

    public void setStatus (Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatusText (String statusText) {
        this.statusText = statusText;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public void setHeaders (java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public java.util.Map<String, Object> getHeaders() {
        return this.headers;
    }

    public void setHeadersText (String headersText) {
        this.headersText = headersText;
    }

    public String getHeadersText() {
        return this.headersText;
    }

    public void setRequestHeaders (java.util.Map<String, Object> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public java.util.Map<String, Object> getRequestHeaders() {
        return this.requestHeaders;
    }

    public void setRequestHeadersText (String requestHeadersText) {
        this.requestHeadersText = requestHeadersText;
    }

    public String getRequestHeadersText() {
        return this.requestHeadersText;
    }

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

    public WebSocketResponse() {
    }

}