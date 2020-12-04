package jpuppeteer.cdp.client.domain;

/**
*/
public class Performance {

    private jpuppeteer.cdp.CDPSession session;

    public Performance(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Disable collecting and reporting metrics.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Performance.disable", null);
    }


    /**
    * Enable collecting and reporting metrics.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Performance.enable", null);
    }


    /**
    * Sets time domain to use for collecting and reporting duration metrics. Note that this must be called before enabling metrics collection. Calling this method while metrics collection is enabled returns an error.
    * experimental
    */
    public io.netty.util.concurrent.Future setTimeDomain(jpuppeteer.cdp.client.entity.performance.SetTimeDomainRequest request) {
        return session.send("Performance.setTimeDomain", request);
    }


    /**
    * Retrieve current values of run-time metrics.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.performance.GetMetricsResponse> getMetrics() {
        return session.send("Performance.getMetrics", null, jpuppeteer.cdp.client.entity.performance.GetMetricsResponse.class);
    }

}