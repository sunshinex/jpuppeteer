package jpuppeteer.cdp.client.entity.network;

/**
* Fired when data chunk was received over the network.
*/
public class DataReceivedEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Data chunk length.
    */
    private Integer dataLength;

    /**
    * Actual bytes received (might be less than dataLength for compressed encodings).
    */
    private Integer encodedDataLength;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setDataLength (Integer dataLength) {
        this.dataLength = dataLength;
    }

    public Integer getDataLength() {
        return this.dataLength;
    }

    public void setEncodedDataLength (Integer encodedDataLength) {
        this.encodedDataLength = encodedDataLength;
    }

    public Integer getEncodedDataLength() {
        return this.encodedDataLength;
    }

    public DataReceivedEvent(String requestId, java.math.BigDecimal timestamp, Integer dataLength, Integer encodedDataLength) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.dataLength = dataLength;
        this.encodedDataLength = encodedDataLength;
    }

    public DataReceivedEvent() {
    }

}