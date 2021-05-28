package jpuppeteer.cdp.client.entity.network;

/**
* Fired upon WebTransport creation.
*/
public class WebTransportCreatedEvent {

    /**
    * WebTransport identifier.
    */
    public final String transportId;

    /**
    * WebTransport request URL.
    */
    public final String url;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Request initiator.
    */
    public final jpuppeteer.cdp.client.entity.network.Initiator initiator;

    public WebTransportCreatedEvent(String transportId, String url, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.entity.network.Initiator initiator) {
        this.transportId = transportId;
        this.url = url;
        this.timestamp = timestamp;
        this.initiator = initiator;
    }

    public WebTransportCreatedEvent(String transportId, String url, java.math.BigDecimal timestamp) {
        this.transportId = transportId;
        this.url = url;
        this.timestamp = timestamp;
        this.initiator = null;
    }

}