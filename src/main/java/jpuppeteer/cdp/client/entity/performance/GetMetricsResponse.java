package jpuppeteer.cdp.client.entity.performance;

/**
*/
public class GetMetricsResponse {

    /**
    * Current values for run-time metrics.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.performance.Metric> metrics;

    public void setMetrics (java.util.List<jpuppeteer.cdp.client.entity.performance.Metric> metrics) {
        this.metrics = metrics;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.performance.Metric> getMetrics() {
        return this.metrics;
    }

    public GetMetricsResponse(java.util.List<jpuppeteer.cdp.client.entity.performance.Metric> metrics) {
        this.metrics = metrics;
    }

    public GetMetricsResponse() {
    }

}