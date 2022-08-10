package jpuppeteer.cdp.client.entity.network;

/**
*/
public class EmulateNetworkConditionsRequest {

    /**
    * True to emulate internet disconnection.
    */
    private Boolean offline;

    /**
    * Minimum latency from request sent to response headers received (ms).
    */
    private java.math.BigDecimal latency;

    /**
    * Maximal aggregated download throughput (bytes/sec). -1 disables download throttling.
    */
    private java.math.BigDecimal downloadThroughput;

    /**
    * Maximal aggregated upload throughput (bytes/sec).  -1 disables upload throttling.
    */
    private java.math.BigDecimal uploadThroughput;

    /**
    * Connection type if known.
    */
    private jpuppeteer.cdp.client.constant.network.ConnectionType connectionType;

    public void setOffline (Boolean offline) {
        this.offline = offline;
    }

    public Boolean getOffline() {
        return this.offline;
    }

    public void setLatency (java.math.BigDecimal latency) {
        this.latency = latency;
    }

    public java.math.BigDecimal getLatency() {
        return this.latency;
    }

    public void setDownloadThroughput (java.math.BigDecimal downloadThroughput) {
        this.downloadThroughput = downloadThroughput;
    }

    public java.math.BigDecimal getDownloadThroughput() {
        return this.downloadThroughput;
    }

    public void setUploadThroughput (java.math.BigDecimal uploadThroughput) {
        this.uploadThroughput = uploadThroughput;
    }

    public java.math.BigDecimal getUploadThroughput() {
        return this.uploadThroughput;
    }

    public void setConnectionType (jpuppeteer.cdp.client.constant.network.ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public jpuppeteer.cdp.client.constant.network.ConnectionType getConnectionType() {
        return this.connectionType;
    }

    public EmulateNetworkConditionsRequest(Boolean offline, java.math.BigDecimal latency, java.math.BigDecimal downloadThroughput, java.math.BigDecimal uploadThroughput, jpuppeteer.cdp.client.constant.network.ConnectionType connectionType) {
        this.offline = offline;
        this.latency = latency;
        this.downloadThroughput = downloadThroughput;
        this.uploadThroughput = uploadThroughput;
        this.connectionType = connectionType;
    }

    public EmulateNetworkConditionsRequest(Boolean offline, java.math.BigDecimal latency, java.math.BigDecimal downloadThroughput, java.math.BigDecimal uploadThroughput) {
        this.offline = offline;
        this.latency = latency;
        this.downloadThroughput = downloadThroughput;
        this.uploadThroughput = uploadThroughput;
        this.connectionType = null;
    }

    public EmulateNetworkConditionsRequest() {
    }

}