package jpuppeteer.cdp.client.entity.network;

/**
* Fired when WebTransport handshake is finished.
*/
public class WebTransportConnectionEstablishedEvent {

    /**
    * WebTransport identifier.
    */
    private String transportId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    public void setTransportId (String transportId) {
        this.transportId = transportId;
    }

    public String getTransportId() {
        return this.transportId;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public WebTransportConnectionEstablishedEvent(String transportId, java.math.BigDecimal timestamp) {
        this.transportId = transportId;
        this.timestamp = timestamp;
    }

    public WebTransportConnectionEstablishedEvent() {
    }

}