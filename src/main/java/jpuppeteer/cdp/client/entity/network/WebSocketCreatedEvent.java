package jpuppeteer.cdp.client.entity.network;

/**
* Fired upon WebSocket creation.
*/
public class WebSocketCreatedEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * WebSocket request URL.
    */
    public final String url;

    /**
    * Request initiator.
    */
    public final Initiator initiator;

    public WebSocketCreatedEvent(String requestId, String url, Initiator initiator) {
        this.requestId = requestId;
        this.url = url;
        this.initiator = initiator;
    }

    public WebSocketCreatedEvent(String requestId, String url) {
        this.requestId = requestId;
        this.url = url;
        this.initiator = null;
    }

}