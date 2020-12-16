package jpuppeteer.cdp.client.entity.performance;

/**
*/
public class GetMetricsResponse {

    /**
    * Current values for run-time metrics.
    */
    public final java.util.List<Metric> metrics;

    public GetMetricsResponse(java.util.List<Metric> metrics) {
        this.metrics = metrics;
    }

}