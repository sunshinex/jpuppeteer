package jpuppeteer.cdp.client.entity.network;

/**
* Fired when HTTP request has finished loading.
*/
public class LoadingFinishedEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Total number of bytes received for this request.
    */
    private java.math.BigDecimal encodedDataLength;

    /**
    * Set when 1) response was blocked by Cross-Origin Read Blocking and also 2) this needs to be reported to the DevTools console.
    */
    private Boolean shouldReportCorbBlocking;

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

    public void setEncodedDataLength (java.math.BigDecimal encodedDataLength) {
        this.encodedDataLength = encodedDataLength;
    }

    public java.math.BigDecimal getEncodedDataLength() {
        return this.encodedDataLength;
    }

    public void setShouldReportCorbBlocking (Boolean shouldReportCorbBlocking) {
        this.shouldReportCorbBlocking = shouldReportCorbBlocking;
    }

    public Boolean getShouldReportCorbBlocking() {
        return this.shouldReportCorbBlocking;
    }

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

    public LoadingFinishedEvent() {
    }

}