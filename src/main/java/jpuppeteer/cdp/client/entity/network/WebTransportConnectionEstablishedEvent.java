package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebTransport handshake is finished.
*/
public class WebTransportConnectionEstablishedEvent {

    /**
    * WebTransport identifier.
    */
    public final String transportId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    public WebTransportConnectionEstablishedEvent(String transportId, java.math.BigDecimal timestamp) {
        this.transportId = transportId;
        this.timestamp = timestamp;
    }

}