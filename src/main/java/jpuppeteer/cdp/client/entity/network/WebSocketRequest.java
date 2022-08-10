package jpuppeteer.cdp.client.entity.network;

/**
* WebSocket request data.
*/
public class WebSocketRequest {

    /**
    * HTTP request headers.
    */
    private java.util.Map<String, Object> headers;

    public void setHeaders (java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public java.util.Map<String, Object> getHeaders() {
        return this.headers;
    }

    public WebSocketRequest(java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public WebSocketRequest() {
    }

}