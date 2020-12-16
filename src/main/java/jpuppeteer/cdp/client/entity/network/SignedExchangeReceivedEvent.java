package jpuppeteer.cdp.client.entity.network;

/**
* Fired when a signed exchange was received over the network
*/
public class SignedExchangeReceivedEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Information about the signed exchange response.
    */
    public final SignedExchangeInfo info;

    public SignedExchangeReceivedEvent(String requestId, SignedExchangeInfo info) {
        this.requestId = requestId;
        this.info = info;
    }

}