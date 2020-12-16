package jpuppeteer.cdp.client.entity.network;

/**
* WebSocket request data.
*/
public class WebSocketRequest {

    /**
    * HTTP request headers.
    */
    public final java.util.Map<String, Object> headers;

    public WebSocketRequest(java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

}