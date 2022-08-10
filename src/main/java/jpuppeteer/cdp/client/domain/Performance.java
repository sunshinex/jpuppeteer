package jpuppeteer.cdp.client.domain;

/**
*/
public class Performance {

    private jpuppeteer.cdp.CDPConnection connection;

    public Performance(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Disable collecting and reporting metrics.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("Performance.disable", null);
    }


    /**
    * Enable collecting and reporting metrics.
    */
    public jpuppeteer.util.XFuture<?> enable(jpuppeteer.cdp.client.entity.performance.EnableRequest request) {
        return connection.send("Performance.enable", request);
    }


    /**
    * Sets time domain to use for collecting and reporting duration metrics. Note that this must be called before enabling metrics collection. Calling this method while metrics collection is enabled returns an error.
    * experimental
    */
    @java.lang.Deprecated
    public jpuppeteer.util.XFuture<?> setTimeDomain(jpuppeteer.cdp.client.entity.performance.SetTimeDomainRequest request) {
        return connection.send("Performance.setTimeDomain", request);
    }


    /**
    * Retrieve current values of run-time metrics.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.performance.GetMetricsResponse> getMetrics() {
        return connection.send("Performance.getMetrics", null, jpuppeteer.cdp.client.entity.performance.GetMetricsResponse.class);
    }

}