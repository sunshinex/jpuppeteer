package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebTransport is disposed.
*/
public class WebTransportClosedEvent {

    /**
    * WebTransport identifier.
    */
    public final String transportId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    public WebTransportClosedEvent(String transportId, java.math.BigDecimal timestamp) {
        this.transportId = transportId;
        this.timestamp = timestamp;
    }

}