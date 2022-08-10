package jpuppeteer.cdp.client.entity.network;

/**
* Fired upon WebSocket creation.
*/
public class WebSocketCreatedEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * WebSocket request URL.
    */
    private String url;

    /**
    * Request initiator.
    */
    private jpuppeteer.cdp.client.entity.network.Initiator initiator;

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

    public void setInitiator (jpuppeteer.cdp.client.entity.network.Initiator initiator) {
        this.initiator = initiator;
    }

    public jpuppeteer.cdp.client.entity.network.Initiator getInitiator() {
        return this.initiator;
    }

    public WebSocketCreatedEvent(String requestId, String url, jpuppeteer.cdp.client.entity.network.Initiator initiator) {
        this.requestId = requestId;
        this.url = url;
        this.initiator = initiator;
    }

    public WebSocketCreatedEvent(String requestId, String url) {
        this.requestId = requestId;
        this.url = url;
        this.initiator = null;
    }

    public WebSocketCreatedEvent() {
    }

}