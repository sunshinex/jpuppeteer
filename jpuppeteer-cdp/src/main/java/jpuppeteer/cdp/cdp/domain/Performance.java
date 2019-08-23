package jpuppeteer.cdp.cdp.domain;

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
    public void disable(int timeout) throws Exception {
        session.send("Performance.disable", null, timeout);
    }


    /**
    * Enable collecting and reporting metrics.
    */
    public void enable(int timeout) throws Exception {
        session.send("Performance.enable", null, timeout);
    }


    /**
    * Sets time domain to use for collecting and reporting duration metrics. Note that this must be called before enabling metrics collection. Calling this method while metrics collection is enabled returns an error.
    */
    public void setTimeDomain(jpuppeteer.cdp.cdp.entity.performance.SetTimeDomainRequest request, int timeout) throws Exception {
        session.send("Performance.setTimeDomain", request, timeout);
    }


    /**
    * Retrieve current values of run-time metrics.
    */
    public jpuppeteer.cdp.cdp.entity.performance.GetMetricsResponse getMetrics(int timeout) throws Exception {
        return session.send("Performance.getMetrics", null, jpuppeteer.cdp.cdp.entity.performance.GetMetricsResponse.class, timeout);
    }

}