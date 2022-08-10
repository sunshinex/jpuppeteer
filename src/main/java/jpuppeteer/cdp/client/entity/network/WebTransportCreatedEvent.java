package jpuppeteer.cdp.client.entity.network;

/**
* Fired upon WebTransport creation.
*/
public class WebTransportCreatedEvent {

    /**
    * WebTransport identifier.
    */
    private String transportId;

    /**
    * WebTransport request URL.
    */
    private String url;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Request initiator.
    */
    private jpuppeteer.cdp.client.entity.network.Initiator initiator;

    public void setTransportId (String transportId) {
        this.transportId = transportId;
    }

    public String getTransportId() {
        return this.transportId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setInitiator (jpuppeteer.cdp.client.entity.network.Initiator initiator) {
        this.initiator = initiator;
    }

    public jpuppeteer.cdp.client.entity.network.Initiator getInitiator() {
        return this.initiator;
    }

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

    public WebTransportCreatedEvent() {
    }

}