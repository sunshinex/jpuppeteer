package jpuppeteer.cdp.client.entity.network;

/**
*/
public class EmulateNetworkConditionsRequest {

    /**
    * True to emulate internet disconnection.
    */
    public final Boolean offline;

    /**
    * Minimum latency from request sent to response headers received (ms).
    */
    public final java.math.BigDecimal latency;

    /**
    * Maximal aggregated download throughput (bytes/sec). -1 disables download throttling.
    */
    public final java.math.BigDecimal downloadThroughput;

    /**
    * Maximal aggregated upload throughput (bytes/sec).  -1 disables upload throttling.
    */
    public final java.math.BigDecimal uploadThroughput;

    /**
    * Connection type if known.
    */
    public final jpuppeteer.cdp.client.constant.network.ConnectionType connectionType;

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

}