package jpuppeteer.cdp.client.entity.performance;

/**
* Current values of the metrics.
*/
public class MetricsEvent {

    /**
    * Current values of the metrics.
    */
    public final java.util.List<Metric> metrics;

    /**
    * Timestamp title.
    */
    public final String title;

    public MetricsEvent(java.util.List<Metric> metrics, String title) {
        this.metrics = metrics;
        this.title = title;
    }

}