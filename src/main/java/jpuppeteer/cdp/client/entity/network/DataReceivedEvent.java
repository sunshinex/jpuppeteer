package jpuppeteer.cdp.client.entity.network;

/**
* Fired when data chunk was received over the network.
*/
public class DataReceivedEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Data chunk length.
    */
    public final Integer dataLength;

    /**
    * Actual bytes received (might be less than dataLength for compressed encodings).
    */
    public final Integer encodedDataLength;

    public DataReceivedEvent(String requestId, java.math.BigDecimal timestamp, Integer dataLength, Integer encodedDataLength) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.dataLength = dataLength;
        this.encodedDataLength = encodedDataLength;
    }

}