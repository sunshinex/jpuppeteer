package jpuppeteer.cdp.client.entity.network;

/**
* Fired when HTTP request has finished loading.
*/
public class LoadingFinishedEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Total number of bytes received for this request.
    */
    public final java.math.BigDecimal encodedDataLength;

    /**
    * Set when 1) response was blocked by Cross-Origin Read Blocking and also 2) this needs to be reported to the DevTools console.
    */
    public final Boolean shouldReportCorbBlocking;

    public LoadingFinishedEvent(String requestId, java.math.BigDecimal timestamp, java.math.BigDecimal encodedDataLength, Boolean shouldReportCorbBlocking) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.encodedDataLength = encodedDataLength;
        this.shouldReportCorbBlocking = shouldReportCorbBlocking;
    }

    public LoadingFinishedEvent(String requestId, java.math.BigDecimal timestamp, java.math.BigDecimal encodedDataLength) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.encodedDataLength = encodedDataLength;
        this.shouldReportCorbBlocking = null;
    }

}