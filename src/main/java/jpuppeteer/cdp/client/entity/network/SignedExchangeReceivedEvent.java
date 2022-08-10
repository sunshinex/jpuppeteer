package jpuppeteer.cdp.client.entity.network;

/**
* Fired when a signed exchange was received over the network
*/
public class SignedExchangeReceivedEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Information about the signed exchange response.
    */
    private jpuppeteer.cdp.client.entity.network.SignedExchangeInfo info;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setInfo (jpuppeteer.cdp.client.entity.network.SignedExchangeInfo info) {
        this.info = info;
    }

    public jpuppeteer.cdp.client.entity.network.SignedExchangeInfo getInfo() {
        return this.info;
    }

    public SignedExchangeReceivedEvent(String requestId, jpuppeteer.cdp.client.entity.network.SignedExchangeInfo info) {
        this.requestId = requestId;
        this.info = info;
    }

    public SignedExchangeReceivedEvent() {
    }

}